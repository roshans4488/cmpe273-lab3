package edu.sjsu.cmpe.cache.client;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import com.google.common.hash.HashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import java.lang.Object;
import com.google.common.base.Charsets;
public class ConsistentHash<T> {

  private  HashFunction hashFunction=Hashing.md5();
  private final int numberOfReplicas;
  private final SortedMap<Integer, T> circle =    new TreeMap<Integer, T>();
  //hashFunction = Hashing.md5();
  public ConsistentHash(HashFunction hashFunction,
    int numberOfReplicas, Collection<T> nodes) {

    this.hashFunction = hashFunction;
    this.numberOfReplicas = numberOfReplicas;

    for (T node : nodes) {
      add(node);
    }
  }

  public void add(T node) {
    for (int i = 0; i < numberOfReplicas; i++) {
    	
    	
    	HashCode hc = hashFunction.newHasher().putString(node.toString() + i, Charsets.UTF_8).hash();
      circle.put( hc.asInt(),node);
    }
  }

  public void remove(T node) {
    for (int i = 0; i < numberOfReplicas; i++) {
    	HashCode hc = hashFunction.newHasher().putString(node.toString() + i, Charsets.UTF_8).hash();
      circle.remove(hc);
    }
  }

  public T get(Object key) {
    if (circle.isEmpty()) {
      return null;
    }
    int hash = hashFunction.newHasher().putString(key.toString(), Charsets.UTF_8).hash().asInt();
    if (!circle.containsKey(hash)) {
      SortedMap<Integer, T> tailMap =   circle.tailMap(hash);
      hash = tailMap.isEmpty() ?
             circle.firstKey() : tailMap.firstKey();
    }
    return circle.get(hash);
  } 

}