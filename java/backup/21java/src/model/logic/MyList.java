package model.logic;

import java.util.Arrays;
import java.util.Objects;

public class MyList implements Storable {

	public MyList() {

	}

	static class Node<T> {
		private Node next;
		private T data;
		private int index;

		public Node(T data) {
			this.data = data;
		}

		public Node(T data, int index) {
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
		tail().next = new Node(data, head.index + 1);
	}

	@Override
	public void addAll(Storable b) {
		for (int i = 0; i < b.size(); i++) {
			this.add(b.get(i));
		}
	}

	@Override
	public void remove(int i) {
		Node cur = head;
		Node prev = head;
		while (cur.next != null) {
			if (cur.index-- == i) {
				prev.next = cur.next;
				break;
			}
			prev = cur;
			cur = cur.next;

		}

	}

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

	private Node tail() {
		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return tail;
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
