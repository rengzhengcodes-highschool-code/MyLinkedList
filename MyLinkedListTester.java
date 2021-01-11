import java.util.Arrays;

public class MyLinkedListTester {
	public static boolean failure = false;

	public static void main(String[] args) {
		System.out.println("Assumptions:");
		System.out.println("MyLinkedList.toString() is functioning properly.");

		failure = sizeTester(1000);

		TesterMethods.overall(failure);
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
		for (int test = 0; test < tests; test++) {
			int sizeExpected = TesterMethods.randInt(tests);
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

		return fail;
	}
}
