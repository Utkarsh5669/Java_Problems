import java.util.*;  
public class Hashing 
{  
    /* Driver Code */  
    public static void main(String args[])  
    {  
       /* Create a HashTable to store String values corresponding to integer keys */  
        Hashtable<Integer, String> hm = new Hashtable<Integer, String>();  
        /* Input the values */  
        hm.put(3, "You are visiting");  
        hm.put(5, "Hello");  
        hm.put(1, "website");  
        hm.put(2, "Javatpoint");  
        /* Display the Hashtable */  
        System.out.println(hm);  
    }  
}  