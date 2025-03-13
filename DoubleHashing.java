public class DoubleHashing extends Hashtable {

    public DoubleHashing(int capacity) {
        super(capacity);
    }

    private int primaryHash(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private int secondaryHash(Object key) {
        return 1 + Math.abs((key.hashCode() % (capacity - 2)) % capacity);
    }

    @Override
    protected int findSlot(Object key) {
        int index = primaryHash(key);
        int step = secondaryHash(key);

        for (int i = 0; i < capacity; i++) {
            int probeIndex = (index + i * step) % capacity;

            if (table[probeIndex] == null || table[probeIndex].getKey().equals(key)) {
                return probeIndex;
            }
        }

        return -1;
    }
    
}
