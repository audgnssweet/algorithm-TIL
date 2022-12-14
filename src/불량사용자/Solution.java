package 불량사용자;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	//bit 로 방문체크 한번에 할 수 있는 용도
	Set<Integer> set = new HashSet<>();

	public int solution(String[] user_id, String[] banned_id) {
		go(0, user_id, banned_id, 0);

		return set.size();
	}

	/**
	 *
	 * @param index : 현재 몇 개까지 정해졌는지
	 * @param user_id
	 * @param banned_id
	 * @param bit : 방문 체크 용도
	 */
	void go(int index, String[] user_id, String[] banned_id, int bit) {
		if (index == banned_id.length) {
			set.add(bit);
		} else {
			// \\w 는 알파벳 혹은 숫자
			String reg = banned_id[index].replace("*", "[\\w]");
			for (int i = 0; i < user_id.length; i++) {
				if (((bit >> i) & 1) == 1 || !user_id[i].matches(reg)) {
					continue;
				}
				go(index + 1, user_id, banned_id, bit | (1 << i));
			}
		}
	}
}
