package HashMap;

public class Node<K, V> {
    private K key;
    private V value;
    private int hash;
    protected Node<K, V> next;
    Node(K key, V value, Node<K, V> next){
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
        this.next = next;
    }
    public int getHash() {
        return hash;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}