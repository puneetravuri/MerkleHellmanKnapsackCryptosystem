package assignment1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * This is a test driver class for MerkelHellmanKnapsackEncryption
 *
 * @author vravuri
 */
public class MerkleHellmanTest {

    /**
     * Test driver for MerkelHellmanKnapsackEncryption algorithm
     * @param args
     */
    public static void main(String[] args) {
        MerkleHellmanKnapsackEncryption m = new MerkleHellmanKnapsackEncryption();

        Scanner scan = new Scanner(System.in);
        String input = new String();
        do {
            System.out.println("Enter a string and I will encrypt it in a single number:");
            input = scan.nextLine();
            System.out.println("Clear text: " + input);
            System.out.println("Number of clear text bytes = " + input.length());
            if (input.length() > 80) {
                System.out.println("Maximum character length allowed is 80. Please enter again.");
            }
        } while (input.length() > 80);
        byte[] inputBytes = input.getBytes();
        BigInteger encryptedMessage = m.encrypt(inputBytes);
        System.out.println("\"" + input + "\" " + "is encryped as " + encryptedMessage);

        byte[] outputBytes = m.decrypt(encryptedMessage);
        System.out.println("Result of decryption: " + new String(outputBytes));
    }
}
