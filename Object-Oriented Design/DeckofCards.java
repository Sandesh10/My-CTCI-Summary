/*
Deck of Cards: 
Design the data structures for a generic deck of cards. Explain how you would
subclass the data structures to implement blackjack.
*/

public enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;
	private Suit(int v){
		value = v;
	}
	public int getValue(int v){
		return value;
	}
	public static Suit getSuitFromValue(int value) {}
}

public class Deck <T extends Card>{
	private ArrayList<T> cards;
	private int dealtIndex = 0; 

	public void setDeckOfCards(ArrayList<T> deckofCards){}

	public void shuffle(){}
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}  
	public T dealCard(){}
	public T[] dealHand(int number){}
}

public abstract class Card {
	private boolean available = true;

	protected int faceValue;
	protected Suit suit;

	public Card(int c, Suit s){
		faceValue = c;
		suit =s;
	}

	public abstract int value();
	public Suit suit() {return suit;}

	// check if the card is available to be given out
	public boolean isAvailable() { return available;}
	public void markUnavailable() { available = false;}
	public void markAvailable() { available = true; }
}

public class Hand <T extends Card> {
	protected ArrayList<T> cards = new ArrayList<T>();

	public int score() {
		int score = 0;
		for (T card : cards){
			score += card.value();
		}
		return score;
	}

	public void addCard(T card){
		cards.add(card);
	}
}

public class BlackJackCard extends Card {
	public BlackJackCard(int c, int s){
		super(c,s);
	}
	public int value() {
		if (isAce()) return 1;
		else if (faceValue >=11 && faceValue <=13) return 10;
		else return faceValue;
	}

	public int minValue(){
		if (isAce()) return 1;
		else return value();
	}

	public int maxValue(){
		if (isAce()) return 11;
		else return value();
	}

	public boolean isFaceCard(){
		return faceValue >=11 && faceValue <=13;
	}
}