package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * StudentList keeps track of all the students in the
 * file
 * 
 * @author lchar16
 * @version 2017.04.13
 *
 */
public class StudentList {
    // ~ Fields---------------------
    private Node<Student> firstNode;
    private int size;


    // ~ Constructor------------------
    /**
     * Creates a new empty StudentList
     */
    public StudentList() {
        firstNode = null;
        size = 0;
    }


    // ~ Methods------------------------
    /**
     * returns the size of the list
     * 
     * @return the size of the list
     */
    public int size() {
        return size;
    }


    /**
     * adds the student to the front of the list
     * 
     * @param student
     *            Student to be added
     */
    public void add(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty()) {
            firstNode = new Node<Student>(student);
        }
        else {
            Node<Student> st = new Node<Student>(student);
            st.setNext(firstNode);
            firstNode = st;
        }
        size++;

    }


    /**
     * Checks whether or not the list is empty
     * 
     * @return if the list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * empties the list
     */
    public void clear() {
        if (firstNode != null) {
            firstNode.setNext(null);
            firstNode = null;
            size = 0;
        }
    }


    /**
     * returns all the students in the list
     * concatenated in a string
     * 
     * @return String of the students in the list
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("List of " + size() + " Students.\n");
        Node<Student> curr = firstNode;
        int i = 1;
        while (curr != null) {
            builder.append("STUDENT " + i + " - ");
            builder.append(curr.getData().toString());
            builder.append("\n");
            curr = curr.next();
            i++;
        }
        return builder.toString();
    }


    /**
     * Creates a StudentIterator to iterate through the StudentList
     * 
     * @return an Iterator object to iterate through
     *         the list of students
     */
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }


    /**
     * Nodes allow objects in the StudentList and SongList
     * to be connected together
     * 
     * @author lchar16
     * @version 2017.04.15
     *
     * @param <E>
     *            the type of object in the node
     */
    public class Node<E> {

        // ~ Fields-------------------------
        private E data;
        private Node<E> next;


        // ~ Constructor----------------------
        /**
         * A new Node object with data entry
         * 
         * @param entry
         *            is the data it stores
         */
        public Node(E entry) {
            data = entry;
        }


        // ~ Methods------------------------
        /**
         * links the node to the next one
         * 
         * @param nextNode
         *            is the node this one will point to
         */
        public void setNext(Node<E> nextNode) {
            next = nextNode;
        }


        /**
         * Returns the next node in the list
         * 
         * @return the next node in the list
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the data in the node
         * 
         * @return data that this node stores
         */
        public E getData() {
            return data;
        }
    }


    /**
     * Nested class in StudetList, it iterates through
     * the elements in the list
     * 
     * @author lchar16
     * @version 2017.04.15
     *
     * @param <Student>
     *            the type of objects in the iterator
     */
    private class StudentIterator implements Iterator<Student> {

        // ~ Fields-----------------------
        private Node<Student> nextNode;


        // ~ Constructor------------------
        /**
         * Creates a new StudentIterator
         */
        public StudentIterator() {
            if (isEmpty()) {
                nextNode = null;
            }
            else {
                nextNode = firstNode;
            }
        }


        // ~ Methods------------------------
        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            else {
                return nextNode != null;
            }
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public Student next() {
            if (hasNext()) {
                Node<Student> returnNode = nextNode;
                nextNode = nextNode.next();
                return returnNode.getData();
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }

}
