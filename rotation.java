package org.learn;

import java.time.Instant;
import java.util.Date;

public class Rotation {

	public static void main(String[] args) {
		int[] a = { 1, 9, 7, 10, 3, 6 };
		int[] b = { 1, 9, 7, 10, 3, 6 };
		// 3,6,1,9,7,10
		// 7,10,3,6,1,9

		int[] r = rotateArray(a, 2, true);

		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}

		System.out.println(" ");
		
		int[] rn = rotateArray(b, 2, false);
		
		for (int i = 0; i < rn.length; i++) {
			System.out.print(rn[i] + " ");
		}

	}

	private static int[] rotateArray(int[] a, int i, boolean isClockwise) {

		for (int index = 0; index < i; index++) {
			if (isClockwise) {
				int last = a[a.length - 1];
				for (int j = a.length - 2; j >= 0; j--) {
					a[j + 1] = a[j];
				}
				a[0] = last;
			} else {
				int first = a[0];
				for (int j = 0; j < a.length - 1; j++) {
					a[j] = a[j + 1];
				}
				a[a.length - 1] = first;
			}
		}
		return a;
	}
}
