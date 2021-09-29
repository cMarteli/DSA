/**
 * 
 *
 * @author Caio Marteli 19598552
 */
public class TestHarness
{

    public static void main(String[] args) 
    {
        // System.out.println("*** TESTING hash() ***");
        // DSAHashTable t = new DSAHashTable(50);

        // System.out.println("Input: A");
        // System.out.println("Index Generated: " + t.hash("A")); //shows index
        // t.put("A"); //storing
        // System.out.println("Value found: " + t.get("A")); //obtaining from table

        // System.out.println("Input: B"); 
        // System.out.println("Index Generated: " + t.hash("B")); //shows index
        // t.put("B"); //storing
        // System.out.println("Value found: " + t.get("B")); //obtaining from table

        // System.out.println("Input: giraffe");
        // System.out.println("Index Generated: " + t.hash("giraffe")); //shows index
        // t.put("giraffe"); //storing
        // System.out.println("Value found: " + t.get("giraffe")); //obtaining from table

        
        System.out.println("*** TESTING collisions ***");
        DSAHashTable t2 = new DSAHashTable(10);  

        System.out.println("Input: Harry"); //should collide with B at size 10
        System.out.println("Index Generated: " + t2.hash("Harry")); //shows index
        t2.put("Harry"); //storing
        System.out.println("Value found: " + t2.get("Harry")); //obtaining from table

        System.out.println("Input: A");
        System.out.println("Index Generated: " + t2.hash("A")); //shows index
        t2.put("A"); //storing
        System.out.println("Value found: " + t2.get("A")); //obtaining from table

        System.out.println("Input: B"); 
        System.out.println("Index Generated: " + t2.hash("B")); //shows index
        t2.put("B"); //storing
        System.out.println("Value found: " + t2.get("B")); //obtaining from table
        System.out.println("looking for Harry");
        System.out.println("Value found: " + t2.get("Harry")); //obtaining from table

        // System.out.println("*** TESTING hasKey() ***");
        // System.out.println("Key: 'key' EXPECTED: false RESULT: " + t.hasKey("key"));
        // System.out.println("Key: 'B' EXPECTED: true RESULT: " + t.hasKey("B"));
        // System.out.println("Key: 'giraffe' EXPECTED: true RESULT: " + t.hasKey("giraffe"));
        // System.out.println("Key: 'pepega' EXPECTED: false RESULT: " + t.hasKey("pepega"));

        // System.out.println("*** TESTING nextPrime() ***");
        // System.out.println("TESTING next prime after: 1168 EXPECTED: 1171 RESULT: " + t.nextPrime(1168));
        // System.out.println("TESTING next prime after: 567 EXPECTED: 569 RESULT: " + t.nextPrime(567));
        // System.out.println("TESTING next prime after: 2746 EXPECTED: 2749 RESULT: " + t.nextPrime(2746));
        // System.out.println("TESTING next prime after: 189 EXPECTED: 191 RESULT: " + t.nextPrime(189));
        }
}