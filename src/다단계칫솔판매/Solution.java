package 다단계칫솔판매;

import java.util.HashMap;
import java.util.Map;

class Solution {

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, Node> nodeByPerson = new HashMap<>();
		nodeByPerson.put("-", new Node("-"));

		for (int i = 0; i < enroll.length; i++) {
			String name = enroll[i];
			String refName = referral[i];

			Node person = nodeByPerson.getOrDefault(name, new Node(name));
			Node ref = nodeByPerson.getOrDefault(refName, new Node(refName));

			person.ref = ref;

			nodeByPerson.put(name, person);
			nodeByPerson.put(refName, ref);
		}

		for (int i = 0; i < seller.length; i++) {
			Node person = nodeByPerson.get(seller[i]);
			int ben = amount[i] * 100;

			person.setBenefit(ben);
		}

		int[] res = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			Node person = nodeByPerson.get(enroll[i]);

			res[i] = person.benefit;
		}

		return res;
	}

	static class Node {
		String name;
		int benefit;

		Node ref;

		public Node(String name) {
			this.name = name;
		}

		public void setBenefit(int ben) {
			int refBenefit = (int)(ben * 0.1);
			if (refBenefit < 1) {
				benefit += ben;
			} else {
				benefit += (ben - refBenefit);
				if (ref != null) {
					ref.setBenefit(refBenefit);
				}
			}
		}
	}
}
