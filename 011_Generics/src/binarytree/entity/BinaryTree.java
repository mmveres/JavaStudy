package binarytree.entity;

import java.util.Comparator;

import com.sun.beans.finder.FieldFinder;

public class BinaryTree<K extends Comparable<K>, V> {
	class Node {

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		 K key;
		 V value;
		 Node left;
		 Node right;

		@Override
		public String toString() {
			return "Node [key=" + key + "]";
		}

	}

	private Integer f;
	private Node root;
	private Node temp;
	private Node previous;
	private int size;

	public boolean add(K key, V value) {
		if (root == null) {
			root = new Node(key, value);
			size++;
			return true;
		} else {
			return addNode(root, key, value);
		}
	}

	private boolean addNode(Node current, K key, V value) {
		// if key already exists - skip adding
		if (current.key.equals(key))
			return false;
		// if current node's key smaller than new key
		if (current.key.compareTo(key) < 0) {
			// and no left child for current node
			if (current.left == null) {
				// create new node and make it left child of current
				current.left = new Node(key, value);
				size++;
				return true;
			} else {
				// and there's left child for current node
				// repeat again using current node as root
				return addNode(current.left, key, value);
			}
		} else {
			// if current node's key bigger than new key
			// and no right child for current node
			if (current.right == null) {
				// create new node and make it right child of current
				current.right = new Node(key, value);
				size++;
				return true;
			} else {
				// and there's right child for current node
				// repeat again using current node as root
				return addNode(current.right, key, value);
			}
		}

	}

	public boolean delete(K key) {
		// search for node
		Node victim = findNode(root, key);
		// if not found - nothing to delete
		if (victim == null)
			return false;

		// if victim has one child
		
		printLR(victim);
		if (victim.left == null && victim.right == null) {
			remapParent(previous, victim, null);
			size--;
		} else {
			deleteHalfNode(victim, previous);
		}

		return true;
	}

	private void deleteHalfNode(Node victim, Node up) {
		Node temp;
		// if no right child
		if (victim.right == null) {
			// find most right element in chain starting from victim's left
			// neighbor
			temp = findRightMost(victim.left);
			// if element found contains left child - remap child instead of
			// element for upper node
			if (temp.left != null) {
				previous.right = temp.left;
			} else {
				// otherwise remap NULL
				previous.right = null;
			}

		} else {
			// same logic for "no left child" case
			temp = findLeftMost(victim.right);
			if (temp.right != null) {
				previous.left = temp.right;
			} else {
				// otherwise remap NULL
				previous.right = null;
			}

		}
		// make element's links point the where victim's link pointed previously
		// points to
		temp.left = victim.left;
		temp.right = victim.right;
		// remap victim's up node point to temp node now --> nothing points at
		// victim, it's lost
		remapParent(up, victim, temp);
		size--;

	}

	private void remapParent(Node parent, Node from, Node to) {
		if (parent == null) {
			root = to;
			return;
		}
		if (parent.left == from) {
			parent.left = to;
			return;
		}
		if (parent.right == from) {
			parent.right = to;
		}

	}

	public V getValue(K key) {
		V v = null;
		Node n = findNode(root, key);
		if (n != null) {
			v = n.value;
		}
		previous = null;
		return v;
	}

	// returns Node if key matches otherwise returns null
	private Node findNode(Node current, K key) {

		if (current.key.equals(key))
			return current;
		if (current.key.compareTo(key) < 0) {
			if (current.left != null) {
				previous = current;
				return findNode(current.left, key);
			}
		} else {
			if (current.right != null) {
				previous = current;
				return findNode(current.right, key);
			}
		}
		return null;
	}

	private void printLR(Node n) {
		System.out.println("for node " + n + " left is " + n.left + " and right is " + n.right);
	}

	private Node findLeftMost(Node current) {
		if (current.left == null) {
			return current;
		} else {
			previous = current;
			return findLeftMost(current.left);
		}
	}

	private Node findRightMost(Node current) {
		if (current.right == null) {
			return current;
		} else {
			previous = current;
			return findRightMost(current.right);
		}
	}

	public int getSize() {
		return size;
	}

	
	public String printAll(Node n){
		if(n==null) return "[null]";
		System.out.println();
//		TODO
		return "dfsd";
		
	}
}
