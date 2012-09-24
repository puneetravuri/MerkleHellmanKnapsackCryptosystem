package assignment1;

/**
 * Represents a doubly linked list that is a list of DoubleNode objects
 *
 * @author vravuri
 */
public class DoublyLinkedList {

    private DoubleNode head;
    private DoubleNode tail;

    /**
     * Default constructor that sets the head and tail of the linked list to
     * null
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Adds a new node to the end of the linked list and stores the character c
     * in this node.<br><br> Running Time (all cases): Big Theta(1) <br>
     * Pre-Condition: none<br> Post-Condition: none<br>
     *
     * @param c Value of the node that is added to the end of linked list
     */
    public void addCharAtEnd(char c) {
        // New node created and its references will be set accordingly.
        DoubleNode newNode = new DoubleNode(this.tail, c, null);
        if (this.tail != null) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            this.head = this.tail = newNode;
        }
    }

    /**
     * Adds a new node to the beginning of the linked list and stores the
     * character c in this node.<br><br> Running Time (all cases): Big Theta(1)
     * <br> Pre-Condition: none<br> Post-Condition: none<br>
     *
     * @param c
     */
    public void addCharAtFront(char c) {
        // New node created and its references will be set accordingly.
        DoubleNode newNode = new DoubleNode(null, c, this.head);
        if (this.head != null) {
            this.head.setPrev(newNode);
            this.head = newNode;
        } else {
            this.head = this.tail = newNode;
        }
    }

    /**
     * Count the nodes of the linked list <br><br> Running Time (all cases): Big
     * Theta(n) <br> Pre-Condition: none <br> Post-Condition: none <br>
     *
     * @return Count of the nodes in the list
     */
    public int countNodes() {
        int count = 1;
        if (this.head == null) {
            return 0;
        }
        DoubleNode iterator = this.head;
        while ((iterator = iterator.getNext()) != null) {
            count++;
        }
        return count;
    }

    /**
     * Deletes the first character of the character c from the list <br><br>
     * Best Case Running Time: Big Theta(1) <br>Worst Case Running Time: Big
     * Theta(n) <br> Pre-Condition: The list should not be empty <br>
     * Post-Condition: none <br>
     *
     * @param c The character to be deleted
     * @return true if the character was deleted and false otherwise
     */
    public boolean deleteChar(char c) {
        if (this.head == null) {
            return false;
        }
        DoubleNode iterator = this.head;
        // Iterate through the list. When the first match is found, 
        // set the references appropriately.
        do {
            if (iterator.getC() == c) {
                if (iterator.getNext() != null) {
                    iterator.getNext().setPrev(iterator.getPrev());
                } else { // The found node is the tail node. So, resetting tail appropriately.
                    this.tail = iterator.getPrev();
                }
                if (iterator.getPrev() != null) {
                    iterator.getPrev().setNext(iterator.getNext());
                } else { // The found node is the head node. So, resetting head appropriately.
                    this.head = iterator.getNext();
                }
                return true;
            }
        } while ((iterator = iterator.getNext()) != null);
        return false;
    }

    /**
     * Returns true if the list is empty false otherwise<br><br> Running Time
     * (all cases): Big Theta(1)<br> Pre-Condition: none<br> Post-Condition:
     * none<br>
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
     * Remove and return the character at the end of the doubly linked
     * list<br><br> Running Time (all cases): Big Theta(1)<br> Pre-Condition:
     * The list should not be empty<br> Post-Condition: none<br>
     *
     * @return The character at the end that was deleted from the list
     */
    public char removeCharAtEnd() {
        if (this.tail == null) {
            // Since the list is empty, printing an error message and returning 
            // an empty space character.
            System.err.println("The list should not be empty");
            return ' ';
        }

        // Storing the character before removing its references.
        char endChar = this.tail.getC();
        if (this.tail.getPrev() != null) {
            this.tail.getPrev().setNext(null);
        } else {
            this.head = null;
        }
        this.tail = this.tail.getPrev();

        return endChar;
    }

    /**
     * Remove and return the character from the front of the doubly linked
     * list<br><br> Running Time (all cases): Big Theta(1)<br> Pre-Condition:
     * The list should not be empty<br> Post-Condition: none<br>
     *
     * @return The character from the front that was deleted from the list
     */
    public char removeCharFromFront() {
        if (this.head == null) {
            // Since the list is empty, printing an error message and 
            // returning an empty space character.
            System.err.println("The list should not be empty");
            return ' ';
        }

        // Storing the character before removing its references.
        char frontChar = this.head.getC();
        if (this.head.getNext() != null) {
            this.head.getNext().setPrev(null);
        } else {
            this.tail = null;
        }
        this.head = this.head.getNext();
        return frontChar;
    }

    /**
     * Reverse the linked list<br><br> Running Time (all cases): Big
     * Theta(n)<br> Pre-Condition: none<br> Post-Condition: none<br>
     *
     */
    public void reverse() {
        if (this.head == null) {
            return;
        }
        DoubleNode iterator = this.head;
        DoubleNode temp;

        // Iterating through the list and setting the references of each node.
        do {
            temp = iterator.getNext();
            iterator.setNext(iterator.getPrev());
            iterator.setPrev(temp);
        } while ((iterator = iterator.getPrev()) != null);

        // Finally, head and tail node references will be swapped.
        temp = head;
        head = tail;
        tail = temp;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Contents are : ");
        DoubleNode iterator = this.head;

        // If the list is null, then the string "none" will be added to the buffer.
        if (iterator == null) {
            buffer.append("none");
            return buffer.toString();
        }

        // Iterating through the list and appending the contents to the string buffer.
        do {
            buffer.append(iterator.getC()).append(", ");
        } while ((iterator = iterator.getNext()) != null);
        buffer.deleteCharAt(buffer.length() - 2);
        return buffer.toString();
    }

    /**
     * Test driver for DoublyLinkedList class
     *
     * @param args
     */
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addCharAtEnd('H');
        list.addCharAtEnd('e');
        list.addCharAtEnd('l');
        list.addCharAtEnd('l');
        list.addCharAtEnd('o');
        System.out.println(list);
        System.out.println("Deleting l");
        list.deleteChar('l');
        System.out.println(list);
        System.out.println("Deleting H");
        list.deleteChar('H');
        System.out.println(list);
        System.out.println("Deleting o");
        list.deleteChar('o');
        System.out.println(list);
        System.out.println("Deleting e");
        list.deleteChar('e');
        System.out.println(list);
        System.out.println("Deleting l");
        list.deleteChar('l');
        System.out.println(list);
        list.addCharAtFront('o');
        list.addCharAtFront('l');
        list.addCharAtFront('l');
        list.addCharAtFront('e');
        list.addCharAtFront('H');
        System.out.println(list);

        System.out.println(list.countNodes());

        System.out.println("Popping everything");
        while (!list.isEmpty()) {
            System.out.println(list.removeCharFromFront());
        }

        list.addCharAtFront('o');
        list.addCharAtFront('l');
        list.addCharAtFront('l');
        list.addCharAtFront('e');
        list.addCharAtFront('H');

        System.out.println("Popping everything from the end");
        while (!list.isEmpty()) {
            System.out.println(list.removeCharAtEnd());
        }
        System.out.println(list.countNodes());

        list.addCharAtEnd('o');
        list.addCharAtEnd('l');
        list.addCharAtEnd('l');
        list.addCharAtEnd('e');
        list.addCharAtEnd('H');

        list.reverse();
        System.out.println(list);

        list.reverse();
        System.out.println(list);
    }
}
