package algorithm;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSort {

	private static <T> void sort(T data[], T result[], int start, int end, Comparator<? super T> c) {
		if (start >= end)
			return;
		int length = end - start;
		int mid = (length >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		sort(data, result, start1, end1, c);
		sort(data, result, start2, end2, c);
		int k = start;
		while (start1 <= end1 && start2 <= end2) {
			result[k++] = c.compare(data[start1], data[start2]) < 0 ? data[start1++] : data[start2++];
		}
		while (start1 <= end1) {
			result[k++] = data[start1++];
		}
		while (start2 <= end2) {
			result[k++] = data[start2++];
		}
		for (k = start; k <= end; k++) {
			data[k] = result[k];
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> void sort(T data[], Comparator<? super T> c) {
		T result[] = (T[]) Array.newInstance(data.getClass().getComponentType(), data.length);
		sort(data, result, 0, data.length - 1, c);
		data = result;
	}

}
