package kakao;

class Solution3 {

	static int end;

	static double[] discounts = {0.1, 0.2, 0.3, 0.4};

	static int[] emoticons;
	static int[][] users;

	static double[] temp;
	static int tempGaip;
	static int tempMoney;

	static int resGaip;
	static int resMoney;

	public int[] solution(int[][] users, int[] emoticons) {
		end = emoticons.length;
		temp = new double[end];
		Solution3.emoticons = emoticons;
		Solution3.users = users;

		dfs(0);

		return new int[] {resGaip, resMoney};
	}

	private void dfs(int depth) {
		if (depth == end) {
			init();
			setRes();
			renewIfMaxValue();
		} else {
			for (int i = 0; i < discounts.length; i++) {
				temp[depth] = discounts[i];
				dfs(depth + 1);
			}
		}
	}

	private void renewIfMaxValue() {
		if (tempGaip > resGaip) {
			resGaip = tempGaip;
			resMoney = tempMoney;
		} else if (tempGaip == resGaip && tempMoney > resMoney) {
			resMoney = tempMoney;
		}
	}

	private void setRes() {
		for (int[] user : users) {
			int discount = user[0];
			int threshold = user[1];

			int price = getPrice(discount);
			if (price >= threshold) {
				tempGaip += 1;
			} else {
				tempMoney += price;
			}
		}
	}

	private void init() {
		tempGaip = 0;
		tempMoney = 0;
	}

	private int getPrice(int discount) {
		int sum = 0;
		for (int i = 0; i < emoticons.length; i++) {
			if (temp[i] * 100 >= discount) {
				sum += emoticons[i] * (1 - temp[i]);
			}
		}
		return sum;
	}
}
