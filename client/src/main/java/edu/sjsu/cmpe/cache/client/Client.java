package edu.sjsu.cmpe.cache.client;

import edu.sjsu.cmpe.cache.client.ConsistentHash;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.util.ArrayList;
public class Client {
private  static HashFunction hashFunction=Hashing.md5();
      private static int numberOfReplicas=50;
     private static ArrayList<String> nodes = new ArrayList<String>();
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");
        CacheServiceInterface cache1 = new DistributedCacheService(
                "http://localhost:3000");

        CacheServiceInterface cache2 = new DistributedCacheService(
                "http://localhost:3001");

        CacheServiceInterface cache3 = new DistributedCacheService(
                "http://localhost:3002");

        //cache.put(1, "foo");
        //System.out.println("put(1 => foo)");

        //String value = cache.get(1);
        //System.out.println("get(1) => " + value);


// System.out.println("Cache 2 get(1) => " + cache2.get(1));
        nodes.add("ServerA");
        nodes.add("ServerB");
        nodes.add("ServerC");
        
         CacheServiceInterface cache=null;
        
        ConsistentHash consistentHash = new ConsistentHash(hashFunction, numberOfReplicas,nodes );
        
        System.out.println("Bucket for 1: "+consistentHash.get("1"));
      
         switch(consistentHash.get("1").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(1, "a");
        System.out.println("put(1 => a)");
        System.out.println("get(1) => " + cache.get(1));
        
        System.out.println("Bucket for 2: "+consistentHash.get("2"));
        
switch(consistentHash.get("2").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(2, "b");
        System.out.println("put(2 => b)");
        System.out.println("get(2) => " + cache.get(2));










        
        System.out.println("Bucket for 3: "+consistentHash.get("3"));
        
        
switch(consistentHash.get("3").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(3, "c");
        System.out.println("put(3 => c)");
        System.out.println("get(3) => " + cache.get(3));





        System.out.println("Bucket for 4:"+consistentHash.get("4"));
        
        
      
switch(consistentHash.get("4").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(4, "d");
        System.out.println("put(4 => d)");
        System.out.println("get(4) => " + cache.get(4));






        System.out.println("Bucket for 5:"+consistentHash.get("5"));
        


     
      
switch(consistentHash.get("5").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(5, "e");
        System.out.println("put(5 => e)");
        System.out.println("get(5) => " + cache.get(5));





        
        System.out.println("Bucket for 6:"+consistentHash.get("6"));
        

      
switch(consistentHash.get("6").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(6, "f");
        System.out.println("put(6 => f)");
        System.out.println("get(6) => " + cache.get(6));



        
        System.out.println("Bucket for 7:"+consistentHash.get("7"));


      
switch(consistentHash.get("7").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(7, "g");
        System.out.println("put(7 => g)");
        System.out.println("get(7) => " + cache.get(7));




        System.out.println("Bucket for 8:"+consistentHash.get("8"));

     
switch(consistentHash.get("8").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(8, "h");
        System.out.println("put(8 => h)");
        System.out.println("get(8) => " + cache.get(8));



        System.out.println("Bucket for 9:"+consistentHash.get("9"));


  
switch(consistentHash.get("9").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(9, "i");
        System.out.println("put(9 => i)");
        System.out.println("get(9) => " + cache.get(9));






        System.out.println("Bucket for 10:"+consistentHash.get("10"));




switch(consistentHash.get("10").toString())
            {
         case "ServerA": cache = cache1;
         break;
         case "ServerB": cache = cache2;
         break;
         case "ServerC": cache = cache3;
         break;

            }

cache.put(10, "j");
        System.out.println("put(10 => j)");
        System.out.println("get(10) => " + cache.get(10));










        System.out.println("Existing Cache Client...");
    }

}
