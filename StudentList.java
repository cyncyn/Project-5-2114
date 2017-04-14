package prj5;


/**
 * StudentList keeps track of all the students in the
 * file 
 * @author lchar16
 * @version 2017.04.13
 *
 */
public class StudentList
{
    //~ Fields---------------------
    private Node<Student> firstNode;
    private int size;
    
    //~ Constructor------------------
    public StudentList()
    {
        firstNode = null;
        size = 0;
    }
    
    //~ Methods------------------------
    /**
     * 
     * @return the size of the list
     */
    public int size()
    {
        return size;
    }
    
    /**
     * adds the student to the front of the list
     * @param student Student to be added
     */
    public void add(Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException();
        }
        
        if (size == 0)
        {
            firstNode = new Node<Student>(student);
        }
        else
        {
            Node<Student> st = new Node<Student>(student);
            st.setNext(firstNode);
            firstNode = st;
        }
        size++;
        
    }
    
//    public void remove(Student student)
//    {
//        Node<Student> curr = firstNode;
//        
//    } do we need an remove method????? 
    
    /**
     * returns the student at that position
     * @param pos Position in the list
     * @return the Student in the position
     */
    public Student get(int pos)
    {
        Node<Student> curr = firstNode;
        int i = 0;
        Student s = null;
        while (curr != null)
        {
            if (i == pos)
            {
                s = curr.getData();
            }
            i++;
            curr = curr.next();
        }
        
        if (s == null)
        {
            throw new IndexOutOfBoundsException();
        }
        return s;
    }
    
//    public boolean contains(Student student)
//    {
//    } do we need contains??!??
    
    /**
     * empties the list
     */
    public void clear()
    {
        if (firstNode != null)
        {
            firstNode.setNext(null);
            firstNode = null;
            size = 0;
        }
    }
    
    /**
     * returns all the students in the list 
     * concatenated in a string
     * @return String of the students in the list
     */
    public String toString()
    {
        
    }
    
    /**
     * 
     * @return an Iterator object to iterate through
     * the list of students
     */
    public Iterator<Student> iterator()
    {
        
    }
    
    /**
     * Nodes allow objects in the StudentList and SongList
     * to be connected together
     * @author lchar16
     *
     * @param <E> the type of object in the node
     */
    public class Node<E> {
        
        //~ Fields-------------------------
        private E data;
        private Node<E> next;

        //~ Constructor----------------------
        /**
         * A new Node object with data entry
         * @param entry is the data it stores
         */
        public Node(E entry)
        {
            data = entry;
        }
        
        /**
         * links the node to the next one
         * @param nextNode is the node this one will point to
         */
        public void setNext(Node<E> nextNode)
        {
            next = nextNode;
        }
        
        /**
         * @return the next node in the list
         */
        public Node<E> next()
        {
            return next;
        }
        
        /**
         * @return data that this node stores
         */
        public E getData()
        {
            return data;
        }
    }


}
