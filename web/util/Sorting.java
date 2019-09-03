package com.lotto.web.util;

public class Sorting {
	public int[] bubbleSort(int[] arr, boolean flag) {
		int t = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (flag) {
					if (arr[j] > arr[j + 1]) {
						t = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = t;
					}
				} else {
					if (arr[j] < arr[j + 1]) {
						t = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = t;
					}
				}
			}
		}
		return arr;
	}
}
