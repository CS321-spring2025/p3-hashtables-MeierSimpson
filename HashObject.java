/* 
   Contains a generic key object (declared as Object key), frequency count (to count duplicates), and probe count.
   It needs to override both the equals and the toString methods and should also have a getKey method that returns an Object type. 
   Make sure that the equals method actually compares the key values using the equals method on the keys.
 */

public class HashObject {
    private Object key;
    private int frequencyCount;
    private int probeCount;

    public HashObject(Object key, int probeCount) {
        this.key = key;
        this.frequencyCount = 0;
        this.probeCount = probeCount;
    }

    public Object getKey() {
        return key;
    }

    public void incrementFrequencyCount() {
        frequencyCount++;
    }

    public int getFrequencyCount() {
        return frequencyCount;
    }

    public int getProbeCount() {
        return probeCount;
    }

    @Override
    public boolean equals(Object hashObject) {
        Object key1 = this.key;
        Object key2 = ((HashObject)hashObject).getKey();
        return key1.equals(key2);
    }

    @Override
    public String toString() {
        String retString = key.toString() + " " + frequencyCount + " " + probeCount;
        return retString;
    }

}
