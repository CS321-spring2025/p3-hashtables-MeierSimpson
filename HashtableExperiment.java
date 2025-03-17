import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
            validateHashTableSizeEqual(linearProbing, doubleHashing);
            int sizeBefore = linearProbing.getSize(); 
            /*Prints element by element to the console with detailed output showing if the insert was successful
             or a duplicate. 
            You don’t need to modify the Hashtable class for this debug level. 
            This helps us debug and trace the behavior of the code in more detail.*/
            Boolean linearProbingInsertResult = linearProbing.insert(o);
            if (debugLevel == 2) {
                System.out.println("inserting " + o + " into linearProbing hashtable: " + (linearProbingInsertResult ? "Success" : "Duplicate"));
            }
            Boolean doubleHashingInsertResult = doubleHashing.insert(o);
            if (debugLevel == 2) {
                System.out.println("inserting " + o + " into doubleHashing hashtable: " + (doubleHashingInsertResult ? "Success" : "Duplicate"));
            }
            validateHashTableSizeEqual(linearProbing, doubleHashing);
            int sizeAfter = linearProbing.getSize(); 
            
            currLoad = sizeAfter;
        }

        hashObjectSource.close();
        /*java HashtableExperiment 3 0.5 0
HashtableExperiment: Found a twin prime table capacity: 95791
HashtableExperiment: Input: Word-List   Loadfactor: 0.50

        Using Linear Probing
HashtableExperiment: size of hash table is 47896
        Inserted 1305930 elements, of which 1258034 were duplicates
        Avg. no. of probes = 1.60 

        Using Double Hashing
HashtableExperiment: size of hash table is 47896
        Inserted 1305930 elements, of which 1258034 were duplicates
        Avg. no. of probes = 1.39 
 */

        System.out.println("HashtableExperiment: Found a twin prime table capacity: " + hashTableSize);
        System.out.println("HashtableExperiment: Input: " + getInputType(dataSource) + "   Loadfactor: " + loadFactor + "\n");

        outputHashtable("Linear Probing", "linear-dump.txt", linearProbing);
        System.out.println();
        outputHashtable("Double Hashing","double-dump.txt", doubleHashing);
        
        
    }

    private void outputHashtable(String name, String fileName, Hashtable hashtable) throws FileNotFoundException {
        System.out.println("\tUsing " + name);
        System.out.println("HashtableExperiment: size of hash table is " + hashtable.getSize());
        System.out.println("\tInserted " + hashtable.getTotalInserts() + " elements, of which " + hashtable.getTotalDuplicateInserts() + " were duplicates");
        System.out.println("\tAvg. no. of probes = " + hashtable.getAvgNumProbes());
        // HashtableExperiment: Saved dump of hash table
        if (debugLevel == 1) {
            writeHashTableToFile(fileName, hashtable);
            System.out.println("HashtableExperiment: Saved dump of hash table" + "\n");
        }
    }

    private void writeHashTableToFile(String filename, Hashtable hashtable) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);
        for(int i = 0; i < hashtable.getSize(); i++) {
            HashObject hashObject = hashtable.getHashObject(i);
            // table[11]: mansfield 5 1
            if (hashObject != null) {
                out.println("table[" + i + "]: " + hashObject.toString());
            }
        }
        out.close();

    }

    private String getInputType(int dataSource) throws Exception {
        switch(dataSource) {
            case 1:
                return "Integer";
            case 2:
                return "Date";
            case 3:
                return "Word-List";
            default:
                throw new Exception("Unexpected.");
        }
    }

    private void validateHashTableSizeEqual(Hashtable h1, Hashtable h2) throws Exception {
        if (h1.getSize() == h2.getSize()) {
            throw new Exception("Unexpected: linearProbeSizeand doubleHashingSizeexpected to be the same.\n");
        }
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
