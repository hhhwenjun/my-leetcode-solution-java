class Node {
    int val;
    Node next;
    Node prev;
    
    public Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    
    public Node(int val, Node next, Node prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    private Node head;
    private Node curr;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = new Node(-1);
        curr = head;
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        curr = head;
        int currIdx = -1;
        if (index < 0 || index >= size) return -1;
        while (currIdx != index){
            curr = curr.next;
            currIdx++;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        newNode.prev = head;
        newNode.next.prev = newNode;
        head.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        curr = head;
        int currIdx = -1;
        while (currIdx != index){
            curr = curr.next;
            currIdx++;
        }
        // find the index
        Node newNode = new Node(val);
        newNode.next = curr;
        newNode.prev = curr.prev;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        curr.prev = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        curr = head;
        int currIdx = -1;
        while (currIdx != index){
            curr = curr.next;
            currIdx++;
        }
        // find the index
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */