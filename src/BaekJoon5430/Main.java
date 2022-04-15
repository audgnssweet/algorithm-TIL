package BaekJoon5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String commands = br.readLine();
			boolean reversed = false;

			String res = null;
			int size = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new LinkedList<>();
			makeDeque(br, dq);

			for (Character ch : commands.toCharArray()) {
				if (ch == 'R') {
					reversed = !reversed;
				} else if (ch == 'D') {
					try {
						if (reversed) {
							dq.removeLast();
						} else {
							dq.removeFirst();
						}
					} catch (Exception e) {
						res = "error";
						break;
					}
				}
			}

			if (res == null) {
				res = makePrintForm(dq, reversed);
			}

			System.out.println(res);
		}
	}

	private static void makeDeque(BufferedReader br, Deque<Integer> dq) throws IOException {
		String numbers = br.readLine();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(numbers);
		while (matcher.find()) {
			dq.add(Integer.parseInt(matcher.group()));
		}
	}

	private static String makePrintForm(Deque<Integer> dq, boolean reversed) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(reversed) {
			Iterator<Integer> reverse = dq.descendingIterator();
			while (reverse.hasNext()) {
				sb.append(reverse.next())
					.append(",");
			}
		}else {
			for (Integer number : dq) {
				sb.append(number)
					.append(",");
			}
		}

		if (sb.length() > 1) {
			sb.setLength(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}
}
