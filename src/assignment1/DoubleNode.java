package assignment1;

/**
 * Represents a node of a doubly linked list that holds a character
 *
 * @author vravuri
 */
public class DoubleNode {

    private char data;
    private DoubleNode previous;
    private DoubleNode next;

    /**
     * Default constructor of DoubleNode
     */
    public DoubleNode() {
        previous = null;
        next = null;
    }

    /**
     * Parameterized constructor that takes the reference to previous node, data
     * to be stored in the node and reference to the next node
     *
     * @param p Reference to previous node in the linked list
     * @param ch Value of the character to be stored in the node
     * @param n Reference to next node in the linked list
     */
    public DoubleNode(DoubleNode p, char ch, DoubleNode n) {
        this.previous = p;
        this.next = n;
        this.data = ch;
    }

    /**
     * Returns the value of the character that is stored in the node <br><br>
     * Running Time (all cases): Big Theta(1) <br> Pre-Condition: none <br>
     * Post-Condition: none <br>
     *
     * @return Value of the character
     */
    public char getC() {
        return this.data;
    }

    /**
     * Returns the next node that this node is referring to in the linked list
     * <br><br> Running Time (all cases): Big Theta(1) <br> Pre-Condition: The
     * node should not be the tail of the linked list <br> Post-Condition: none
     * <br>
     *
     * @return The reference to the next node in the linked list
     */
    public DoubleNode getNext() {
        if (this.next == null) {
            return null;
        }
        return this.next;
    }

    /**
     * Returns the previous node that this node is referring to in the linked
     * list <br><br> Running Time (all cases): Big Theta(1) <br> Pre-Condition:
     * The node should not be the head of the linked list <br> Post-Condition:
     * none <br>
     *
     * @return The reference to the previous node in the linked list
     */
    public DoubleNode getPrev() {
        if (this.previous == null) {
            return null;
        }
        return this.previous;
    }

    /**
     * Sets the value of the character in the node to c<br><br> Running Time
     * (all cases): Big Theta(1) <br> Pre-Condition: none <br> Post-Condition:
     * none <br>
     *
     * @param c Value of the character to be set to the node
     */
    public void setC(char c) {
        this.data = c;
    }

    /**
     * Sets the node passed as its next node in the linked list <br><br> Running
     * Time (all cases): Big Theta(1) <br> Pre-Condition: none <br>
     * Post-Condition: none <br>
     *
     * @param next Node to be set as next node
     */
    public void setNext(DoubleNode next) {
        this.next = next;
    }

    /**
     * Sets the node passed as its previous node in the linked list <br><br>
     * Running Time (all cases): Big Theta(1) <br> Pre-Condition: none <br>
     * Post-Condition: none <br>
     *
     * @param prev Node to be set as previous node
     */
    public void setPrev(DoubleNode prev) {
        this.previous = prev;
    }

    @Override
    public String toString() {
        return Character.toString(this.data);
    }

    /**
     * Test driver for DoubleNode class
     *
     * @param args
     */
    public static void main(String[] args) {
    }
}
