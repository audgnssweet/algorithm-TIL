package line;

class Solution1 {

	static int[][] arr = new int[1001][2];
	static int res = 0;

	public int solution(int[][] queries) {
		for (int[] query : queries) {
			int idx = query[0];
			int needCnt = query[1];

			int curLen = arr[idx][0];
			int curCnt = arr[idx][1];

			int remainCnt = curLen - curCnt;
			//더 많은 공간이 필요하다면
			if (remainCnt < needCnt) {
				//배열 복사 및 늘리기
				int targetCnt = curCnt + needCnt;
				int targetLen = get2N(targetCnt);

				res += curCnt;
				arr[idx][0] = targetLen; // 늘어난 배열 길이로 초기화
				arr[idx][1] = curCnt + needCnt; //기존 원소 + 새로 들어온 원소 수

			} else {
				arr[idx][1] = curCnt + needCnt;
			}
		}

		return res;
	}

	private int get2N(int target) {
		int res = 1;
		while (res < target) {
			res *= 2;
		}
		return res;
	}
}
