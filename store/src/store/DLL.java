package store;

public class DLL<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public DLL() {
		head =  null;
		tail =  null;
		size = 0;
	}

	public void addFirst(E e) {
		Node<E> n = new Node<E>();
		n.setItem(e); 
		if (head == null) {
			head =  n;
			tail = n;
		}
		else {
			n.setNext(head);
			head.setPrev(n);
			head = n;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> n = new Node<E>();
		n.setItem(e); 
		if (tail == null) {
			head =  n;
			tail = n;
		}
		else {
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
		}
		size++;
	}

	public E removeFirst() {
		if (head == null) {
			return null;
		}
		else {
			E e = head.getItem();
			head = head.getNext();
			if (head == null) {
				tail =  null;
			}
			else {
				head.setPrev(null);
			}
			size--;
			return e;
		}
	}

	public E first() {
		if (head == null) {
			return null;
		}
		else {
			E e = head.getItem();
			return e;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void print() {
		Node<E> n =  head;
		boolean f = true;
		System.out.print('(');
		while (n != null) {
			if (!f) {
				System.out.println(", ");
			}
			f = false;	
			System.out.print(n.getItem());
			n = n.getNext();
		}
		System.out.println(')');
	}	

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
        
}
