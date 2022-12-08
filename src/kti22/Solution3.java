package kti22;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3 {

	static int[] apeach;
	static int[] ryan = new int[11];
	static int scoreGapMax = 0;
	static PriorityQueue<int[]> winPlans = new PriorityQueue<>((p1, p2) -> {
		for (int i = p1.length - 1; i >= 0; i--) {
			if (p1[i] > p2[i]) {
				return -1;
			} else if (p2[i] > p1[i]) {
				return 1;
			}
		}
		return 0;
	});

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] res = s.solution(9, new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
		System.out.println(Arrays.toString(res));
	}

	public int[] solution(int n, int[] info) {
		apeach = info;
		play(0, n);
		if (winPlans.isEmpty()) {
			return new int[] {-1};
		}
		return winPlans.poll();
	}

	void play(int depth, int arrow) {
		if (isEnd(depth, arrow)) {
			if (isLionWin()) {
				renewWinPlan(arrow);
			}
		} else {
			if (canShot(depth, arrow)) {
				shotAndPlay(depth, arrow);
			}
			noShotAndPlay(depth, arrow);
		}
	}

	void shotAndPlay(int depth, int arrow) {
		int needArrow = apeach[depth] + 1;
		ryan[depth] = needArrow;
		play(depth + 1, arrow - needArrow);
		ryan[depth] = 0;
	}

	void noShotAndPlay(int depth, int arrow) {
		play(depth + 1, arrow);
	}

	boolean canShot(int target, int arrow) {
		return apeach[target] < arrow;
	}

	boolean isEnd(int depth, int arrow) {
		return depth == apeach.length || arrow <= 0;
	}

	boolean isLionWin() {
		int[] scores = getScores();
		int apeachScore = scores[0];
		int ryanScore = scores[1];

		return ryanScore > apeachScore;
	}

	void renewWinPlan(int arrow) {
		int scoreGap = getScoreGap();
		if (scoreGap > scoreGapMax) {
			winPlans.clear();
			scoreGapMax = scoreGap;
		}
		if (scoreGap == scoreGapMax) {
			addWinPlan(arrow);
		}
	}

	void addWinPlan(int arrow) {
		if (arrow > 0) {
			ryan[ryan.length - 1] = arrow;
			winPlans.offer(Arrays.copyOf(ryan, ryan.length));
			ryan[ryan.length - 1] = 0;
		}
		winPlans.offer(Arrays.copyOf(ryan, ryan.length));
	}

	int getScoreGap() {
		int[] scores = getScores();
		int apeachScore = scores[0];
		int ryanScore = scores[1];

		return ryanScore - apeachScore;
	}

	int[] getScores() {
		int apeachScore = 0;
		int ryanScore = 0;
		for (int i = 0; i < apeach.length; i++) {
			if (isApeachWin(i)) {
				apeachScore += getScore(i);
			} else if (isRyanWin(i)) {
				ryanScore += getScore(i);
			}
		}

		return new int[] {apeachScore, ryanScore};
	}

	int getScore(int i) {
		return 10 - i;
	}

	boolean isApeachWin(int target) {
		return shot(apeach[target]) && apeach[target] >= ryan[target];
	}

	boolean isRyanWin(int target) {
		return shot(ryan[target]) && ryan[target] > apeach[target];
	}

	boolean shot(int arrowCnt) {
		return arrowCnt > 0;
	}
}
