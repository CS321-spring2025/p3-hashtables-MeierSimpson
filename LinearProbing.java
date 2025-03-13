public class LinearProbing extends Hashtable {

    public LinearProbing(int capacity) {
            super(capacity);
            //TODO Auto-generated constructor stub
        }
    
        @Override
        protected int findSlot(Object key) {
            int index = hash(key);
    
            for (int i = 0; i < capacity; i++) {
                int probeIndex = (index + i) % capacity;
    
                if (table[probeIndex] == null || table[probeIndex].getKey().equals(key)) {
                    return probeIndex;
                }
            }
    
            return -1;
        }
}
