import java.util.Random;

public class RandomIntegerHashObjectSource implements HashObjectSource {
    Random random;
    public RandomIntegerHashObjectSource() {
        random = new Random();
    }

    @Override
    public Object getNext() {
        return random.nextInt();
    }

    @Override
    public void close() throws Exception {
        // Do nothing
    }
    
}
