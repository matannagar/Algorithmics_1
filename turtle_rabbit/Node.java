package turtle_rabbit;


public class Node {
    int data;
    Node prev, next =null;

    public Node(){

    }

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node(int c) {
        this.data = c;
    }

    public String toString() {
        return "" + this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }
}
