public class MyLinkedListTester extends TesterMethods {
	public static boolean failure = false;

	public static void main(String[] args) {
		failure = sizeTester(1000);

		TesterMethods.overall(failure);
	}

	public static boolean sizeTester(int tests) {
		tester("size");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			int sizeExpected = TesterMethods.randInt(100);
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
}
