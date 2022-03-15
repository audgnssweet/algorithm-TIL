package BaekJoon13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static boolean[][][][] visited;
	private static char[][] matrics;

	private static Queue<Ball> rq = new LinkedList<>();
	private static Queue<Ball> bq = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] yMax_xMax = br.readLine().split(" ");
		int yMax = Integer.parseInt(yMax_xMax[0]);
		int xMax = Integer.parseInt(yMax_xMax[1]);

		matrics = new char[yMax][xMax];
		visited = new boolean[yMax][xMax][yMax][xMax];

		Ball initialRedBall = new Ball(0, 0, 0, 0);
		Ball initialBlueBall = new Ball(0, 0, 0, 0);

		for (int y = 0; y < yMax; y++) {
			String line = br.readLine();
			for (int x = 0; x < xMax; x++) {
				matrics[y][x] = line.charAt(x);
				if (matrics[y][x] == 'R') {
					initialRedBall = new Ball(y, x, 0, 0);
					matrics[y][x] = '.';
				} else if (matrics[y][x] == 'B') {
					initialBlueBall = new Ball(y, x, 0, 0);
					matrics[y][x] = '.';
				}
			}
		}
		visited[initialRedBall.getyPos()][initialRedBall.getxPos()][initialBlueBall.getyPos()][initialBlueBall.getxPos()] = true;
		rq.add(initialRedBall);
		bq.add(initialBlueBall);

		//여기부터 로직
		while (!rq.isEmpty()) {
			Ball redBall = rq.poll();
			Ball blueBall = bq.poll();

			for (int dir = 0; dir < 4; dir++) {
				Ball nextRedBall = redBall.incline(dir);
				Ball nextBlueBall = blueBall.incline(dir);

				if (nextRedBall.isOverMoving()) {
					System.out.println(-1);
					return;
				}
				if (nextBlueBall.isInHole()) {
					continue; //파란공이 빠져도, 다른 케이스에서 성공할 수 있다.
				}
				if (nextRedBall.isInHole()) {
					System.out.println(nextRedBall.getCount());
					return;
				}
				if (nextRedBall.isSamePosition(nextBlueBall)) {
					if (nextRedBall.moveMoreThan(nextBlueBall)) {
						nextRedBall = nextRedBall.back(dir);
					} else {
						nextBlueBall = nextBlueBall.back(dir);
					}
				}

				if (visited[nextRedBall.getyPos()][nextRedBall.getxPos()][nextBlueBall.getyPos()][nextBlueBall.getxPos()]) {
					continue;
				}
				visited[nextRedBall.getyPos()][nextRedBall.getxPos()][nextBlueBall.getyPos()][nextBlueBall.getxPos()] = true;
				rq.add(nextRedBall);
				bq.add(nextBlueBall);
			}
		}
		System.out.println(-1); //중요
	}

	static class Ball {

		private static int[] dx = {1, 0, -1, 0};
		private static int[] dy = {0, 1, 0, -1};

		private int yPos;
		private int xPos;
		private int count;
		private int moveLen;

		public Ball(int yPos, int xPos, int count, int moveLen) {
			this.yPos = yPos;
			this.xPos = xPos;
			this.count = count;
			this.moveLen = moveLen;
		}

		public int getyPos() {
			return yPos;
		}

		public int getxPos() {
			return xPos;
		}

		public int getCount() {
			return count;
		}

		//기울이기
		public Ball incline(int dir) {
			int curMoveLen = 0;
			int curY = yPos;
			int curX = xPos;

			while (true) {
				int nextMoveLen = curMoveLen + 1;
				int nextY = curY + dy[dir];
				int nextX = curX + dx[dir];

				//벽에 부딫히거나 out of range 면? 그대로 종료
				if (isInWall(nextY, nextX)) {
					return new Ball(curY, curX, count + 1, curMoveLen);
				}
				//구멍에 들어가면? 그대로 종료
				if (isInHole(nextY, nextX)) {
					return new Ball(nextY, nextX, count + 1, nextMoveLen);
				}

				curMoveLen = nextMoveLen;
				curY = nextY;
				curX = nextX;
			}
		}

		private boolean isInWall(int yPos, int xPos) {
			return matrics[yPos][xPos] == '#';
		}

		//위치가 겹치는경우 백하는 것
		public Ball back(int beforeDir) {
			int dir = (beforeDir + 2) % 4;
			return new Ball(yPos + dy[dir], xPos + dx[dir], count, moveLen - 1);
		}

		//구멍에 있는지 확인
		public boolean isInHole() {
			return isInHole(yPos, xPos);
		}

		private boolean isInHole(int yPos, int xPos) {
			return matrics[yPos][xPos] == 'O';
		}

		//더 많이 움직였는지 확인
		public boolean moveMoreThan(Ball otherBall) {
			return this.moveLen > otherBall.moveLen;
		}

		public boolean isSamePosition(Ball otherBall) {
			return this.yPos == otherBall.yPos && this.xPos == otherBall.xPos;
		}

		public boolean isOverMoving() {
			return count > 10;
		}
	}
}
