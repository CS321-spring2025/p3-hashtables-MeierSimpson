public class LinearProbing extends Hashtable {

    public LinearProbing(int capacity) {
            super(capacity);
            //TODO Auto-generated constructor stub
        }
    
        @Override
        protected FindSlotResult findSlot(Object key) {
            int numProbes = 0;
            int index = hash(key);
    
            for (int i = 0; i < capacity; i++) {
                int probeIndex = (index + i) % capacity;
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
