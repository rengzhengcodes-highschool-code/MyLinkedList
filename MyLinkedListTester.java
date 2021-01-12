import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyLinkedListTester {
	public static boolean failure = false;

	public static void main(String[] args) {
		if (args.length > 0 && Boolean.parseBoolean(args[0])) {
			failure = failure || addTester(100);
			failure = sizeTester(10) || failure;
			failure = addAtIndexTester(100) || failure;
			failure = getTester(10) || failure;
			failure = setTester(100) || failure;
			failure = removeTester(100) || failure;
			failure = extendTester(1000) || failure;

			TesterMethods.overall(failure);
		} else {
			System.out.println("Assumptions:");
			String[] assumptions = {
				"MyLinkedList.toString() is functioning properly.",
				"MyLinkedList.toStringReversed() is functioning properly.",
				"You know that size() tests add()'s size increment function and that if add() does not work the tester will not proceed",
				"If you have read these assumptions, enter true into the 1st arg of main.",
			};

			for (int assumption = 0; assumption < assumptions.length; assumption++) {
				System.out.println(assumption + ". " + assumptions[assumption]);
			}
		}
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
				TesterMethods.errorMessage("Forward links wrong.");
				TesterMethods.errorMessage(test, Arrays.toString(expected), analyte.toString());
			}

			if (Arrays.toString(reversed).equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("backward links wrong.");
				TesterMethods.errorMessage(test, Arrays.toString(expected), analyte.toStringReversed());
			}
		}

		TesterMethods.methodMessage("add", fail);
		return fail;
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

	public static boolean addAtIndexTester(int tests) {
		TesterMethods.tester("addAtIndex");
		boolean fail = false;

		MyLinkedList analyte = new MyLinkedList();
		//throws test
		int[] indices = {-2, -1, 1, 2};

		for (int index : indices) {
			try {
				analyte.add(index, "test");
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 2, 3};

		for (int index : indices) {
			try {
				analyte.add(index, "test");
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 3, 4};

		for (int index : indices) {
			try {
				analyte.add(index, "test");
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}
		//adding at start tester
		System.out.println("Testing adding at the start");

		for (int test = 0; test < tests; test++) {
			analyte = new MyLinkedList();
			ArrayList<String> reference = new ArrayList<String>();
			Random seed = new Random(test);
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				analyte.add(0, string);
				reference.add(0, string);
			}

			if (reference.size() != analyte.size()) {
				TesterMethods.errorMessage("Size is wrong.");
				TesterMethods.errorMessage(test, reference.size(), analyte.size());
				fail = true;
			}

			if (reference.toString().equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Forward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toString());
			}

			Collections.reverse(reference);
			if (reference.toString().equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Backward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toStringReversed());
			}
		}
		//adding at end tester.
		System.out.println("Testing adding at the end");

		for (int test = 0; test < tests; test++) {
			analyte = new MyLinkedList();
			ArrayList<String> reference = new ArrayList<String>();
			Random seed = new Random(test);
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				analyte.add(trial, string);
				reference.add(trial, string);
			}

			if (reference.size() != analyte.size()) {
				TesterMethods.errorMessage("Size is wrong.");
				TesterMethods.errorMessage(test, reference.size(), analyte.size());
				fail = true;
			}

			if (reference.toString().equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Forward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toString());
			}

			Collections.reverse(reference);
			if (reference.toString().equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Backward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toStringReversed());
			}
		}
		//adding randomly
		System.out.println("Testing adding randomly to the list");

		for (int test = 0; test < tests; test++) {
			analyte = new MyLinkedList();
			ArrayList<String> reference = new ArrayList<String>();
			Random seed = new Random(test);
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				int position = seed.nextInt(trial + 1);
				analyte.add(position, string);
				reference.add(position, string);
			}

			if (reference.size() != analyte.size()) {
				TesterMethods.errorMessage("Size is wrong.");
				TesterMethods.errorMessage(test, reference.size(), analyte.size());
				fail = true;
			}

			if (reference.toString().equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Forward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toString());
			}

			Collections.reverse(reference);
			if (reference.toString().equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Backward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toStringReversed());
			}
		}

		TesterMethods.methodMessage("addAtIndex", fail);
		return fail;
	}

	public static boolean getTester(int tests) {
		TesterMethods.tester("get");
		boolean fail = false;
		//throws test
		MyLinkedList analyte = new MyLinkedList();
		int[] indices = {-2, -1, 0, 1, 2};

		for (int index : indices) {
			try {
				analyte.get(index);
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 1, 2};

		for (int index : indices) {
			try {
				analyte.get(index);
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 2, 3};

		for (int index : indices) {
			try {
				analyte.get(index);
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		for (int test = 0; test < tests; test++) {
			Random seed = new Random(test);
			String[] reference = new String[test];
			analyte = new MyLinkedList();

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

	public static boolean setTester(int tests) {
		TesterMethods.tester("set");
		boolean fail = false;
		//throws test
		MyLinkedList analyte = new MyLinkedList();
		int[] indices = {-2, -1, 0, 1, 2};

		for (int index : indices) {
			try {
				analyte.set(index, "test");
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 1, 2};

		for (int index : indices) {
			try {
				analyte.set(index, "text");
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 2, 3};

		for (int index : indices) {
			try {
				analyte.set(index, "text");
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		for (int test = 0; test < tests; test++) {
			ArrayList<String> reference = new ArrayList<String>();
			analyte = new MyLinkedList();
			Random seed = new Random(test);
			//generator sequence
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				reference.add(string);
				analyte.add(string);
			}
			//tester sequence
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				if (!reference.set(trial, string).equals(analyte.set(trial, string))) {
					fail = true;
					TesterMethods.errorMessage("Set not returning the right values.");
				}
			}

			if (reference.toString().equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Forward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toString());
			}

			Collections.reverse(reference);
			if (reference.toString().equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Backward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toStringReversed());
			}
		}

		TesterMethods.methodMessage("set", fail);
		return fail;
	}

	public static boolean removeTester(int tests) {
		TesterMethods.tester("remove");
		boolean fail = false;
		//throws test
		MyLinkedList analyte = new MyLinkedList();
		int[] indices = {-2, -1, 0, 1, 2};

		for (int index : indices) {
			try {
				analyte.remove(index);
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 1, 2};

		for (int index : indices) {
			try {
				analyte.remove(index);
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}

		analyte.add("test");
		indices = new int[]{-2, -1, 2, 3};

		for (int index : indices) {
			try {
				analyte.remove(index);
				TesterMethods.errorMessage("IndexOutOfBoundsException expected at " + index + " at size " + 0);
				fail = true;
			} catch (IndexOutOfBoundsException e) {
				//TesterMethods.passMessage("Correct exception thrown.");
			} catch (Exception e) {
				TesterMethods.errorMessage("Incorrect exception thrown for index " + index + " at size " + 0);
				e.printStackTrace();
				fail = true;
			}
		}
		//start remove tester
		System.out.println("Removing from start.");

		for (int test = 0; test < tests; test++) {
			ArrayList<String> reference = new ArrayList<String>();
			analyte = new MyLinkedList();
			Random seed = new Random(test);
			//generator sequence
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				reference.add(string);
				analyte.add(string);
			}
			//tester sequence
			for (int trial = 0; trial < test; trial++) {
				if (!reference.remove(0).equals(analyte.remove(0))) {
					TesterMethods.errorMessage("Remove does not return the correct value");
				}
				if (reference.size() != analyte.size()) {
					TesterMethods.errorMessage("Size is not decrementing properly");
				}
			}

			if (reference.toString().equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Forward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toString());
			}

			Collections.reverse(reference);
			if (reference.toString().equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Backward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toStringReversed());
			}
		}
		//end remove tester
		System.out.println("Removing from end.");

		for (int test = 0; test < tests; test++) {
			ArrayList<String> reference = new ArrayList<String>();
			analyte = new MyLinkedList();
			Random seed = new Random(test);
			//generator sequence
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				reference.add(string);
				analyte.add(string);
			}
			//tester sequence
			for (int trial = 0; trial < test; trial++) {
				if (!reference.remove(test-1-trial).equals(analyte.remove(test-1-trial))) {
					TesterMethods.errorMessage("Remove does not return the correct value");
				}
				if (reference.size() != analyte.size()) {
					TesterMethods.errorMessage("Size is not decrementing properly");
				}
			}

			if (reference.toString().equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Forward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toString());
			}

			Collections.reverse(reference);
			if (reference.toString().equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Backward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toStringReversed());
			}
		}
		//random remove tester
		System.out.println("Removing from random indices.");

		for (int test = 0; test < tests; test++) {
			ArrayList<String> reference = new ArrayList<String>();
			analyte = new MyLinkedList();
			Random seed = new Random(test);
			//generator sequence
			for (int trial = 0; trial < test; trial++) {
				String string = Integer.toString(seed.nextInt());
				reference.add(string);
				analyte.add(string);
			}
			//tester sequence
			for (int trial = 0; trial < test; trial++) {
				int removeAt = seed.nextInt(reference.size());
				if (!reference.remove(removeAt).equals(analyte.remove(removeAt))) {
					TesterMethods.errorMessage("Remove does not return the correct value");
				}
				if (reference.size() != analyte.size()) {
					TesterMethods.errorMessage("Size is not decrementing properly");
				}
			}

			if (reference.toString().equals(analyte.toString())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Forward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toString());
			}

			Collections.reverse(reference);
			if (reference.toString().equals(analyte.toStringReversed())) {
				//TesterMethods.passMessage(test);
			} else {
				fail = true;
				TesterMethods.errorMessage("Backward links broken.");
				TesterMethods.errorMessage(test, reference.toString(), analyte.toStringReversed());
			}
		}

		TesterMethods.methodMessage("remove", fail);
		return fail;
	}

	public static boolean extendTester(int tests) {
		TesterMethods.tester("extend");
		boolean fail = false;
		//static tests
		//combining 2 empty Linkedlists
		System.out.println("Combining 2 empty LinkedLists");

		MyLinkedList a = new MyLinkedList();
		MyLinkedList b = new MyLinkedList();
		a.extend(b);
		if (a.size() == 0) {
			TesterMethods.passMessage("Size good.");
		} else {
			fail = true;
			TesterMethods.errorMessage("a size", a.size(), 0);
		}
		if (b.size() != 0 && b.toString().equals("[]") && b.toStringReversed().equals("[]")) {
			fail = true;
			TesterMethods.errorMessage("b not cleared properly");
		}
		if (a.toString().equals("[]")) {
			TesterMethods.passMessage("Links good forward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going forwards", a.toString(), "[]");
		}
		if (a.toStringReversed().equals("[]")) {
			TesterMethods.passMessage("Links good backward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going backwards", a.toStringReversed(), "[]");
		}
		//empty extends 1
		System.out.println("empty extends 1");

		a = new MyLinkedList();
		b = new MyLinkedList();
		b.add("Test");
		a.extend(b);
		if (a.size() == 1) {
			TesterMethods.passMessage("Size good.");
		} else {
			fail = true;
			TesterMethods.errorMessage("a size", a.size(), 1);
		}
		if (b.size() != 0 && b.toString().equals("[]") && b.toStringReversed().equals("[]")) {
			fail = true;
			TesterMethods.errorMessage("b not cleared properly");
		}
		if (a.toString().equals("[Test]")) {
			TesterMethods.passMessage("Links good forward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going forwards", a.toString(), "[Test]");
		}
		if (a.toStringReversed().equals("[Test]")) {
			TesterMethods.passMessage("Links good backward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going backwards", a.toStringReversed(), "[Test]");
		}
		//empty extends 2
		System.out.println("empty extends 2");

		a = new MyLinkedList();
		b = new MyLinkedList();
		b.add("test1");
		b.add("test2");
		a.extend(b);
		if (a.size() == 2) {
			TesterMethods.passMessage("Size good.");
		} else {
			fail = true;
			TesterMethods.errorMessage("a size", a.size(), 2);
		}
		if (b.size() != 0 && b.toString().equals("[]") && b.toStringReversed().equals("[]")) {
			fail = true;
			TesterMethods.errorMessage("b not cleared properly");
		}
		if (a.toString().equals("[test1, test2]")) {
			TesterMethods.passMessage("Links good forward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going forwards", a.toString(), "[test1, test2]");
		}
		if (a.toStringReversed().equals("[test2, test1]")) {
			TesterMethods.passMessage("Links good backward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going backwards", a.toStringReversed(), "[test2, test1]");
		}
		//1 extends empty
		System.out.println("1 extends empty");

		a = new MyLinkedList();
		b = new MyLinkedList();
		a.add("Test");
		a.extend(b);
		if (a.size() == 1) {
			TesterMethods.passMessage("Size good.");
		} else {
			fail = true;
			TesterMethods.errorMessage("a size", a.size(), 1);
		}
		if (b.size() != 0 && b.toString().equals("[]") && b.toStringReversed().equals("[]")) {
			fail = true;
			TesterMethods.errorMessage("b not cleared properly");
		}
		if (a.toString().equals("[Test]")) {
			TesterMethods.passMessage("Links good forward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going forwards", a.toString(), "[Test]");
		}
		if (a.toStringReversed().equals("[Test]")) {
			TesterMethods.passMessage("Links good backward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going backwards", a.toStringReversed(), "[Test]");
		}
		//2 extends empty
		System.out.println("2 extends empty");

		a = new MyLinkedList();
		b = new MyLinkedList();
		a.add("test1");
		a.add("test2");
		a.extend(b);
		if (a.size() == 2) {
			TesterMethods.passMessage("Size good.");
		} else {
			fail = true;
			TesterMethods.errorMessage("a size", a.size(), 2);
		}
		if (b.size() != 0 && b.toString().equals("[]") && b.toStringReversed().equals("[]")) {
			fail = true;
			TesterMethods.errorMessage("b not cleared properly");
		}
		if (a.toString().equals("[test1, test2]")) {
			TesterMethods.passMessage("Links good forward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going forwards", a.toString(), "[test1, test2]");
		}
		if (a.toStringReversed().equals("[test2, test1]")) {
			TesterMethods.passMessage("Links good backward.");
		} else {
			fail = true;
			TesterMethods.errorMessage("List going backwards", a.toStringReversed(), "[test2, test1]");
		}

		TesterMethods.methodMessage("extend", fail);
		return fail;
	}
}
