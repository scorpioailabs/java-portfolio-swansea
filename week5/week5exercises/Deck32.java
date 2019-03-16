public class Deck32{
	public static void main(String[]args){
		String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades"};
		String[] rank = {
			"7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
		};
		int SUITS = suit.length;
		int RANKS = rank.length;
		String[] deck = new String[RANKS * SUITS];
		for (int i = 0; i< RANKS; i++)
			for (int j = 0; j< SUITS; j++)
				deck[SUITS*i +j] = rank[i] + " of " + suit[j];  
		
		int N = deck.length;

		for (int i = 0; i < N; i++) {                //To shuffle deck create another for loop with random function
			int r = i + (int) (Math.random() * (N-i));
			String temp = deck[i];
			deck[i] = deck[r];
			deck[r] = temp;
		}
		for (int i = 0; i < N; i++){
			System.out.println(deck[i]);            //print the deck of shuffled 32 cards
		}
	}
}