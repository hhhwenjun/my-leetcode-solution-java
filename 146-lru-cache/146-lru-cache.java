class LRUCache {
    
    private LinkedNode head;
    private LinkedNode tail;
    private Map<Integer, LinkedNode> cache = new HashMap<>(); // key, node with val
    private int size;
    private int capacity;
    
    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
    }
    
    public void add(LinkedNode node){
        // add to the front
        node.next = head.next;
        node.prev = head;
        
        head.next = node;
        node.next.prev = node;
        
    }
    
    public void remove(LinkedNode node){
        // remove the node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public LinkedNode removeTail(){
        // remove from the tail
        LinkedNode target = tail.prev;
        remove(target);
        return target;
    }
    
    public void moveToFront(LinkedNode node){
        remove(node);
        add(node);
    }

    public LRUCache(int capacity) {
        tail = new LinkedNode();
        head = new LinkedNode();
        tail.prev = head;
        head.next = tail;
        
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        LinkedNode target = cache.get(key);
        if (target == null) return -1;
        moveToFront(target);
        return target.value;
    }
    
    public void put(int key, int value) {
        LinkedNode curr = cache.get(key);
        
        if (curr == null){
            // create new node
            LinkedNode newNode = new LinkedNode();
            newNode.value = value;
            newNode.key = key;
            cache.put(key, newNode);
            add(newNode);
            size++;
            
            if (size > capacity){
                LinkedNode removeNode = removeTail();
                cache.remove(removeNode.key);
                size--;
            }
        }
        else {
            // update the value
            curr.value = value;
            moveToFront(curr);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */