

public class HashtableExperiment {
    private int debugLevel;
    private int dataSource;







    HashtableExperiment(int debugLvl) {
        debugLevel = debugLvl;
    }
    
    public void showUsage() {
        System.out.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]\r\n");
        System.exit(1);
     }

    private void run(String dataSourceString, String loadFactorString) throws Exception {
        dataSource = Integer.parseInt(dataSourceString);
        double loadFactor = Double.parseDouble(loadFactorString);
        int hashTableSize = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        int targetLoad = (int)Math.ceil(loadFactor * hashTableSize);
        LinearProbing linearProbing = new LinearProbing(hashTableSize);
        DoubleHashing doubleHashing = new DoubleHashing(hashTableSize);
        HashObjectSource hashObjectSource = getHashObjectSource();

        int currLoad = 0;
        while (currLoad < targetLoad) {
            // Update currLoadFactor
            Object o = hashObjectSource.getNext();
            linearProbing.insert(o);
            doubleHashing.insert(o);
        }

        hashObjectSource.close();
    }

    private HashObjectSource getHashObjectSource() throws Exception {
        switch(dataSource) {
            case 1:
                return new RandomIntegerHashObjectSource();
            case 2:
                return new DateValueAsLongHashObjectDataSource();
            case 3:
                return new WordListHashObjectDataSource();
            default:
                throw new Exception("Unexpected.");
        }
    }

    private void initializeGetNextObject() {
        
    }

    private void deinitializeGetNextObject() {
        
    }

    private void getNextObject() {

    }

     public static void main(String[] args) throws Exception {
        int debugLevel = 0;
        if(args.length == 4) {
            String debugLevelString = args[3];
            debugLevel = Integer.parseInt(debugLevelString);
        }
        HashtableExperiment app = new HashtableExperiment(debugLevel);
        if (args.length < 3 || args.length > 4) {
           app.showUsage();
        }
        String dataSourceString = args[1];
        String loadFactorString = args[2];
        app.run(dataSourceString, loadFactorString);
    }
    
    
}
