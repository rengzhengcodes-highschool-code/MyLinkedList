import java.util.Arrays;
import java.util.Random;
public class MyLinkedListTester {
	public static boolean failure = false;

	public static void main(String[] args) {
		if (args.length > 0 && Boolean.parseBoolean(args[0])) {
			failure = sizeTester(1000);

			TesterMethods.overall(failure);
		} else {
			System.out.println("Assumptions:");
			String[] assumptions = {
				"MyLinkedList.toString() is functioning properly.",
				"MyLinkedList.toStringReversed() is functioning properly.",
				"If you have read these assumptions, enter true into the 1st arg of main."
			};

			for (int assumption = 0; assumption < assumptions.length; assumption++) {
				System.out.println(assumption + ". " + assumptions[assumption]);
			}
		}
	}

	public static boolean sizeTester(int tests) {
		TesterMethods.tester("size");
		boolean fail = false;
		//tests all size numbers from 0 to tests - 1
		for (int test = 0; test < tests; test++) {
			int sizeExpected = test;
			MyLinkedList analyte = new MyLinkedList();

			for (int amount = 0; amount < sizeExpected; amount++) {
				analyte.add(Integer.toString(amount));
			}

			if (sizeExpected == analyte.size()) {
				//TesterMethods.passMessage(test);
			} else {
				TesterMethods.errorMessage(test, sizeExpected, analyte.size());
				fail = true;
			}
		}
		//tests random sizes test times up to test size
		Random sizeSeed = new Random(tests);
		for (int test = 0; test < tests; test++) {
			int sizeExpected = sizeSeed.nextInt(tests);
			MyLinkedList analyte = new MyLinkedList();

			for (int amount = 0; amount < sizeExpected; amount++) {
				analyte.add(Integer.toString(amount));
			}

			if (sizeExpected == analyte.size()) {
				//TesterMethods.passMessage(test);
			} else {
				TesterMethods.errorMessage(test, sizeExpected, analyte.size());
				fail = true;
			}
		}

		TesterMethods.methodMessage("size", fail);
		return fail;
	}

	public static boolean addTester(int tests) {
		TesterMethods.tester("add");
		boolean fail = false;

		for (int test = 0; test < tests; test++);

		return fail;
	}
}
