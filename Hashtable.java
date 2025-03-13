/*
 * Defines an abstract hash table class using an array of HashObject and all of the common hash table 
 * functionality should be in this abstract parent class and the subclasses would only have the functionality 
 * that is specific to the subclasses.
 * For example, the insert and search methods should be in the base Hashtable class.
 * 
 * 
 * 
 */

 import java.util.Arrays;

 public abstract class Hashtable {
    protected HashObject[] table;
    protected int capacity;
    protected int size;

    public Hashtable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new HashObject[capacity];
    }

    protected int hash(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public boolean insert(Object key) {
        int index = findSlot(key);
        if (index == -1) return false; 

        if (table[index] == null) {
            table[index] = new HashObject(key);
            size++;
        } else {
            HashObject hashObject = table[index];
            hashObject.incrementFrequencyCount();
        }
        return true;
    }

    public Object search(Object key) {
        int index = findSlot(key);
        return (index != -1) ? table[index].getKey() : null;
    }

    public int getSize() {
        return size;
    }

    // Abstract method to be implemented in subclasses
    protected abstract int findSlot(Object key);
}
