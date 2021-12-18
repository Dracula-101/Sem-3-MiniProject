package Roulette;

class Node {
	int data;
	Node next;
}

public class LinkedList {
	public Node head;

	public void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}

	}

	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node n = head;
			Node n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			n1 = null;
		}
	}

	public boolean checkSorting() {

		Node current = head;
		while (current.next != null) {
			if (current.data > current.next.data) {
				return false;
			} else {
				current = current.next;
			}
		}
		return true;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public int listSize() {
		int size = 1;
		Node current = head;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public int removeDuplicate() {

		if (isEmpty()) {
			System.out.println("The linked list is Empty!!");
			return -1;
		}

		if (checkSorting()) {
			Node current = head;

			while (current.next != null) {
				if (current.data == current.next.data) {
					Node nextNext = current.next.next;
					current.next = nextNext;
				} else {
					current = current.next;
				}
			}
			show();
			return 1;
		} else {
			System.out.println("Linked list not Sorted ");
			return 0;
		}
	}

	public void show() {
		Node node = head;
		System.out.println("The Linked List is :");
		while (node != null && node.next != null) {
			System.out.print(node.data + "-> ");
			node = node.next;
		}

		if (node != null) {
			System.out.println(node.data);
		} else {
			System.out.println("Empty ");
		}
	}

	public int getData(int index) {
		Node current = head;
		while (index != 0) {
			current = current.next;
			index--;
		}
		return current.data;

	}

	public void makeZero(int index) {
		Node current = head;
		while (index != 0) {
			current = current.next;
			index--;
		}
		current.data = 0;
	}

	public void sortList() {
		// Bubble sort
		int size = listSize();
		System.out.println("\nBefore Sorting the list!!");
		show();
		System.out.println("-------------------------------------------------");
		if (size > 1) {
			for (int i = 0; i < size; i++) {
				Node currentNode = head;
				Node next = head.next;
				for (int j = 0; j < size - 1; j++) {
					if (currentNode.data > next.data) {
						int temp = currentNode.data;
						currentNode.data = next.data;
						next.data = temp;
					}
					currentNode = next;
					next = next.next;
				}
			}
			System.out.println("-------------------------------------------------");
			System.out.println("\nAfter Sorting the list!!");
			show();
		} else
			System.out.println("List too small (List size =1)");
	}
}
