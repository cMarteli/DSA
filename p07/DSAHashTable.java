import java.math.*;

/**
 * DSAHashEntry.java
 *
 * @author Caio Marteli 19598552
 */
public class DSAHashTable{
	
    protected DSAHashEntry hashArray[];

    /************************************************************
    Default Constructor:
    IMPORT: minimum table size
    EXPORT: address of new DSAHashTable object
    ASSERTION: creates new DSAHashTable with table size parameter
    ************************************************************/
    public DSAHashTable(int tableSize) 
    {
        int actualSize = nextPrime(tableSize);
        hashArray = new DSAHashEntry[actualSize];
        for(int i = 0; i < actualSize -1 ; i++)
        {
            hashArray[i] = new DSAHashEntry(); // creates array with default values
        }

    }
    /************************************************************
    IMPORT: startVal (int)
    EXPORT: primeVal (int)
    ASSERTION: finds next prime number after in param
    ************************************************************/
    public int nextPrime(int startVal)
    {
        int primeVal = 0, ii = 3;
        double rootVal = 0.0;
        boolean isPrime = false;

        if(startVal % 2 == 0) //Even numbers are never prime, so make it odd 1 less as primeval+2
        {
            primeVal = startVal - 1; 
        }
        else
        {
            primeVal = startVal;
        }
        do // Test if primeVal candidate is actually a prime number
        {
            primeVal += 2;
            ii = 3;
            isPrime = true;
            rootVal = Math.sqrt(primeVal); //No need to check beyond sqrt(primeVal)
            do
            {
                if(primeVal % ii == 0)
                {
                    isPrime = false;
                }
                else
                {
                    ii += 2; //Skip testing with even numbers
                }
            }
            while(ii <= rootVal && isPrime);
        }
        while(!isPrime); //There is always a prime number to be found 
        
        return primeVal;
    }

    /************************************************************
    IMPORT: key (String)
    EXPORT: hashIndex (int)
    ASSERTION: bernstein variant of hashCode
    ************************************************************/
    public int hash(String key) 
    {
        int hashIndex = 0;
        for(int i = 0; i < key.length(); i++)
        {
            hashIndex = (33 * hashIndex) + key.charAt(i);
        }
        hashIndex = Math.abs(hashIndex % hashArray.length); //caling abs here; may slow down code?
        return hashIndex;
    }

    /************************************************************
    IMPORT:
    EXPORT:
    ASSERTION: Puts a key into array TODO: Collision Handling, object input
    ************************************************************/
    public void put(String key) 
    {
        int index = hash(key);
        //System.out.println("Index for key: " + key + " is: " + index); //DEBUG
        DSAHashEntry entry = new DSAHashEntry(key);
        hashArray[index] = entry;
    }

    /************************************************************
    IMPORT:
    EXPORT:
    ASSERTION: Puts an entry into array TODO: testing
    ************************************************************/
    private void put(DSAHashEntry entry) 
    {
        int index = hash(entry.getKey());
        while(hashArray[index].getState() != 1) //checks if position is taken
        {
            hashArray[index] = entry;
            index++;
        }
        
    }

    /************************************************************
    IMPORT: key (String)
    EXPORT: boolean
    ASSERTION: checks if given key exists in array TODO: needs to test collision
    ************************************************************/
    public boolean hasKey(String key) 
    {
        boolean found = false;
        int index = hash(key);
        String result = hashArray[index].getKey();
        for(int i = 0; i < hashArray.length; i++)
        {
            if(result == key)
            {
                found = true;
            }
        }
        return found;
    }

    /************************************************************
    IMPORT: key (String)
    EXPORT: result (String)
    ASSERTION: Returns key at position in array TODO: make it return object instead
    ************************************************************/
    public String get(String key)
    {        
        int index = hash(key);
        String result = hashArray[index].getKey();
        return result;
    }

    /************************************************************
    IMPORT: key (String)
    EXPORT:
    ASSERTION: TODO: account for collisions; testing
    ************************************************************/
    public void remove(String key) 
    {//STUB
        if(!hasKey(key))
        {
            System.out.println("Key not found");
        }
        else
        {
            int index = hash(key);
            hashArray[index] = new DSAHashEntry(); //clears with new entry
            hashArray[index].setState(-1); //sets state to previously used
        }
    }

    /************************************************************
    PRIVATE INNER CLASS
    ************************************************************/
    private class DSAHashEntry
    {

        private String key; //index?
        private Object value;
        private int state; //free[0], used [1] or previously used [-1]
        
        /************************************************************
        Default Constructor:
        IMPORT: none
        EXPORT: address of new DSAHashEntry object
        ASSERTION: creates new DSAHashEntry; all values to default
        ************************************************************/ 
        public DSAHashEntry()
        {
            setKey(" ");
            setValue(null);
            setState(0);
        }

        /************************************************************
        Alternate Constructor:
        IMPORT: inKey (String)
        EXPORT: address of new DSAHashEntry object
        ASSERTION: sets key only
        ************************************************************/ 
        public DSAHashEntry(String inKey)
        {
            setKey(inKey);
            setValue(null);
            setState(1);
        }

        /************************************************************
        Alternate Constructor:
        IMPORT: inKey (String), inValue (Object)
        EXPORT: address of new DSAHashEntry object
        ASSERTION: creates new DSAHashEntry; sets key and value
        ************************************************************/ 
        public DSAHashEntry(String inKey, Object inValue)
        {
            setKey(inKey);
            setValue(inValue);
            setState(1);
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }




    }

}//DSAHashEntry.java - EoF