package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meeting {
	int start;
	int end;
	int pos;

	public Meeting(int start, int end, int pos) {
		super();
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}

class MeetingComparator implements Comparator<Meeting> {

	@Override
	public int compare(Meeting o1, Meeting o2) {
		if (o1.end < o2.end) {
			return -1;
		} else if (o1.end > o2.end) {
			return 1;
		} else {
			return 0;
		}
	}

}

public class GreedySolution {

	static int findPlatform(int arr[], int dep[], int n) {
		int totalPlatform = 1;
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) {
					count++;
				}
			}
			totalPlatform = Math.max(count, totalPlatform);
		}
		return totalPlatform;
	}

	static int findPlatformOptimize(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1;
		int j = 0;
		int platform = 1;
		int count = 1;
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			platform = Math.max(platform, count);
		}
		return platform;
	}

	static int maxMeetings(int start[], int end[], int n) {
		List<Meeting> meetingList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			meetingList.add(new Meeting(start[i], end[i], i + 1));
		}
		Collections.sort(meetingList, new MeetingComparator());
		int limit = meetingList.get(0).end;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (limit < meetingList.get(i).start) {
				limit = meetingList.get(i).end;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] start = new int[] { 1, 3, 0, 5, 8, 5 };
		int[] end = new int[] { 2, 4, 5, 7, 9, 9 };
		int n = start.length;
		int maxMeetings = maxMeetings(start, end, n);
		System.out.println(maxMeetings);
	}

}
