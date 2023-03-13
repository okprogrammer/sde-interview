package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
	int value;
	int weight;

	Item(int x, int y) {
		this.value = x;
		this.weight = y;
	}
}

public class FractionalKnapsack {
	static double fractionalKnapsack(int W, Item arr[], int n) {
		// sort the array on value/weight ratio
		Arrays.sort(arr, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				double r1 = (double) o1.value / (double) o1.weight;
				double r2 = (double) o2.value / (double) o2.weight;
				if (r1 > r2) {
					return -1;
				} else if (r1 < r2) {
					return 1;
				}
				return 0;
			}
		});
		double value = 0.0;
		for (int i = 0; i < n; i++) {
			if (W >= arr[i].weight) {
				value = value + (double) arr[i].value;
				W = W - arr[i].weight;
			} else {
				value = value + ((double) W / (double) arr[i].weight) * (double) arr[i].value;
				break;
			}
		}
		return value;
	}

	public static void main(String[] args) {
//		values[] = {60,100,120};
//		weight[] = {10,20,30};
		Item[] arr = new Item[] { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
//		Arrays.sort(arr, (a, b) -> (((double) b.value / (double) b.weight)
//				- ((double) a.value / (double) a.weight));
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].value + " " + arr[i].weight);
		}
		double ans = fractionalKnapsack(50, arr, arr.length);
		System.out.println(ans);
	}
}
