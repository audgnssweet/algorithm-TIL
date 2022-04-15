package BaekJoon12904;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		StringBuilder t = new StringBuilder(scanner.nextLine());

		while (t.length() > s.length()) {
			if (t.charAt(t.length() - 1) == 'A') {
				t.setLength(t.length() - 1);
			} else {
				t.setLength(t.length() - 1);
				t.reverse();
			}
		}

		System.out.println(s.contentEquals(t) ? 1 : 0);
	}
}
