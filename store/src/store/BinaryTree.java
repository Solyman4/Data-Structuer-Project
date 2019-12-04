/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author sloom
 */
public class BinaryTree<E> {
	private TNode<E> root;
	private int size;
	
	public BinaryTree() {
		root =  null;
		size =  0;
	}
        
        
        
         public static class TQueue<E> {
	private TNode<E> head;
	private TNode<E> tail;
	private int size;

	public TQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	public void enqueue(E e) {
		TNode<E> n = new TNode<E>();
		n.setItem(e);
		if (tail == null) {
			head = n;
			tail = n;
		}
		else {
			tail.setRight(n);
			tail = n;
		}
		size++;
	}

	public E dequeue() {
		if (head != null) {
			E e = head.getItem();
			head = head.getRight();
			if (head == null)
				tail =  null;
			size--;
			return e;
		}
		return null;
	}

	public E first() {
		if (head != null) {
			return head.getItem();
		}
		return null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void print() {
		TNode<E> n =  head;
		while (n != null) {
			System.out.println(n.getItem());
			n = n.getRight();
		}
	}
}
        
         public static class TStack<E> {
	private TNode<E> head;
	private int size;

	public TStack() {
		head = null;
		size = 0;
	}

	public void push(E e) {
		TNode<E> n = new TNode<E>();
		n.setItem(e);
		if (head == null) {
			head = n;
		}
		else {
			n.setRight(head);
			head = n;
		}
		size++;
	}

	public E pop() {
		if (head != null) {
			E e = head.getItem();
			head = head.getRight();
			size--;
			return e;
		}
		return null;
	}

	public E top() {
		if (head != null) {
			return head.getItem();
		}
		return null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void print() {
		TNode<E> n =  head;
		while (n != null) {
			System.out.println(n.getItem());
			n = n.getRight();
		}
	}
}
        
        
        




	public TNode<E> addRoot(E e) {
		TNode<E> n = new TNode<E>();
		n.setItem(e); 
		if (root == null) {
			root =  n;
			size++;
			return n;
		}
		else {
			return null;
		}
	}


	public TNode<E> addLeft(TNode<E> p, E e) {
		TNode<E> n = new TNode<E>();
		n.setItem(e); 
		if (p != null && p.getLeft() == null) {
			p.setLeft(n);
			n.setParent(p);
			size++;
			return n;
		}
		else {
			return null;
		}
	}

	public TNode<E> addRight(TNode<E> p, E e) {
		TNode<E> n = new TNode<E>();
		n.setItem(e); 
		if (p != null && p.getRight() == null) {
			p.setRight(n);
			n.setParent(p);
			size++;
			return n;
		}
		else {
			return null;
		}
	}

	public E set(TNode<E> p, E e) {
		if (p != null) {
			E re = p.getItem();
			p.setItem(e);
			return re;
		}
		else {
			return null;
		}
	}

	public boolean attach(TNode<E> p, BinaryTree<E> T1, BinaryTree<E> T2) {
		if (p.getLeft() == null && p.getRight() == null) {
			p.setLeft(T1.getRoot());
			size += T1.size(T1.getRoot());
			T1.setRoot(null);
			p.setRight(T2.getRoot());
			size += T2.size(T2.getRoot());
			T2.setRoot(null);
			return true;
		}
		else {
			return false;
		}
	}

	public E remove(TNode<E> p) {
		if (p != null) {
			if (p.getLeft() != null && p.getRight() == null) {
				if (!isRoot(p)) {
					TNode<E> pp = parent(p);
					if (left(pp) == p) {
						pp.setLeft(p.getLeft());
					}
					if (right(pp) == p) {
						pp.setRight(p.getLeft());
					}
				}
				else {
					root = p.getLeft();
				}
				E e = p.getItem();
				size--;
				return e;
			}
			if (p.getLeft() == null && p.getRight() != null) {
				if (!isRoot(p)) {
					TNode<E> pp = parent(p);
					if (left(pp) == p) {
						pp.setLeft(p.getRight());
					}
					if (right(pp) == p) {
						pp.setRight(p.getRight());
					}
				}
				else {
					root = p.getRight();
				}
				E e = p.getItem();
				size--;
				return e;
			}
			if (p.getLeft() != null && p.getRight() != null) {
				return null;
			}
			if (p.getLeft() == null && p.getRight() == null) {
				if (!isRoot(p)) {
					TNode<E> pp = parent(p);
					if (left(pp) == p) {
						pp.setLeft(null);
					}
					if (right(pp) == p) {
						pp.setRight(null);
					}
				}
				else {
					root = null;
				}
				E e = p.getItem();
				size--;
				return e;
			}
			return null;
		}
		else {
			return null;
		}
	}

	public E getElement(TNode<E> p) {
		if (p != null) {
			E e = p.getItem();
			return e;
		}
		else {
			return null;
		}
	}

	public TNode<E> parent(TNode<E> p) {
		if (p != null) {
			TNode<E> n = p.getParent();
			return n;
		}
		else {
			return null;
		}
	}

	public TNode<E> left(TNode<E> p) {
		if (p != null) {
			TNode<E> n = p.getLeft();
			return n;
		}
		else {
			return null;
		}
	}

	public TNode<E> right(TNode<E> p) {
		if (p != null) {
			TNode<E> n = p.getRight();
			return n;
		}
		else {
			return null;
		}
	}

	public TNode<E> sibling(TNode<E> p) {
		if (p != null) {
			TNode<E> n = p.getParent();
			if (n.getLeft() == p)
				return n.getRight();
			if (n.getRight() == p)
				return n.getLeft();
			return null;
		}
		else {
			return null;
		}
	}

	public TNode<E> root(TNode<E> p) {
		if (p != null) {
			TNode<E> n = p;
			while (n.getParent() != null) {
				n = n.getParent();
			}
			return n;
		}
		else {
			return null;
		}
	}

	public TNode<E> getRoot() {
		return root;
	}

	public void setRoot(TNode<E> n) {
		root = n;
	}

