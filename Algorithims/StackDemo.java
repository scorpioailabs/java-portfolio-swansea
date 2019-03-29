// Demonstration of Stack
public class StackDemo {
	public static void main (String [] args) {
		StackInterface [] stacks = new StackInterface[2];
		stacks[0] = new ArrayStack();
		stacks[1] = new LinkedStack();
		
		for (int i = 0; i < 10; i++) {
			stacks[0].push(new Integer(i));
			stacks[1].push(new Integer(i));
		}
		for (int i = 0; i < 10; i++) {
			Object o1 = stacks[0].pop();
			Object o2 = stacks[1].pop();
			System.out.println((Integer)o1+" == "+(Integer)o2);
		}
	}
}
