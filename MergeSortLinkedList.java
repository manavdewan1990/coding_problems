package com.company.data_structure;

/**
 * Definition for singly-linked list. public class LinkedList.Node { int val;
 * LinkedList.Node next; LinkedList.Node(int x) { val = x; } }
 */
public class MergeSortLinkedList {
	public static <T extends Comparable<T>> LinkedList.Node<T> sortList(
			LinkedList.Node<T> head) {
		int right = getLength(head);
		if (head == null)
			return null;

		return mergeSort(head, 0, right-1);
	}

	static <T extends Comparable<T>> int getLength(LinkedList.Node<T> head) {

		int count = 0;
		while (head != null) {
			head = head.getNext();
			count++;
		}
		return count;

	}

	static <T extends Comparable<T>> LinkedList.Node<T> mergeSort(
			LinkedList.Node<T> node, int left, int right) {
		if (left != right) {
			int mid = (left + right) / 2;
			LinkedList.Node<T> headLeft = mergeSort(node, left, mid);
			LinkedList.Node<T> headRight = mergeSort(node, mid + 1, right);
			return merge(headLeft, headRight, left, mid, right);
		}
		return node;
	}

	static <T extends Comparable<T>> LinkedList.Node<T> merge(
			LinkedList.Node<T> headLeft, LinkedList.Node<T> headRight,
			int left, int mid, int right) {

		LinkedList.Node<T> dummy = new LinkedList.Node<T>();

		for (int i = left; i <= right; i++) {
			if ((right == mid || left!= mid)
					&& headLeft.getData().compareTo(headRight.getData()) < 0) {
				dummy.setNext(headLeft);
				headLeft = headLeft.getNext();
				left++;
			} else {
				dummy.setNext(headRight);
				headRight = headRight.getNext();
				right--;
			}
		}

		return dummy.getNext();

	}
}