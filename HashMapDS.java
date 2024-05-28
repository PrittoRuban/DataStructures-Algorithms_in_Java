import java.util.HashMap;

// HashMap is a data structure that implements an associative array abstract data type, a structure that can map keys to values.
// A HashMap uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.
// T.C - O(1) for search, insert and delete
// S.C - O(n)

// HashMap is a collection of key-value pairs

public class HashMapDS {
    public static void main(String[] args) {
        HashMap<String, String> ht = new HashMap<>(21);
        ht.put("100", "A");
        ht.put("123", "B");
        ht.put("321", "C");
        ht.put("555", "D");
        ht.put("777", "E");

        // ht.remove(777);

        for(String key: ht.keySet()) {
            System.out.println(key.hashCode() % 21 + " " + key + " Value: " + ht.get(key));
        }
    }
}
