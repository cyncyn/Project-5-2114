package prj5;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class sorts all songs by name, title, year,
 * and genre
 * @author lchar16
 * @version 2017.04.15
 *
 */
public class SongList {

    //~ Fields------------------------
    private Node<Song> firstSong;
    private int size;
    
    //~ Constructor------------------
    /**
     * new empty SongList
     */
    public SongList()
    {
        size = 0;
        firstSong = null;
    }
    
    //~ Methods------------------
    /**
     * adds the song to the list
     * @param newSong the new song to be added
     */
    public void add(Song newSong)
    {
        if (newSong == null)
        {
            throw new IllegalArgumentException();
        }
        
        if (isEmpty())
        {
            firstSong = new Node<Song>(newSong);
        }
        else
        {
            Node<Song> song = new Node<Song>(newSong);
            song.setNext(firstSong);
            firstSong = song;
        }
        size++;
    }
    
    /**
     * 
     * @return how many songs are in the list
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * 
     * @return whether or not the list is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * empties the list
     */
    public void clear()
    {
        if (firstSong != null)
        {
            firstSong.setNext(null);
            firstSong = null;
            size = 0;
        }
    }
    
    /**
     * @return a string of all songs in the list
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Song List of " + size + " songs.\n");
        Node<Song> curr = firstSong;
        int i = 1;
        while (curr != null)
        {
            builder.append("SONG " + i + " - ");
            builder.append(curr.getData().toString());
            builder.append("\n");
            curr = curr.next();
            i++;
        }
        return builder.toString();
    }
    
    /*
     * @return an Iterator object to iterate through
     * the list of Songs
     */
    public Iterator<Song> iterator()
    {
        return new SongIterator();
    }
    
    /**
     * sorts songs according to the type indicated
     * @param type the type of sorting category
     * @return the first song in the sorted list, since 
     * it may have changed
     */
    public Node<Song> sortSongs(SortType type)
    {
        if ((firstSong != null) && (firstSong.next() != null))
        {
            Node<Song> unsortedPart = firstSong.next();
            firstSong.setNext(null);
            while (unsortedPart != null)
            {
                Node<Song> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                firstSong = insertInOrder(firstSong, nodeToInsert, type);
            }
        }
        return firstSong;
    }
    
    /**
     * Helper method for sort method
     * puts the given node into the right position
     * @param first the first node of the sorted part
     * @param insertNode the node to be put into the right position
     * in the sorted part
     * @return the first song in the list, since it may have changed
     */
    private Node<Song> insertInOrder(Node<Song> first, Node<Song> insertNode, SortType type)
    {
        Song item = insertNode.getData();
        Node<Song> curr = first;
        Node<Song> previous = null;
        
        switch (type)
        {
            case title:
            {
                while ((curr != null) && (
                    item.getTitle().compareTo(curr.getData().getTitle()) > 0))
                {
                    previous = curr;
                    curr = curr.next();
                }
                break;
            }
            case artist:
            {
                while ((curr != null) && (
                    item.getArtist().compareTo(curr.getData().getArtist()) >= 0))
                {
                    previous = curr;
                    curr = curr.next();
//                    if ((curr != null) && (
//                        item.getArtist().compareTo(curr.getData().getArtist()) == 0))
//                    {
//                        while (item.getTitle().compareTo(curr.getData().getTitle()) > 0)
//                        {
//                            previous = curr;
//                            curr = curr.next();
//                        }
//                    }
                }
                
                break;
            }
            case genre:
            {
                while ((curr != null) && (
                    item.getGenre().compareTo(curr.getData().getGenre()) > 0))
                {
                    previous = curr;
                    curr = curr.next();
                }
                break;
            }
            case year:
            {
                while ((curr != null) && item.getYear() > curr.getData().getYear())
                {
                    previous = curr;
                    curr = curr.next();
                }
            }
        }
        
        if (previous != null)
        {
            previous.setNext(insertNode);
            insertNode.setNext(curr);
        }
        else
        {
            insertNode.setNext(first);
            first = insertNode;
        }
        
        return first;
    }
    /**
     * Nodes allow objects in the StudentList and SongList
     * to be connected together
     * @author lchar16
     * @version 2017.04.15
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
    
    /**
     * Nested class in StudetList, it iterates through
     * the elements in the list
     * 
     * @author lchar16
     * @version 2017.04.15
     *
     * @param <Song>
     *            the type of objects in the iterator
     */
    private class SongIterator implements Iterator<Song> {

        // ~ Fields-----------------------
        private Node<Song> nextNode;
        //private boolean nextCalled;


        /**
         * Creates a new DLListIterator
         */
        public SongIterator() {
            if (isEmpty()) {
                nextNode = null;
            }
            else {
                nextNode = firstSong;
            }
            //nextCalled = false;
        }


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
        public Song next() {
            if (hasNext()) {
                //nextCalled = true;
                Node<Song> returnNode = nextNode;
                nextNode = nextNode.next();
                return returnNode.getData();
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }
}
