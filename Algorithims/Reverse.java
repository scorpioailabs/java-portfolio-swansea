// Reverse a string using Stack 
public class Reverse {
	public static String reverse(String str) {
		//base case: if String is null or empty
		if (str == null || str.equals("")) {
			return str;
		}

		// create an empty stack of characters
		Stack chars = new Stack();

		// push every character of the given string into the stack
		char [] ch = str.toCharArray();
		for (int i = 0; i < str.length(); ++i) {
			chars.push(ch[i]);
		}

		// start from index 0
		int k = 0;

		// pop charcters from the stack until it is empty
		while (!chars.isEmpty()) {
			// assign each popped char back to char array
			ch[k++] = (Character)chars.pop();
		}

		//convert the character array into string and return it
		return String.copyValueOf(ch);
	}

	// test client
	public static void main(String[] args) {
		System.out.println("Reverse me!: ");
		String input = StdIn.readString();
		System.out.println(reverse(input));
	}
}