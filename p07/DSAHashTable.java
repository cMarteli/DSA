/**
 * DSAHashEntry.java
 *
 * @author Caio Marteli 19598552
 */
public class DSAHashTable{
	
    DSAHashEntry hashArray[];

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAStack object
    ASSERTION: creates new DSALinkedList
    ************************************************************/
    public DSAHashTable(int tableSize) 
    {
        int actualSize = nextPrime(tableSize);
        hashArray = new DSAHashArray[actualSize];
        for(int i = 0; i < actualSize -1 ; i++)
        {
            hashArray[i] = new DSAHashEntry(); //check this
        }


    }
    //TODO
    public int nextPrime()
    {
        return 0;
    }

    /************************************************************
    IMPORT: none
    EXPORT: address of new DSAStack object
    ASSERTION: creates new DSALinkedList
    ************************************************************/
    public int hashFunction(String key) 
    {
        int hashIndex = 0;
        for(int i = 0; i < key.length(); i++)
        {
            hashIndex += key.charAt(i);
        }
        //hashIndex = hashIndex % hLength; //may need to import array
        hashIndex = hashIndex % 31;

        return hashIndex;
    }
}