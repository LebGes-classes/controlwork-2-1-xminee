package HashMap;

public class HashMap1<K, V> {
    private Object[] array;
    private int capacity;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashMap1() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public HashMap1(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    private int indexHash(int hash) {
        return (capacity - 1) & hash;
    }

    private int hash(K key) {
        return key.hashCode();
    }

    public void put(K key, V value) {
        if ((float) size / capacity >= DEFAULT_LOAD_FACTOR) {
            resizing();
        }
        size++;
        Node<K, V> currentNode = new Node<K, V>(key, value, null);
        int index = indexHash(currentNode.getHash());
        if (array[index] == null || getNodeByCell(array[index]).getKey().equals(key)) {
            this.array[index] = currentNode;
        } else {
            Node<K, V> lastNode = getNodeByCell(array[index]);
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = currentNode;
        }
    }

    public Node<K, V> getNode(K key) {
        if (containsKey(key)) {
            return (Node<K, V>) array[indexHash(hash(key))];
        } else {
            throw new IllegalArgumentException("Неверный ключ!");
        }
    }

    private Node<K, V> getNodeByCell(Object cell) {
        return (Node<K, V>) cell;
    }

    public V get(K key) {
        if (containsKey(key)) {
            return getNode(key).getValue();
        } else {
            throw new IllegalArgumentException("Неверный ключ!");
        }
    }

    public boolean containsKey(K key) { //проверка есть ли ключ
        int index = indexHash(hash(key));
        Node<K, V> currentNode = getNodeByCell(array[index]);
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean containsValue(V value) { // проверка есть ли такое значение
        for (Object element : array) {
            if (element instanceof Node) {
                Node<K, V> currentNode = (Node<K, V>) element;
                do {
                    if (currentNode.getValue().equals(value)) {
                        return true;
                    }
                    currentNode = currentNode.next;
                } while (currentNode.next != null);
            }
        }
        return false;
    }

    public void remove(K key) { // удаление элемента по ключу
        if (containsKey(key)) {
            size--;
            Node<K, V> currentNode = getNode(key);
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode = currentNode.next;
                    break;
                }
                currentNode = currentNode.next;
            }
        } else {
            throw new IllegalArgumentException("Неверный ключ!");
        }
    }

    public int size() {
        return size;
    } //размер hashmap

    public int capaciti() {
        return capacity;}

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizing() { // изменение размера hashmap
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

    }
}
