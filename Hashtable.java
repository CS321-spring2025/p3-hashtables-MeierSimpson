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
    private int totalInserts;


    public Hashtable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new HashObject[capacity];
        this.totalInserts = 0;
    }

    
    public int getNewInsertProbes() {
        int newInsertProbes = 0;
        for(int i =0; i<capacity; i++) {
            if (table[i] != null)
              newInsertProbes+= table[i].getProbeCount();
        }
        return newInsertProbes;
    }

    public int getTotalDuplicateInserts() {
        int newInsertProbes = 0;
        for(int i =0; i<capacity; i++) {
            if (table[i] != null)
              newInsertProbes+= table[i].getFrequencyCount();
        }
        return newInsertProbes;
    }

    public HashObject getHashObject(int index) {
        return table[index];
    }
    

    public int getTotalInserts() {
        return totalInserts;
    }

    public double getAvgNumProbes() {
        double retVal = getNewInsertProbes() / size;
        return retVal;
    }

    protected int hash(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public boolean insert(Object key) {
        
        FindSlotResult findSlotResult = findSlot(key);
        int index = findSlotResult.slotNumber;
        int probeCount = findSlotResult.probes;
        if (index == -1) return false; 

        totalInserts++;
        if (table[index] == null) {
            table[index] = new HashObject(key, probeCount);
            size++;
            return true;
        } else {
            HashObject hashObject = table[index];
            hashObject.incrementFrequencyCount();
            return false;
        }
    }

    public Object search(Object key) {
        FindSlotResult findSlotResult = findSlot(key);
        int index = findSlotResult.slotNumber;
        return (index != -1) ? table[index].getKey() : null;
    }

    public int getSize() {
        return size;
    }

    // Abstract method to be implemented in subclasses
    protected abstract FindSlotResult findSlot(Object key);

    record FindSlotResult(boolean success, int slotNumber, int probes, boolean isDuplicate) {}
}
