package model.logic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyList implements Storable {

	public MyList() {

	}
	
	public MyList(int i) {
		
	}

	static class Node {
		private Node next;
		private Object data;
		private int index;

		public Node(Object data) {
			this.data = data;
		}

		public Node(Object data, int index) {
			this.data = data;
			this.index = index;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private Node head;

	@Override
	public void add(Object data) {
		if (head == null) {
			head = new Node(data, 0);
			return;
		}
		tail().next = new Node(data, tail().index + 1);
	}
	
	private Node tail() {
		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return tail;
	}

	@Override
	public void addAll(Storable b) {
		for (int i = 0; i < b.size(); i++) {
			this.add(b.get(i));
		}
	}

	@Override
	public void remove(int i) {
		if(i == 0) {
			head = head.next;
			Node c = head;
			while (c != null) {
				c.index--;
				c = c.next;
			}
			return;
		}
		if(i == tail().index) {
			Node p = head;
			while (p != null) {
				if(p.next.index == i) {
					p.next = null;
				}
				p = p.next;
			}
			return;
		}
		else {
			Node cur = head;
			Node prev = head;
			while (cur.next != null) {
				if (cur.index == i) {
					prev.next = cur.next;
					while(cur != null) {
						cur.index--;
						cur = cur.next;
					}
					break;
				}
				prev = cur;
				cur = cur.next;

			}
		}
	}
	
	/*
	 @Override
	public void remove(int i) {
		Node cur = head;
		Node prev = head;
		while (cur.next != null) {
			if (cur.index == i) {
				prev.next = cur.next;
				break;
			}
			prev = cur;
			cur = cur.next;

		}

	}
	 */

	@Override
	public Object get(int n) {
		Node fast = head;
		while (fast.next != null) {
			if (fast.index == n) {
				break;
			}
			fast = fast.next;
		}
		return fast.data;
	}

	@Override
	public int size() {
		int length = 0;
		Node current = head;

		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}
	
	@Override
	public void set(int index, Object elem) {
		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
			if(tail.index == index) {
				tail.data = elem;
				break;
		}
		}
	}

	

	public boolean isEmpty() {
		return size() == 0;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(head);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		//or iterate all elements and compare
		MyList other = (MyList) obj;
		return Objects.equals(head, other.head);
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < size(); i++) {
			str += get(i).toString();
		}
		return str;
	}

}
