package greedy;

import java.util.Arrays;

class Job {
	int id;
	int profit;
	int deadline;

	Job(int x, int y, int z) {
		this.id = x;
		this.deadline = y;
		this.profit = z;
	}
}

public class JobSchedulingProblem {

	static int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
		int maxDeadline = 0;
		// finding max deadline
		for (int i = 0; i < n; i++) {
			if (arr[i].deadline > maxDeadline) {
				maxDeadline = arr[i].deadline;
			}
		}
		// storing the id of jobs that can be done in max deadline
		int maxProfit = 0;
		int[] result = new int[maxDeadline + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline; j > 0; j--) {
				if (result[j] == -1) {
					result[j] = arr[i].id;
					maxProfit += arr[i].profit;
					count++;
					break;
				}
			}
		}

		return new int[] { count, maxProfit };
	}

	public static void main(String[] args) {
		Job[] arr = new Job[] { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
		int n = arr.length;
		// Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
		int[] jobScheduling = JobScheduling(arr, n);
		System.out.println(jobScheduling[0] + " " + jobScheduling[1]);
	}
}
