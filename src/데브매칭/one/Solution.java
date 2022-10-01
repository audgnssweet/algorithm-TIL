package 데브매칭.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new String[] {}, "ace15");
	}

	public String solution(String[] registered_list, String new_id) {
		Set<String> registered = new HashSet<>(Arrays.asList(registered_list));
		if (!registered.contains(new_id)) {
			return new_id;
		}

		int i = 0;
		while (i < new_id.length() && !Character.isDigit(new_id.charAt(i))) {
			i++;
		}
		String prefix = new_id.substring(0, i);
		String postfixString = new_id.substring(i);
		int postfix = postfixString.equals("") ? 1 : Integer.parseInt(postfixString);

		while (registered.contains(prefix + postfix)) {
			postfix++;
		}

		return prefix + postfix;

	}
}
