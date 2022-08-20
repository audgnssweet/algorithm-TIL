package toss;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {

	public String[] solution(int[] steps_one, String[] names_one, int[] steps_two, String[] names_two,
		int[] steps_three, String[] names_three) {
		Map<String, Integer> stepsByPerson = new HashMap<>();

		Map<String, Integer> firstDay = new HashMap<>();
		for (int i = 0; i < names_one.length; i++) {
			String person = names_one[i];
			int step = steps_one[i];
			if (firstDay.containsKey(person)) {
				step = Math.max(step, firstDay.get(person));
			}
			firstDay.put(person, step);
		}

		Map<String, Integer> secondDay = new HashMap<>();
		for (int i = 0; i < names_two.length; i++) {
			String person = names_two[i];
			int step = steps_two[i];
			if (secondDay.containsKey(person)) {
				step = Math.max(step, secondDay.get(person));
			}
			secondDay.put(person, step);
		}

		Map<String, Integer> thirdDay = new HashMap<>();
		for (int i = 0; i < names_three.length; i++) {
			String person = names_three[i];
			int step = steps_three[i];
			if (thirdDay.containsKey(person)) {
				step = Math.max(step, thirdDay.get(person));
			}
			thirdDay.put(person, step);
		}

		firstDay.entrySet()
			.forEach(entry -> {
				String person = entry.getKey();
				Integer cnt = stepsByPerson.getOrDefault(person, 0);
				stepsByPerson.put(person, cnt + entry.getValue());
			});

		secondDay.entrySet()
			.forEach(entry -> {
				String person = entry.getKey();
				Integer cnt = stepsByPerson.getOrDefault(person, 0);
				stepsByPerson.put(person, cnt + entry.getValue());
			});

		thirdDay.entrySet()
			.forEach(entry -> {
				String person = entry.getKey();
				Integer cnt = stepsByPerson.getOrDefault(person, 0);
				stepsByPerson.put(person, cnt + entry.getValue());
			});

		return stepsByPerson.entrySet()
			.stream()
			.sorted((e1, e2) -> {
				if (e1.getValue() == e2.getValue()) {
					return e1.getKey().compareTo(e2.getKey());
				}
				return e2.getValue() - e1.getValue();
			})
			.map(Map.Entry::getKey)
			.toArray(String[]::new);
	}
}
