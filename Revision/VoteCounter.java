public class VoteCounter {
	private int count;
	private String name;

	public VoteCounter(String id) {
		name = id;
	}

	public  String name() {
		return name;
	}

	public  int counter() {
		return count;
	}

	public void inc() {
		count++;
	}

	//test client

	public static void main(String[] args) {
		VoteCounter votes = new VoteCounter("London");
		votes.counter();
		while (votes.counter() < 1000) {
			votes.inc();
		}
		System.out.println(votes.name() + ":" + votes.counter());
	}
}