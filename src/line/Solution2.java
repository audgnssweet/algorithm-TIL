package line;

import java.util.regex.Pattern;

class Solution2 {

	static String[] chats; //채팅 목록
	static String[] dic; //욕 목록
	static int k;

	public String solution(int k, String[] dic, String chat) {
		chats = chat.split(" ");
		Solution2.dic = dic;
		Solution2.k = k;

		StringBuilder res = new StringBuilder(); //결과
		for (String ch : chats) {
			if (matches(ch)) {
				for (int i = 0; i < ch.length(); i++) {
					res.append("#");
				}
				res.append(" ");
			} else {
				res.append(ch).append(" ");
			}
		}

		res.setLength(res.length() - 1);
		return res.toString();
	}

	private boolean matches(String ch) {
		StringBuilder sb = new StringBuilder();
		sb.append("^");

		char[] chars = ch.toCharArray();
		int i = 0;
		while (i < chars.length) {
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				sb.append(chars[i]);
				i++;
			} else {
				int cnt = 0;
				while (i < chars.length && chars[i] == '.') {
					cnt++;
					i++;
				}
				sb.append(String.format(".{1,%d}", k * cnt));
			}
		}
		sb.append("$");
		String reg = sb.toString();

		for (String d : dic) {
			if (Pattern.matches(reg, d)) {
				return true;
			}
		}

		return false;
	}
}