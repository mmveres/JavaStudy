package binarytree.main;

import java.util.Arrays;

import binarytree.entity.BinaryTree;

public class Main {
	public static final int MAXX = 15;

	public static void main(String[] args) {
		String[] source = "A B C D E F G H I J K".split(" ");
		BinaryTree<Integer, String> bt = new BinaryTree<>();
		boolean added = false;
		int[] keys = new int[MAXX];
		int counter = 0;

		for (int i = 0; i < MAXX; i++) {
			int k = 1 + (int) (Math.random() * 20);
			String s = "";
			for (int j = 0; j < 4; j++) {
				s = s + source[(int) (Math.random() * source.length)];

			}
			System.out.println("-------------------------------------");
			System.out.println("inserting key: " + k + " with value: " + s);
			added = bt.add(k, s);
			if (added) {
				keys[counter++] = k;
			}
			System.out.print((added ? "added " : "skipped as exists "));

			System.out.println("key: " + k + " with value: " + bt.getValue(k));

		}
		System.out.println("-------------------------------------");
		System.out.println(Arrays.toString(keys));
		System.out.println("-------------------------------------");
		System.out.println(bt.getSize());

		for (int i = 0; i < keys.length; i++) {
			System.out.println("-------------------------------------");
			if (keys[i] != 0) {
				System.out.println("deleting " + keys[i]);
				bt.delete(keys[i]);
			}
		}

	}

}
