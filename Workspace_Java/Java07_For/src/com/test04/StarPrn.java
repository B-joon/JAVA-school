package com.test04;

public class StarPrn {
	
	/*
	 * ★
	 * ★★
	 * ★★★
	 * ★★★★
	 * ★★★★★
	 */

	public static void prn01() {
		System.out.println();
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("★");
			}
			System.out.println();
			
		}
		
	}
	/*
	 * ★★★★★
	 * ★★★★
	 * ★★★
	 * ★★
	 * ★
	 */
	public static void prn02() {
		System.out.println();
//		for (int i = 5; i > 0; i--) {
//			for (int j = i; j > 0; j--) {
//				System.out.print("★");
//			}
//			System.out.println();
//		}
//		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
	}
	/*
	 *     ★
	 *    ★★
	 *   ★★★
	 *  ★★★★
	 * ★★★★★
	 */
	public static void prn03() {
		System.out.println();
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > 0; j--) {
				if (i < j) {
					System.out.print(" ");
					
				} else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 4 - i; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 0; k < i + 1; k++) {
//				System.out.print("★");
//			}
//			System.out.println();
//		}
		
	}
	/*
	 * ★★★★★
	 *  ★★★★
	 *   ★★★
	 *    ★★
	 *     ★
	 */
	public static void prn04() {
		
		System.out.println();
//		for (int i = 1; i < 6; i++) {
//			for (int j = 5; j > 0; j--) {
//				if (i < j) {
//					System.out.print("★");
//					
//				} else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 5 - i; k++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	/*
	 *     ★
	 *    ★★★
	 *   ★★★★★
	 *  ★★★★★★★
	 * ★★★★★★★★★
	 */
	public static void prn05() {
		System.out.println();
//		for (int i = 0; i < 5; i++) {
//			for (int j = 4; j > i; j--) {
//				System.out.println(" ");
//			}
//			for (int y = 0; y <= i; y++) {
//				System.out.println("★");
//			}
//			for (int k = 1; k <= i; k++) {
//				System.out.println("★");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < 5; i++) {
			for (int j = 4 - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int y = 0; y < 2 * i + 1; y++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	public static void prn06() {
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for (int y = 0; y <= i; y++) {
				System.out.print("★");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("★");
			}
			System.out.println();
		}
		for (int i = 0; i < 5 ; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			for (int y = 4; y > i; y--) {
				System.out.print("★");
			}
			for (int k = 3; k > i; k++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}

}
