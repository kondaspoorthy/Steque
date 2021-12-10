import java.util.Iterator;
import java.util.NoSuchElementException;
public class Steque1<Item> implements Iterable<Item> {

    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private Item[] a;         // array of items
    private int n;            // number of elements on stack


    /**
     * Initializes an empty stack.
     */
    public Steque1() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
        
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;

        // textbook implementation
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i];
        }
        a = copy;

       // alternative implementation
       // a = java.util.Arrays.copyOf(a, capacity);
    }



    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(Item item) {
        if(item==null) throw new IllegalArgumentException();
        if (n == a.length) resize(2*a.length);    // double size of array if necessary
        a[n++] = item;                            // add item
    }
    public void enqueue(Item item){
        if(item==null) throw new IllegalArgumentException();
        if(n >= a.length) resize (2*a.length);
        for(int i=n;i>0;i--){
            a[i]=a[i-1];
        }
        a[0]=item;
        n++;       
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;

       
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
   


    /**
     * Unit tests the {@code Stack} data type.
     *
     * @param args the command-line arguments
     */
   