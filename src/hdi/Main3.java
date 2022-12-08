package hdi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//ABCDEFG
		//CA
		//6 2 2

		char[] dials = br.readLine().toCharArray();
		System.out.println(Arrays.toString(dials));

		br.close();
	}
}
