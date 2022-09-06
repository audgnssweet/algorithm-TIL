package 표편집;

import java.util.Stack;

public class Solution {

	public String solution(int n, int k, String[] cmd) {
		Node root = new Node(-1);
		Node end = new Node(-1);

		Node prev = root;
		for (int i = 0; i < n; i++) {
			Node cur = new Node(i);
			cur.prev = prev;
			cur.next = end;

			prev.next = cur;
			end.prev = cur;

			prev = cur;
		}

		Node cur = root.next;
		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}

		Program program = new Program(cur);

		for (String command : cmd) {
			String[] s = command.split(" ");

			switch (s[0]) {
				case "U":
					program.moveNodeUp(Integer.parseInt(s[1]));
					break;
				case "D":
					program.moveNodeDown(Integer.parseInt(s[1]));
					break;
				case "C":
					program.deleteNode();
					break;
				case "Z":
					program.reloadNode();
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('X');
		}

		cur = root.next;
		while (!cur.isEnd()) {
			sb.setCharAt(cur.idx, 'O');
			cur = cur.next;
		}

		return sb.toString();
	}

	static class Program {
		Node cur;
		Stack<Node> deleted;

		public Program(Node cur) {
			this.cur = cur;
			this.deleted = new Stack<>();
		}

		public void moveNodeUp(int cnt) {
			for (int i = 0; i < cnt; i++) {
				cur = cur.prev;
			}
		}

		public void moveNodeDown(int cnt) {
			for (int i = 0; i < cnt; i++) {
				cur = cur.next;
			}
		}

		public void deleteNode() {
			deleted.push(cur);
			cur = cur.delete();
		}

		public void reloadNode() {
			Node reload = deleted.pop();
			reload.reload();
		}
	}

	static class Node {
		int idx;
		Node prev, next;

		public Node(int idx) {
			this.idx = idx;
			this.prev = null;
			this.next = null;
		}

		public boolean isEnd() {
			return idx == -1;
		}

		public Node delete() {
			prev.next = next;
			next.prev = prev;
			if (next.isEnd()) {
				return prev;
			}
			return next;
		}

		public void reload() {
			prev.next = this;
			next.prev = this;
		}
	}
}
