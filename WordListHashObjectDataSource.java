import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordListHashObjectDataSource implements HashObjectSource {
    private BufferedReader reader;
    public WordListHashObjectDataSource() {
        String filePath = "word-list.txt";

        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            System.err.println("Error opening the file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getNext() {
        try {
            if (reader != null) {
                return reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing the file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
}
