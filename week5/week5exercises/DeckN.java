public class DeckN{
	public static void main(String[]args){
		String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades"};
		String[] rank = {
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
		};
		int SUITS = suit.length;
		int RANKS = rank.length;
		String[] deck = new String[RANKS * SUITS];
		for (int i = 0; i< RANKS; i++)
			for (int j = 0; j< SUITS; j++)
				deck[SUITS*i +j] = rank[i] + " of " + suit[j];  
		
		int N = Integer.parseInt(args[0]);

		for (int i = 0; i < N; i++) {                //To shuffle deck create another for loop with random function
			int r = i + (int) (Math.random() * (N-i));
			String temp = deck[i];
			deck[i] = deck[r];
			deck[r] = temp;
		}
		for (int i = 0; i < N; i++){
			System.out.println(deck[i]);            //print the deck of shuffled 32 or 52 cards
		}
	}
}