package arr_part1;

public class StockBuyAndSell {

	static int stockBuyAndSell(int[] prices) {
		int n = prices.length;
		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = 0;
				if (i < j) {
					sum = prices[j] - prices[i];
				}
				if (sum > maxProfit) {
					maxProfit = sum;
				}
			}

		}
		return maxProfit;
	}

	static int stockBuyAndSellN(int[] prices) {
		int n = prices.length;
		int first = 0;
		int second = 1;
		int maxProfit = 0;
		while (first < n && second < n) {
			int sum = prices[second] - prices[first];
			if (sum > maxProfit) {
				maxProfit = sum;
			}
			if (prices[first] < prices[second]) {
				second++;

			} else {
				first = second;
				second++;
			}

		}
		return maxProfit;
	}

	static int stockBuyAndSellMethod3(int[] prices) {
		int n = prices.length;
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] input = { 7, 1, 5, 3, 6, 4 };
		int profit = stockBuyAndSellMethod3(input);
		System.out.println(profit);
	}

}
