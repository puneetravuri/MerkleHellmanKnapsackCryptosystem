package assignment1;

import java.math.BigInteger;

/**
 * Singly Linked List that holds BigInteger objects
 *
 * @author vravuri
 */
public class BigIntegerLinkedList {

    private BigIntegerNode head;
    private BigIntegerNode tail;

    /**
     * Default constructor for BigIntegerLinkedList
     */
    public BigIntegerLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Adds a new node to the end of the linked list <br><br> Running Time (all
     * cases): Big Theta(1) <br> Pre-Condition: none <br> Post-Condition: none
     * <br>
     *
     * @param newNumber The value that will be stored in the new node
     */
    public void addNode(BigInteger newNumber) {
        BigIntegerNode newNode = new BigIntegerNode(newNumber, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    /**
     * Counts the number of nodes in the linked list <br><br> Running Time (all
     * cases): Big Theta(n) <br> Pre-Condition: none <br> Post-Condition: none
     * <br>
     *
     * @return Count of the number of nodes in the linked list
     */
    public int countNodes() {
        int count = 1;
        if (this.head == null) {
            return 0;
        }
        BigIntegerNode iterator = this.head;
        while ((iterator = iterator.getNext()) != null) {
            count++;
        }
        return count;
    }

    /**
     * Finds the first occurrence of the value and deletes the nodes from the
     * linked list <br><br> Best Case Running Time: Big Theta(1) <br> Worst Case
     * Running Time: Big Theta(n) <br> Pre-Condition: The linked list should not
     * be empty <br> Post-Condition: none <br>
     *
     * @param newNumber The value that has to be removed from the linked list
     * @return true if the value is successfully deleted and false otherwise
     */
    public boolean removeNode(BigInteger newNumber) {
        if (this.head == null) {
            return false;
        }

        BigIntegerNode iterator = this.head;
        BigIntegerNode prev = null;
        do {
            if (iterator.getData().equals(newNumber)) {
                if (prev == null) { // If the node is head, we shift the head reference
                    this.head = iterator.getNext();
                } else {
                    prev.setNext(iterator.getNext());
                }
                return true;
            }
            prev = iterator;
        } while ((iterator = iterator.getNext()) != null);

        return false;
    }

    /**
     * Checks if the linked list is empty<br><br> Running Time (all cases): Big
     * Theta(1)<br> Pre-Condition: none <br> Post-Condition: none <br>
     *
     * @return true if list is empty and false otherwise
     */
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the node that is present at the index location<br><br> Best Case
     * Running Time: Big Theta(1)<br> Worst Case Running Time: Big Theta(n)<br>
     * Pre-Condition: The linked list should not be empty <br> Post-Condition:
     * none <br>
     *
     * @param index Index location whose node has to be returned
     * @return The node that is present in index location
     */
    public BigIntegerNode get(int index) {
        if (head == null) {
            return null;
        }

        BigIntegerNode iterator = head;
        for (int i = 0; i < index; i++) {
            iterator = iterator.getNext();
            if (iterator == null) {
                return null;
            }
        }
        return iterator;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Contents are : ");
        BigIntegerNode iterator = this.head;

        if (iterator == null) {
            buffer.append("none");
            return buffer.toString();
        }

        do {
            buffer.append(iterator.getData()).append(", ");
        } while ((iterator = iterator.getNext()) != null);
        buffer.deleteCharAt(buffer.length() - 2);
        return buffer.toString();
    }
}
