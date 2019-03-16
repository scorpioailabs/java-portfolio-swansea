public class Card {
	private int ccnumber;
	public Card(int c) {
		ccnumber = c;
	}
	public void setCcnumber(int c) {
		if (c > 100000) {
			ccnumber = c;
		}
	}

}	
class CCApplication {
	private int appnumber;
	public CCApplication(int c) {
		if (c < 1000) {
			appnumber = c;
		}
	}
}

public class CardApplication {
	public static void main(String[] args) {
	Card c1 = new Card(1000000);
	}	
}
