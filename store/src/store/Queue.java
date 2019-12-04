package store;

public class Queue<E> {
	private DLL<E> buf;

	public Queue() {
		buf = new DLL<E>();
	}

	public void enqueue(E e) {
		buf.addLast(e);
	}

	public E dequeue() {
		return buf.removeFirst();
	}

	public E first() {
		return buf.first();
	}

	public int size() {
		return buf.size();
	}

	public boolean isEmpty() {
		return buf.isEmpty();
	}

	public void print() {
		buf.print();
	}
}
