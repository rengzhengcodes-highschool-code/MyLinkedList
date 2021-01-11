public class TesterMethods {

	public static void overall(boolean failure) {
		System.out.println("\n ~~~ Overall Result ~~~");
		if (failure) {
			System.out.println("Coal for you!");
		} else {
			System.out.println("Happy Holidays!");
		}
	}

	public static void tester(String test) {
		System.out.println("\n ~~~ " + test + " ~~~\n");
	}

	public static int randInt(int end) {
		return randInt(0, end);
	}

	public static int randInt(int start, int end) {
		return (int)(Math.random()* (end - start)) + start;
	}

	public static void passMessage(int testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	public static void passMessage(String testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	public static void errorMessage(int testCase) {
		System.out.println("Test case " + testCase + " failed.");
	}

	public static void errorMessage(String testCase) {
		System.out.println("Test case " + testCase + " failed.");
	}

	public static void errorMessage(String testCase, String expected, String actual) {
		errorMessage(testCase);
		System.out.println("Expected: " + expected);
		System.out.println("Actual:" + actual);
	}

	public static void errorMessage(int testCase, String expected, String actual) {
		errorMessage(Integer.toString(testCase), expected, actual);
	}

	public static void methodMessage(String method, boolean fail) {
		if (fail) {
			System.out.println("\nAt least one test case failed for " + method);
		} else {
			System.out.println(method + " PASSED");
		}
	}

	public static int[] integerToIntArray(Integer[] array) {
		int[] newArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}

		return newArray;
	}

}
