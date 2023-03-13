package arr_part2;

public class MergeOverlappingSubIntervals {

	static int[][] mergeInterval(int[][] intervals) {
		int n = intervals.length;
		if (n < 2) {
			return intervals;
		}
		sort2D(intervals);
		int[][] input = new int[n][];
		int[] arr1 = intervals[0];
		int[] arr2 = null;
		int start = 0;
		for (int i = 1; i < n; i++) {
			arr2 = intervals[i];
			if (arr1[0] <= arr2[0] && arr1[1] >= arr2[0]) {
				int min = Math.min(arr1[0], arr2[0]);
				int max = Math.max(arr1[1], arr2[1]);
				input[start] = new int[] {min,max};
				arr1 = input[start];
			}else {
				input[start++] = arr1;
				input[start] = arr2;
				arr1 = arr2;
			}
		}
		int count = 0;
		for (int j = 0; j < input.length; j++) {
			if (input[j] != null) {
				count++;
			}
		}
		int[][] temp = new int[count][];
		for (int j = 0; j < temp.length; j++) {
			temp[j] = input[j];
		}
		return temp;
	}

	private static void sort2D(int[][] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals.length - i - 1; j++) {
				if (intervals[j][0] > intervals[j + 1][0]) {
					int[] temp = intervals[j];
					intervals[j] = intervals[j + 1];
					intervals[j + 1] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 1, 4 }, { 0, 2 }, { 3, 5 } };
		int[][] arr = mergeInterval(intervals);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (arr[i] != null) {
					System.out.print(arr[i][j] + " ");
				}

			}
			System.out.println();
		}
	}

}
