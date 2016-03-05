package com.company.data_structure;

public class MergeSortArray {

	public static <T extends Comparable<T>> void mergeSort(T[] arr) {

		T[] aux = arr.clone();

		mergeSortUtil(arr, aux, 0, arr.length - 1);
	
	}

	public static <T extends Comparable<T>> void mergeSortUtil(T[] arr,
			T[] aux, int left, int right) {
		if (right - left > 0) {
			int mid = (left + right) / 2;
			mergeSortUtil(arr, aux, left, mid);
			mergeSortUtil(arr, aux, mid + 1, right);
			merge(arr, aux, left, mid, mid + 1, right);

		}

	}

	public static <T extends Comparable<T>> void merge(T[] arr, T[] aux,
			int firstStart, int firstEnd, int secondStart, int secondEnd) {
		for (int i = firstStart; i <= secondEnd; i++) {
			aux[i] = arr[i];
		}
		int current=firstStart;
		while (firstStart <= firstEnd && secondStart<= secondEnd) {

			if (aux[firstStart].compareTo(aux[secondStart]) < 0) {
				arr[current++] = aux[firstStart];
				firstStart++;
			} else {
				arr[current++] = aux[secondStart];
				secondStart++;
			}
		}

		while (firstStart <= firstEnd) {
			arr[current++] = aux[firstStart];
			firstStart++;
		}

		while (secondStart <= secondEnd) {
			arr[current++] = aux[secondStart];
			secondStart++;
		}

	}
}
