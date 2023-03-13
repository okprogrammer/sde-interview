package racecondition;

public class RaceConditionExample {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread thread1 = new Thread(getRunnable(counter, "Thread1 final counter "));
		Thread thread2 = new Thread(getRunnable(counter, "Thread2 fianl counter "));

		thread1.start();
		thread2.start();
	}

	private static Runnable getRunnable(Counter counter, String message) {
		return () -> {
			for (int i = 0; i < 1_000_000; i++) {
				counter.incAndGet();
			}
			System.out.println(message + counter.getCount());
		};
	}
}
