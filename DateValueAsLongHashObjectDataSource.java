import java.util.Date;

public class DateValueAsLongHashObjectDataSource implements HashObjectSource {
    long current;
    public DateValueAsLongHashObjectDataSource() {
        current = new Date().getTime();
    }

    @Override
    public Object getNext() {
        Date date = new Date(current);
        current += 1000;
        return date;
    }

    @Override
    public void close() throws Exception {
        // Do Nothing
    }
    
}
