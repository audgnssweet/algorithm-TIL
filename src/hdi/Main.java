package hdi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = Integer.toString(7, 3);
		System.out.println(s);

		br.close();
	}
}
