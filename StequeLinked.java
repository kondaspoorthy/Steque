/*
 *  File: Steque.java
 *  Author: 
 *  Date: 18th Nov, 2021
 *  ---------------------------------------
 *  Steque is stack-ended queue data structure which supports
 *  stack operations: pop and push, along with queue enqueue 
 *  operation.
 *  
 *  Salient features:
 *  1. Operations like push, pop, enqueue are supported.
 *  2. NullPointerException is thrown when null element is inserted.
 *  3. UnsupportedOperationException is thrown when using remove() method.
 *  4. The data structure is iterable and is implemented for generic type.
 *  
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * Steque is a stack-ended data structure which 
 * supports stack operations as well as queue's 
 * enqueue operation.
 * 
 * @author 
 * @version 1.0
 *
 */
public class Steque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
   // private Node<Item> last1;
    //private Node<Item> last2;
    private int n;
    //private int n1;
    public class Node<Item>{
        Item item;
        Node<Item> next;
    }
    /**
     * constructs a steque object.
     */
    public Steque() {
        first=null;
        last=null;
        n=0;
        //n1=0;


    }
    
    
    /**
     * inserts an item in the steque in queue fashion.
     * @param item Item to be inserted.
     */
    public void enqueue(Item item) {
        if(item==null) throw new IllegalArgumentException();
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item=item;
        last.next=null;
        if(isEmpty()) first=last;
        else{
            oldlast.next=last;
        }
        n++;
        //n1++;

    }
    
    
    /**
     * inserts an item in the steque in stack fashion.
     * @param item Item to be inserted.
     */
    public void push(Item item) {
        if(item==null) throw new IllegalArgumentException();
        Node<Item> oldfirst=first;
        first=new Node<Item>();
        first.item=item;
        if(last==null&& oldfirst==null){
            last=first;
            //last2=first;
        }
        first.next=oldfirst;
        n++;

    }
    
    /**
     * pops a least recent item in steque.
     * @return Item object from steque.
     */
    public Item pop() {
        if(isEmpty())  throw new  NoSuchElementException();
        Item item =first.item;
        first=first.next;
        n--;
        return item;

       

    }
    
    /**
     * checks to see if steque is empty.
     * @return true if steque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first==null;

    }
    
    /**
     * return the number of elements currently in the steque.
     * @return size as integer.
     */
    public int size() {
        return n;

    }
    
    /**
     * returns an iterator over the elements 
     * stored in steque.
     * 
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item>current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item; 

    }
}
}
public class StequeLinked {
    
}
