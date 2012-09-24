package assignment1;

import java.math.BigInteger;

/**
 * Singly Linked List node that holds BigInteger objects
 * @author vravuri
 */
public class BigIntegerNode {

    private BigInteger data;
    private BigIntegerNode next;

    /**
     * Default constructor for BigIntegerNode
     */
    public BigIntegerNode() {
        data = null;
        next = null;
    }

    /**
     * Parameterized constructor for BigIntegerNode that takes the data and next
     * node
     *
     * @param data
     * @param next
     */
    public BigIntegerNode(BigInteger data, BigIntegerNode next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Gets the data stored in the node <br><br> Running Time (all cases): Big
     * Theta(1) <br> Pre-Condition: none <br> Post-Condition: none <br>
     *
     * @return BigInteger value that the node stores
     */
    public BigInteger getData() {
        return this.data;
    }

    /**
     * Gets the next node pointed by this node <br><br> Running Time (all
     * cases): Big Theta(1) <br> Pre-Condition: none <br> Post-Condition: none
     * <br>
     *
     * @return Node that this node is referring to
     */
    public BigIntegerNode getNext() {
        if (this.next == null) {
            return null;
        }
        return this.next;
    }

    /**
     * Sets the data stored in the node<br><br> Running Time (all cases): Big
     * Theta(1) <br> Pre-Condition: none <br> Post-Condition: none <br>
     *
     * @param data Value to be set for this node
     */
    public void setData(BigInteger data) {
        this.data = data;
    }

    /**
     * Sets the next node of this node <br><br> Running Time (all cases): Big
     * Theta(1) <br> Pre-Condition: none <br> Post-Condition: none <br>
     *
     * @param next The node that this current node has to refer to
     */
    public void setNext(BigIntegerNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
