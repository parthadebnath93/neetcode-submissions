class LRUCache {
    private DoublyLinkedList dll;
    private Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.dll=new DoublyLinkedList();
        this.map=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        dll.moveFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            map.put(key,node);
            dll.moveFront(node);
        }else{
            if(map.size()==capacity){
                Node last=dll.removeLast();
                if(map.containsKey(last.key)){
                    map.remove(last.key);
                }
            }
            Node node=new Node(key, value);
            dll.addFirst(node);
            map.put(key, node);
        }
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    public DoublyLinkedList(){
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }

    public void addFirst(Node node){
        node.next=this.head.next;
        this.head.next.prev=node;
        node.prev=this.head;
        this.head.next=node;
    }
    public void moveFront(Node node){
        remove(node);
        addFirst(node);
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public Node removeLast(){
        if(this.tail.prev==this.head){
            return null;
        }
        Node last=tail.prev;
        remove(last);
        return last;
    }
}
class Node{
    int key;
    int val;
    Node next, prev;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}
