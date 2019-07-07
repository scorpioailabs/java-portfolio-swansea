public class Reverse {
	// Reverse a string using Stack 
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

	// Reverse a string using LinkedList
	public static void reverseList(String str)
	{
		LinkedList list = new LinkedList();
		char [] ch = str.toCharArray();
		for (int i=0;i<ch.length;i++) {
			list.insertAtStart((char)ch[i]);
		}
		list.printList();
	}
	// Reverse a string using split
	public static void reverseAWord(String str)
	{
		String[] revStr = str.split("");
		for (int i=revStr.length-1; i>=0; i--) {
			System.out.print(revStr[i]+"");
		}
	}

	public static void reverseWords(String str)
	{
		String[] revStr = str.split(" ");
		for (int i=revStr.length-1; i>=0; i--) 
		{
			System.out.println(revStr[i]+" ");			
		}
	}

	// test client
	public static void main(String[] args) {
		Reverse rev = new Reverse();
		System.out.println("Reverse me!: ");
		String input = StdIn.readString();
		System.out.println(reverse(input));
		rev.reverseList(input);
		rev.reverseAWord(input);
		System.out.println("");
	}
}