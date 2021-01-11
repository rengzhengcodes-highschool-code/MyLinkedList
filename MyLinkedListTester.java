import java.util.Arrays;
import java.util.Random;

public class MyLinkedListTester {
	public static boolean failure = false;

	public static void main(String[] args) {
		if (args.length > 0 && Boolean.parseBoolean(args[0])) {
			failure = sizeTester(1000);
			failure = addTester(1000);
			failure = getTester(1000);

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

		for (int test = 0; test < tests; test++) {
			Random seed = new Random(test);
			String[] expected = new String[test];
			String[] reversed = new String[test];
			MyLinkedList analyte = new MyLinkedList();

			for (int index = 0; index < test; index++) {
				expected[index] = Integer.toString(seed.nextInt());
				reversed[test-1-index] = expected[index];
				if (!analyte.add(expected[index])) {
					fail = true;
					System.out.println("Your boolean add output is wrong.");
				}
			}

			if (Arrays.toString(expected).equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage(test, Arrays.toString(expected), analyte.toString());
			}

			if (Arrays.toString(reversed).equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage(test, Arrays.toString(expected), analyte.toStringReversed());
			}
		}

		TesterMethods.methodMessage("add", fail);
		return fail;
	}

	public static boolean getTester(int tests) {
		TesterMethods.tester("get");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			Random seed = new Random(test);
			String[] reference = new String[test];
			MyLinkedList analyte = new MyLinkedList();

			for (int index = 0; index < test; index++) {
				reference[index] = Integer.toString(seed.nextInt());
				analyte.add(reference[index]);
			}

			for (int index = 0; index < test; index++) {
				if (reference[index].equals(analyte.get(index))) {
					//TesterMethods.passMessage(test + "." + index);
				} else {
					TesterMethods.errorMessage(test, Arrays.toString(reference), analyte.toString());
					fail = true;
				}
			}
		}

		TesterMethods.methodMessage("get", fail);
		return fail;
	}
}
