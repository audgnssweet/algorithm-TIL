package 다단계칫솔판매;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {

	private List<Person> people;
	private Map<String, Person> personByName = new HashMap<>();

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		people = getPeople(enroll);
		MultiLevel multiLevel = initMultiLevel(referral);

		IntStream.range(0, seller.length)
			.forEach(idx -> multiLevel.sell(findByName(seller[idx]), getProfit(amount[idx])));

		Map<Person, Integer> profitByPerson = multiLevel.getProfitByPerson();

		return people.stream()
			.mapToInt(profitByPerson::get)
			.toArray();
	}

	private int getProfit(int amount) {
		return amount * 100;
	}

	private MultiLevel initMultiLevel(String[] referral) {
		MultiLevel m = new MultiLevel();

		IntStream.range(0, people.size())
			.forEach(idx -> {
				Person person = people.get(idx);
				Person recommender = findByName(referral[idx]);

				m.add(person, recommender);
			});

		return m;
	}

	private Person findByName(String name) {
		return personByName.getOrDefault(name, Person.DEFAULT);
	}

	private List<Person> getPeople(String[] enroll) {
		return Arrays.stream(enroll)
			.map(Person::new)
			.peek(person -> personByName.put(person.getName(), person))
			.collect(Collectors.toList());
	}

	public static class MultiLevel {
		private final Map<Person, Person> recommenderByPerson = new HashMap<>();
		private final Map<Person, Integer> profitByPerson = new HashMap<>();

		public Map<Person, Integer> getProfitByPerson() {
			return profitByPerson;
		}

		public void add(Person person, Person recommender) {
			recommenderByPerson.put(person, recommender);
			profitByPerson.put(person, 0);
		}

		public void sell(Person seller, int profit) {
			if (!seller.isRoot()) {
				profitByPerson.put(seller, profitByPerson.getOrDefault(seller, 0) + getProfitExceptCommission(profit));
				if (getCommission(profit) >= 1) {
					sell(recommenderByPerson.get(seller), getCommission(profit));
				}
			}
		}

		private int getProfitExceptCommission(int profit) {
			return profit - getCommission(profit);
		}

		private int getCommission(int profit) {
			return profit / 10;
		}
	}

	public static class Person {
		public static final Person DEFAULT = new Person("-");

		private final String name;
		private int profit = 0;

		public Person(String name) {
			this.name = name;
		}

		String getName() {
			return name;
		}

		public boolean nameEquals(String name) {
			return this.name.equals(name);
		}

		public boolean isRoot() {
			return this == DEFAULT;
		}
	}
}
