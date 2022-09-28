package kakao;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
	static int[] dues = new int[26];
	static List<Integer> res = new ArrayList<>();

	static int due;

	private static boolean isExpired(int yy, int mm, int dd) {
		int cur = yy * 12 * 28 + mm * 28 + dd;
		return cur < due;
	}

	public int[] solution(String today, String[] terms, String[] privacies) {
		for (String term : terms) {
			String[] categoryDue = term.split(" ");
			char category = categoryDue[0].charAt(0);
			int my = Integer.parseInt(categoryDue[1]);

			dues[category - 'A'] = my;
		}

		String[] ymd = today.split("\\.");
		int y = Integer.parseInt(ymd[0]);
		int m = Integer.parseInt(ymd[1]);
		int d = Integer.parseInt(ymd[2]);

		due = (y - 2000) * 12 * 28 + m * 28 + d;

		for (int i = 0; i < privacies.length; i++) {
			String[] startCategory = privacies[i].split(" ");
			String start = startCategory[0];
			char category = startCategory[1].charAt(0);

			String[] yearMonthDate = start.split("\\.");
			int year = Integer.parseInt(yearMonthDate[0]);
			int month = Integer.parseInt(yearMonthDate[1]);
			int date = Integer.parseInt(yearMonthDate[2]);

			month += ((year - 2000) * 12);

			int gap = month + dues[category - 'A'];

			int yy = gap / 12;
			int mm = gap % 12;
			int dd = date - 1;

			if (dd == 0) {
				dd = 28;
				mm -= 1;
				if (mm == 0) {
					mm = 12;
					yy -= 1;
				}
			}

			if (isExpired(yy, mm, dd)) {
				res.add(i + 1);
			}
		}

		return Solution1.res.stream()
			.mapToInt(i -> i)
			.toArray();
	}
}
