package kti22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {

	public static int standardTime;
	public static int standardFee;
	public static int timeUnit;
	public static int feeUnit;

	public int[] solution(int[] fees, String[] records) {
		standardTime = fees[0];
		standardFee = fees[1];
		timeUnit = fees[2];
		feeUnit = fees[3];

		Parking parking = new Parking();

		Arrays.stream(records)
			.map(this::getTicket)
			.forEach(parking::process);

		return parking.getResultFees();
	}

	private Ticket getTicket(String s) {
		String[] split = s.split(" ");
		return new Ticket(split[1], split[0]);
	}

	static class Parking {

		private Map<String, Ticket> history = new HashMap<>();
		private Map<String, Integer> durationByCars = new HashMap<>();

		public void process(Ticket ticket) {
			if (alreadyIn(ticket)) {
				Ticket in = getInTicket(ticket);
				int duration = in.getDuration(ticket);
				addDuration(ticket, duration);
			} else {
				addHistory(ticket);
			}
		}

		public int[] getResultFees() {
			processRemainTickets();

			return durationByCars.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.mapToInt(Map.Entry::getValue)
				.map(this::getFee)
				.toArray();
		}

		private void processRemainTickets() {
			List<Ticket> outTickets = history.values().stream()
				.map(Ticket::getDefaultOutTicket)
				.collect(Collectors.toList());

			outTickets.forEach(this::process);
		}

		private int getFee(int duration) {
			duration -= standardTime;
			int fee = standardFee;

			while (duration > 0) {
				fee += feeUnit;
				duration -= timeUnit;
			}

			return fee;
		}

		private boolean alreadyIn(Ticket ticket) {
			return history.containsKey(ticket.getCarNum());
		}

		private Ticket getInTicket(Ticket ticket) {
			return history.remove(ticket.getCarNum());
		}

		private void addDuration(Ticket ticket, int duration) {
			durationByCars.put(ticket.getCarNum(), getDurationSum(ticket) + duration);
		}

		private Integer getDurationSum(Ticket ticket) {
			return durationByCars.getOrDefault(ticket.getCarNum(), 0);
		}

		private void addHistory(Ticket ticket) {
			history.put(ticket.getCarNum(), ticket);
		}
	}

	static class Ticket {
		private static final String DELIM = ":";

		private String carNum;
		private String time;

		public Ticket(String carNum, String time) {
			this.carNum = carNum;
			this.time = time;
		}

		public String getCarNum() {
			return this.carNum;
		}

		public int getTime() {
			String[] timeMinute = this.time.split(DELIM);
			int hour = Integer.parseInt(timeMinute[0]);
			int minute = Integer.parseInt(timeMinute[1]);

			return hour * 60 + minute;
		}

		public int getDuration(Ticket out) {
			return out.getTime() - this.getTime();
		}

		public Ticket getDefaultOutTicket() {
			return new Ticket(this.carNum, "23:59");
		}
	}
}
