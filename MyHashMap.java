import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Pair<U,V>{
    U first;
    V second;

    public Pair(U x, V y) {
        this.first = x;
        this.second = y;
    }
}

class Bucket {
    LinkedList<Pair<Integer,Integer>> bucket;
    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    public Integer get(Integer key){
        for (Pair<Integer,Integer> pair : this.bucket){
            if (pair.first.equals(key)){
                return pair.second;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer val){
        boolean found = false;
        for (Pair<Integer,Integer> pair : this.bucket){
            if (pair.first.equals(key)){
                pair.second = val;
                found = true;
            }
        }
        if (!found){
            this.bucket.add(new Pair<Integer, Integer>(key, val));
        }
    }

    public void remove(Integer key){
        for (Pair<Integer,Integer> pair : this.bucket){
            if (pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

public class MyHashMap {
    final Integer k = 2096;
    List<Bucket> hmap;
    public MyHashMap() {

        this.hmap = new ArrayList<>(k);
        for (int i = 0; i < this.k; ++i) {
            this.hmap.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int x = key%2096;
        this.hmap.get(x).update(key, value);
    }

    public int get(int key) {
        int x = key%2096;
        return this.hmap.get(x).get(key);
    }

    public void remove(int key) {
        int x = key%2096;
        this.hmap.get(x).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */