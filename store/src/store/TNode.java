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
public class TNode<E> {
            private E item;
	private TNode<E> parent;
	private TNode<E> left;
	private TNode<E> right;
	private int x;
	private int y;

	public TNode() {
		item = null;
		parent = null;
		left = null;
		right = null;
		x = 0;
		y = 0;
	}

	public void setItem(E e) {
		item = e;
	}

	public void setParent(TNode<E> n) {
		parent = n;
	}

	public void setLeft(TNode<E> n) {
		left = n;
	}

	public void setX(int i) {
		x = i;
	}

	public void setY(int i) {
		y = i;
	}

	public void setRight(TNode<E> n) {
		right = n;
	}

	public E getItem() {
		return item;
	}

	public TNode<E> getParent() {
		return parent;
	}

	public TNode<E> getLeft() {
		return left;
	}

	public TNode<E> getRight() {
		return right;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}