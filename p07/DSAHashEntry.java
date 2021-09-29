import java.util.*;
/**
 * DSAHashEntry.java
 *
 * @author Caio Marteli 19598552
 */
public class DSAHashEntry{

    String key;
    Object value;
    int state;
    
    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAHashEntry object
    ASSERTION: creates new DSAHashEntry
    ************************************************************/ 
    public DSAHashEntry()
    {
        key = " ";
        value = null;
        state = 0;
    }

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAHashEntry object
    ASSERTION: creates new DSAHashEntry
    ************************************************************/ 
    public DSAHashEntry(String inKey, Object inValue)
    {
        key = inKey;
        value = inValue;
        state = 1;
    }
}