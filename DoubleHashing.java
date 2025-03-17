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
    protected FindSlotResult findSlot(Object key) {
        int numProbes = 0;
        int index = primaryHash(key);
        int step = secondaryHash(key);

        for (int i = 0; i < capacity; i++) {
            int probeIndex = (index + i * step) % capacity;
            numProbes++;

            if (table[probeIndex] == null) {
                return new FindSlotResult(true, probeIndex, numProbes, false);
            }

            if (table[probeIndex].getKey().equals(key)) {
                return new FindSlotResult(true, probeIndex, numProbes, true);
            }
        }

        return new FindSlotResult(false, -1, numProbes, false);
    }    
}
