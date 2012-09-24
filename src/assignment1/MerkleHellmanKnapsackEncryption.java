package assignment1;

import java.math.BigInteger;
import java.util.Random;

/**
 * Implementation of Merkle Hellman Knapsack Encryption algorithm. Supports
 * encryption and decryption of data of size upto 80 bytes
 *
 * @author vravuri
 */
public class MerkleHellmanKnapsackEncryption {

    private BigIntegerLinkedList w;
    private BigIntegerLinkedList b;
    private BigInteger q;
    private BigInteger r;
    private int inputSize = 640; // Input size will be overridden by encrypt

    /**
     * Default constructor for MerkleHellmanKnapsackEncryption
     */
    public MerkleHellmanKnapsackEncryption() {
        w = new BigIntegerLinkedList();
        b = new BigIntegerLinkedList();
    }

    /**
     * Encrypts the input byte array using Merkle Hellman Knapsack Encryption
     * algorithm<br><br> Running Time (all cases): Big Theta(n^2) <br>
     * Pre-Condition: Input cannot be more than 80 bytes <br> Post-Condition:
     * The final encrypted number will be a single BigInteger <br>
     *
     * @param input The byte array that needs to be encrypted
     * @return Encrypted BigInteger value
     */
    public BigInteger encrypt(byte[] input) {
        if (input.length > 80) {
            return null;
        }

        // Generate keys based on input data size
        generateKeys(input.length * 8);

        // This BigInteger will hold the encrypted number
        BigInteger encryptedMessage = new BigInteger("0");
        byte mask = 0x01;

        // The input size is persisted in the object so that decryption functionality 
        // knows the input size
        inputSize = input.length * 8;

        // Iterate through the input data and create the encrypted number. 
        // If a particular bit of the input bytes is 1, the corresponding index 
        // in the public key (b) will be added to the encryped number
        for (int i = 0; i < input.length; i++) {
            byte inputByte = input[i];
            for (int j = 0; j < 8; j++) {
                BigInteger bValue = b.get(i * 8 + 7 - j).getData();
                if ((inputByte & (mask << j)) != 0) {
                    encryptedMessage = encryptedMessage.add(bValue);
                }
            }
            mask = 0x01;
        }

        return encryptedMessage;
    }

    /**
     * Decrypts the BigInteger number based on Merkle Hellman Knapsack
     * Encryption algorithm and returns the original data <br><br> Running Time
     * (all cases): Big Theta(n^2) <br> Pre-Condition: The same keys used for
     * encryption should be used for decryption<br> Post-Condition: All the bits
     * of the output byte array have to be populated with corresponding value
     * <br>
     *
     * @param output The encrypted number that needs to be decrypted
     * @return The original data that has been decrypted
     */
    public byte[] decrypt(BigInteger output) {

        BigInteger b1 = output.mod(q);
        BigInteger b2 = r.modInverse(q);
        BigInteger b3 = b1.multiply(b2);

        // This value is the result after performing the modular inverse
        BigInteger value = b3.mod(q);

        // This array will hold the bits that will be later converted to a byte array
        int[] bitMask = new int[inputSize];

        // The private key will be iterated from the end. For the first number 
        // which is less than value, the corresponding index in bitMask 
        // will be set to 1. This process is continued until value becomes 0.
        for (int i = inputSize - 1; value.compareTo(new BigInteger("0")) != 0; i--) {
            BigInteger keyValue = w.get(i).getData();
            if (value.compareTo(keyValue) >= 0) {
                value = value.subtract(keyValue);
                bitMask[i] = 1;
            }
        }

        // The bitMask content is moved into this byte array. 
        // This will be the decrypted content.
        byte[] decrypted = new byte[bitMask.length / 8];
        byte mask = 0x01;

        for (int i = 0; i < bitMask.length; i++) {
            if (bitMask[i] == 1) {
                decrypted[i / 8] = (byte) (decrypted[i / 8] | (mask << (7 - i % 8)));
            }
            mask = 0x01;
        }

        return decrypted;
    }

    // Generates keys based on input data size
    private void generateKeys(int inputSize) {
        // Generating values for w
        // This first value of the private key (w) is set to 1
        w.addNode(new BigInteger("1"));
        for (int i = 1; i < inputSize; i++) {
            w.addNode(nextSuperIncreasingNumber(w));
        }
        // Generate value for q
        q = nextSuperIncreasingNumber(w);

        // Generate value for r
        Random random = new Random();
        // Generate a value of r such that r and q are coprime
        do {
            r = q.subtract(new BigInteger(random.nextInt(1000) + ""));
        } while ((r.compareTo(new BigInteger("0")) > 0) && (q.gcd(r).intValue() != 1));

        // Generate b such that b = w * r mod q
        for (int i = 0; i < inputSize; i++) {
            b.addNode(w.get(i).getData().multiply(r).mod(q));
        }
    }

    // This method generates the next super increasing number based on randomness
    private BigInteger nextSuperIncreasingNumber(BigIntegerLinkedList list) {
        BigIntegerNode node;
        BigInteger sum = new BigInteger("0"); // Initialize sum to 0
        int i = 0;

        // Get the sum of numbers in w
        while ((node = list.get(i)) != null) {
            sum = sum.add(node.getData());
            i++;
        }
        Random random = new Random();

        // The newly generated number will be sum of contents of w plus a 
        // random number between 1 and 6. This is to ensure both randomness 
        // and to keep the sum not going far lengthy.
        return sum.add(new BigInteger(random.nextInt(5) + 1 + ""));
    }
}
