package store;

public class Stack<E> {
    private DLL<E> buf;
 
    public Stack() {
        buf = new DLL<E>();
    }
 
    public void push(E e) {
        buf.addFirst(e);
    }
 
    public E pop() {
        return buf.removeFirst();
    }
 
    public E top() {
        return buf.first();
    }
 
    public boolean isEmpty() {
        return buf.isEmpty();
    }
 
    public void print() {
        System.out.println("Top at left");
        buf.print();
    }
}