	public boolean isInternal(TNode<E> p) {
		if (p != null) {
			if (p.getLeft() != null || p.getRight() != null) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public boolean isExternal(TNode<E> p) {
		if (p != null) {
			if (p.getLeft() == null && p.getRight() == null) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public boolean isRoot(TNode<E> p) {
		if (p != null) {
			if (p.getParent() == null) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public int size(TNode<E> p) {
		if ( p == null)
			return 0;
		else 
			return 1 + size(left(p)) +  size(right(p));
	}

	public boolean isEmpty(TNode<E> p) {
		if (p == null) {
			return true;
		}
		else {
			return false;
		}
	}
		

	public void preOrder(TNode<E> p) {
		if (p != null) {
			System.out.println(p.getItem());
			preOrder(left(p));
			preOrder(right(p));
		}
	}

	public void inOrder(TNode<E> p) {
		if (p != null) {
			inOrder(left(p));
			System.out.println(p.getItem());
			inOrder(right(p));
		}
	}

	public void postOrder(TNode<E> p) {
		if (p != null) {
			postOrder(left(p));
			postOrder(right(p));
			System.out.println(p.getItem());
		}
	}

	public void breadthFirst(TNode<E> p) {
		if (p != null) {
			TQueue<TNode<E>> tq = new TQueue<TNode<E>>();
			tq.enqueue(p);
			while (!tq.isEmpty()) {
				TNode<E> n = tq.dequeue();
				if (n != null) {
					//System.out.println(n.getItem());
					System.out.println(n.getItem() + "," + n.getX() + "," + n.getY());
					if (n.getLeft() != null) {
						tq.enqueue(n.getLeft());
					}
					if (n.getRight() != null) {
						tq.enqueue(n.getRight());
					}
				}
			}
		}
	}

	public void eulerTour(TNode<E> p) {
		if (p != null) {
			System.out.print("(");
			if (p.getLeft() != null) {
				eulerTour(p.getLeft());
			}
			System.out.print(p.getItem());
			if (p.getRight() != null) {
				eulerTour(p.getRight());
			}
			System.out.print(")");
		}
	
	}

	public int depth(TNode<E> p) {
		if (p != null) {
			TNode<E> n = p.getParent();
			int d = 0;
			while (n != null) {
				d++;
				n = n.getParent();
			}
			return d;
		}
		return -1;
	}

	public int height(TNode<E> p) {
		if (p != null) {
			if (p.getLeft() == null && p.getRight() == null) {
				return 0;
			}
			else {
				int hl = height(p.getLeft());
				int hr = height(p.getRight());
				if (hl >= hr)
					return hl + 1;
				else 
					return hr + 1;
			}
		}
		return 0;
	}

	public int inOrderRank(TNode<E> p, int x) {
		if (p != null) {
			if (left(p) != null)
				x = inOrderRank(left(p), x);
			x++;
			if (right(p) != null)
				x = inOrderRank(right(p), x);
			return x;
		}
		return x;
	}

	public int layout(TNode<E> p, int d, int x) {
		if (p != null) {
			if (left(p) != null)
				x = layout(left(p), d + 1, x);
			p.setX(x++);
			p.setY(d);
			if (right(p) != null)
				x = layout(right(p), d + 1, x);
			return x;
		}
		return x;
	}
            public  void printBinaryTree(TNode<E> root, int level){
    if(root==null)
         return;
    printBinaryTree(root.getRight(), level+1);
    if(level!=0){
        for(int i=0;i<level-1;i++)
            System.out.print("|\t");
            System.out.println("|-------"+root.getItem());
    }
    else
        System.out.println(root.getItem());
    printBinaryTree(root.getLeft(), level+1);
}    
        
        
	public void draw(TNode<E> p) {
		if (p != null) {
			int x, y;
			int i = 0, j = 0;
			System.out.print("   ");
			int m = layout(p, 0, 0);
			for (int k = 0; k <= m; k++) {
				System.out.printf("%3d", k);
			}
			System.out.println();
			System.out.printf("%3d", i);
			TQueue<TNode<E>> tq = new TQueue<TNode<E>>();
			tq.enqueue(p);
			while (!tq.isEmpty()) {
				TNode<E> n = tq.dequeue();
				if (n != null) {
					x = n.getX();
					y = n.getY();
					while (y > i) {
						for (; j <= m; j++) {
							System.out.printf("...");
						}
						System.out.println();
						i++;
						j = 0;
						System.out.printf("%3d", i);
					}
					while (x > j - 1) {
						System.out.print("...");
						j++;
					}
					System.out.print(String.format("%3s", n.getItem()).replace(' ', '.'));
					j++;
					if (n.getLeft() != null) {
						tq.enqueue(n.getLeft());
					}
					if (n.getRight() != null) {
						tq.enqueue(n.getRight());
					}
				}
			}
			for (; j <= m; j++) {
				System.out.printf("...");
			}
			System.out.println();
		}
	
	}
		
	public static String infixToPostfix(String s) {
		TStack<Character> t = new TStack<Character>();
		String output = "";
		String op = "+-*/%()";
		String op1 = "+-";
		String op2 = "*/%";
		String op3 = "()";

		for (int i = 0; i < s.length(); i++) {
			if (op.indexOf(s.charAt(i)) != -1) {
				if (t.isEmpty()) {
					t.push(s.charAt(i));
				}
				else {
					if (op1.indexOf(s.charAt(i)) != -1) {
						while (!t.isEmpty() && t.top() != '(') {
							output += t.pop();
						}
						t.push(s.charAt(i));
					}
					if (op2.indexOf(s.charAt(i)) != -1) {
						while (!t.isEmpty() && t.top() != '(' && op2.indexOf(t.top()) != -1) {
							output += t.pop();
						}
						t.push(s.charAt(i));
					}
					if (s.charAt(i) == '(') {
						t.push(s.charAt(i));
					}
					if (s.charAt(i) == ')') {
						while (!t.isEmpty() && t.top() != '(') {
							output += t.pop();
						}
						if (t.top() == '(') {
							t.pop();
						}
					}
				}
					

			}
			else {
				output += s.charAt(i);
			}
		}
		while (!t.isEmpty()) {
			output += t.pop();
		}
		return output;
	}
		
	public BinaryTree<Character> postFixToExpTree(String s) {
		TStack<TNode<Character>> tstack = new TStack<TNode<Character>>();
		BinaryTree<Character> btc = new BinaryTree<Character>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
				TNode<Character> o = new TNode<Character>();
				o.setItem(s.charAt(i));
				o.setRight(tstack.pop());
				o.setLeft(tstack.pop());
				tstack.push(o);
				break;
			default:
				TNode<Character> tn = new TNode<Character>();
				tn.setItem(s.charAt(i));
				tstack.push(tn);	
				
			}
		}
		btc.setRoot(tstack.pop());
		return btc;
	}
		
	public String printExpression(TNode<Character> p) {
		String s = "";
		TNode<Character> n = p;
		if (p != null) {
			if (p.getLeft() != null) {
 				s += "(";
				s += printExpression(p.getLeft());
			}
			s += p.getItem();
			if (p.getRight() != null) {
				s += printExpression(p.getRight());
 				s += ")";
			}
		}
		return s;
	}

	public int evalExpression(TNode<Character> p) {
		TNode<Character> n = p;
		if (p != null) {
			if (p.getLeft() == null && p.getRight() == null) {
				return Character.getNumericValue(p.getItem());
			}
			else {
				int x = evalExpression(p.getLeft());
				int y = evalExpression(p.getRight());
				switch (p.getItem()) {
				case '+':
					return x + y;
				case '-':
					return x - y;
				case '*':
					return x * y;
				case '/':
					return x / y;
				case '%':
					return x % y;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> bti = new BinaryTree<Integer>();
		TNode<Integer> r = bti.addRoot(7);
		TNode<Integer> lc = bti.addLeft(r, 8);
		TNode<Integer> rc = bti.addRight(r, 9);
		System.out.println("bti.preOrder()");
		bti.preOrder(r);
		System.out.println("bti.size(): " + bti.size(bti.getRoot()));
		BinaryTree<Integer> bti1 = new BinaryTree<Integer>();
		TNode<Integer> r1 = bti1.addRoot(70);
		TNode<Integer> lc1 = bti1.addLeft(r1, 80);
		TNode<Integer> rc1 = bti1.addRight(r1, 90);
		System.out.println("bti1.preOrder()");
		bti1.preOrder(bti1.getRoot());
		BinaryTree<Integer> bti2 = new BinaryTree<Integer>();
		TNode<Integer> r2 = bti2.addRoot(700);
		TNode<Integer> lc2 = bti2.addLeft(r2, 800);
		TNode<Integer> rc2 = bti2.addRight(r2, 900);
		System.out.println("bti2.preOrder()");
		bti2.preOrder(bti2.getRoot());
		System.out.println("set() -- 8 <-- 6");
		int x = bti.set(lc, 6);
		System.out.println("x = " + x);
		System.out.println("bti.preOrder()");
		bti.preOrder(r);
		lc = bti.addLeft(lc, 5);
		TNode<Integer> n = bti.addLeft(rc, 12);
		rc = bti.addRight(rc, 15);
		x = bti.getElement(lc);
		System.out.println("bti.preOrder()");
		bti.preOrder(r);
		System.out.println("bti.getElement(rc): " + bti.getElement(rc));
		System.out.println("bti.isInternal(rc): " + bti.isInternal(rc));
		System.out.println("bti.isExternal(rc): " + bti.isExternal(rc));
		System.out.println("bti.isRoot(rc): " + bti.isRoot(rc));
		System.out.println("bti.isRoot(bti.getRoot()): " + bti.isRoot(bti.getRoot()));
		System.out.println("bti.attach(rc, bti1, bti2)");
		bti.attach(rc, bti1, bti2);
		System.out.println("bti.preOrder()");
		bti.preOrder(r);
		System.out.println("bti.size(): " + bti.size(bti.getRoot()));
		System.out.println("bti.isEmpty(): " + bti.isEmpty(bti.getRoot()));
		System.out.println("bti1.preOrder()");
		bti1.preOrder(bti1.getRoot());
		System.out.println("bti1.size(): " + bti1.size(bti1.getRoot()));
		System.out.println("bti1.isEmpty(): " + bti1.isEmpty(bti1.getRoot()));
		System.out.println("bti2.preOrder()");
		bti2.preOrder(bti2.getRoot());
		System.out.println("bti2.size(): " + bti2.size(bti2.getRoot()));
		System.out.println("bti2.isEmpty(): " + bti2.isEmpty(bti2.getRoot()));
		System.out.println("remove() -- 5");
		x = bti.remove(lc);
		System.out.println("x = " + x);
		System.out.println("bti.preOrder()");
		bti.preOrder(r);
		
		System.out.println("bti.inOrder()");
		bti.inOrder(r);
		
		System.out.println("bti.postOrder()");
		bti.postOrder(r);

		System.out.println("bti.draw()");
		bti.draw(bti.getRoot());
		System.out.println("bti.eulerTour()");
		bti.eulerTour(bti.getRoot());
		System.out.println();

		System.out.println("bti.getElement(rc): " + bti.getElement(rc));
		System.out.println("bti.isInternal(rc): " + bti.isInternal(rc));
		System.out.println("bti.isExternal(rc): " + bti.isExternal(rc));
		System.out.println("bti.isRoot(rc): " + bti.isRoot(rc));
		n = bti.parent(rc);
		System.out.println("parent: " + bti.getElement(n));
		n = bti.left(rc);
		System.out.println("left: " + bti.getElement(n));
		n = bti.right(rc);
		System.out.println("right: " + bti.getElement(n));
		n = bti.sibling(rc);
		System.out.println("sibling: " + bti.getElement(n));
		n = bti.root(rc);
		System.out.println("root: " + bti.getElement(n));
		System.out.println("depth(rc): " + bti.depth(rc));
		System.out.println("height(bti.getRoot()): " + bti.height(bti.getRoot()));
		System.out.println("breadthFirst");
		bti.breadthFirst(bti.getRoot());
		System.out.println("layout");
		System.out.println(bti.layout(bti.getRoot(), 0, 0));
		System.out.println("draw");
		bti.draw(bti.getRoot());

                String infExp = "1+2*3*(4+5)+7/6*2+4";
                System.out.println(infExp);
                String postExp = infixToPostfix(infExp);
                System.out.println(infixToPostfix(infExp));

		BinaryTree<Character> btc = bti.postFixToExpTree(postExp);
		System.out.println("draw");
		btc.draw(btc.getRoot());
		System.out.println("printExpression");
		System.out.println(btc.printExpression(btc.getRoot()));	
		System.out.println("btc.eulerTour()");
		btc.eulerTour(btc.getRoot());
		System.out.println();
		System.out.println("evalExpression");
		System.out.println(btc.evalExpression(btc.getRoot()));	

	}
		
	
}

