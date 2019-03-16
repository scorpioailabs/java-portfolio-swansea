public class Card {
	private int ccnumber;
	public Card(int c) {
		if (c> 100000) {
			ccnumber = c;
		}
	}

}	
public class CCApplication {
	private int appnumber;
	public CCApplication(int c) {
		if (c < 1000) {
			appnumber = c;
		}
	}
}

public class CardApplication {
	public static void main(String[] args) {
	Card c1 = new Card(1);
		c1.ccnumber = 0;
	}	
}
