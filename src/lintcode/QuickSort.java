package lintcode;

public class QuickSort {
	
	private static void qSort(int[] arr, int head, int tail) {
		if (head >= tail || arr == null || arr.length <= 1) {
			return;
		}
		int i = head, j = tail, pivot = arr[(head + tail) / 2];
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			} else if (i == j) {
				i++;
			}
		}
		qSort(arr, head, j);
		qSort(arr, i, tail);
		
	}
	
	public static void main() {
		int [] arr = new int[] {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
		qSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
