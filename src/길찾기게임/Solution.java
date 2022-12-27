package 길찾기게임;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	class Node {
		int x;
		int y;
		int v;
		Node left;
		Node right;

		Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	public int[][] solution(int[][] nodeinfo) {
		List<Node> node = new ArrayList<>();
		for (int i = 0; i < nodeinfo.length; i++) {
			node.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}
		Collections.sort(node, (n1, n2) -> {
			if (n1.y == n2.y)
				return n1.x - n2.x;
			else
				return n2.y - n1.y;
		});

		Node root = node.get(0);
		for (int i = 1; i < node.size(); i++) {
			makeTree(root, node.get(i));
		}

		List<Integer> res1 = new ArrayList<>();
		List<Integer> res2 = new ArrayList<>();

		vlr(root, res1);
		lrv(root, res2);

		int[][] res = new int[2][];
		res[0] = res1.stream().mapToInt(i -> i).toArray();
		res[1] = res2.stream().mapToInt(i -> i).toArray();

		return res;
	}

	void makeTree(Node root, Node cur) {
		Node comp = root;
		while (true) {
			if (comp.x > cur.x) {
				if (comp.left == null) {
					comp.left = cur;
					return;
				} else {
					comp = comp.left;
				}
			} else {
				if (comp.right == null) {
					comp.right = cur;
					return;
				} else {
					comp = comp.right;
				}
			}
		}
	}

	void vlr(Node cur, List<Integer> arr) {
		arr.add(cur.v);
		if (cur.left != null) {
			vlr(cur.left, arr);
		}
		if (cur.right != null) {
			vlr(cur.right, arr);
		}
	}

	void lrv(Node cur, List<Integer> arr) {
		if (cur.left != null) {
			lrv(cur.left, arr);
		}
		if (cur.right != null) {
			lrv(cur.right, arr);
		}
		arr.add(cur.v);
	}
}
