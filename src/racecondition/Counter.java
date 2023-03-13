package racecondition;

public class Counter {
	private int count;

	public int getCount() {
		synchronized (this) {
			return this.count;
		}
	}

	public int incAndGet() {
		synchronized (this) {
			this.count++;
			return this.count;
		}
	}
}
