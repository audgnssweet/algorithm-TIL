package kakao;

class Solution4 {

	static long[] numbers;
	static int leaf;

	static int[] res;

	public int[] solution(long[] numbers) {
		res = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			String cur = Long.toBinaryString(numbers[i]);

			int len = cur.length();
			int h = 1;
			while (Math.pow(2, h) <= len) {
				h++;
			}

			leaf = h;

			int needLen = (int)Math.pow(2, h);
			while (cur.length() < needLen - 1) {
				cur = "0" + cur;
			}

			int[] binTree = new int[needLen];
			makeBinTree(binTree, 1, 0, cur.length() - 1, cur);

			if (dfs(1, 1, binTree)) {
				res[i] = 1;
			}
		}

		return res;
	}

	private boolean dfs(int cur, int depth, int[] tree) {
		//리프노드라면
		if (depth == leaf) {
			return true;
		} else {
			//리프노드가 아니면
			int curNode = tree[cur];
			int left = tree[cur * 2];
			int right = tree[cur * 2 + 1];

			if (curNode == 0) {
				if (left != 0 || right != 0) {
					return false;
				}
			}
			return dfs(cur * 2, depth + 1, tree) && dfs(cur * 2 + 1, depth + 1, tree);
		}
	}

	private void makeBinTree(int[] tree, int cur, int start, int end, String bin) {
		int mid = (start + end) / 2; //처음엔 3

		tree[cur] = bin.charAt(mid) - '0'; //1번에다가 3번째 수 넣었음
		if (start != end) {
			makeBinTree(tree, cur * 2, start, mid - 1, bin); //왼쪽 만들기
			makeBinTree(tree, (cur * 2) + 1, mid + 1, end, bin); //오른쪽 만들기
		}
	}

	public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		solution4.solution(new long[] {63, 111, 95});
	}
}
