package test;

public class Card implements Comparable<Card> {
	private char number;
	private char suit;

	@Override
	public boolean equals(Object o) {
		return (this.number == ((Card) o).number && this.suit == ((Card) o).suit);
	}

	public char getNumber() {
		return number;
	}

	public char getSuit() {
		return suit;
	}

	public void setNumber(char a) {
		this.number = a;
	}

	public void setSuit(char a) {
		this.suit = a;
	}

	public Card(char nr, char st) {
		
		if (((nr < '1' || nr > '9') && new String("XAJQK").indexOf(nr)==-1) || 
		(new String("CHDS").indexOf(st)==-1)) {
			number = 'Z';
			suit = 'Z';
		} else {
			this.number = nr;
			this.suit = st;
		}
	}

	@Override
	public int compareTo(Card o) {

		/*
		 * C < D < H < S
		 */

		if (this.number > o.number) {
			return 1;
		} else if (this.number < o.getNumber()) {
			return -1;
		}
		if (this.suit < o.getSuit()) {
			return -1;
		} else if (this.suit > o.getSuit()) {
			return 1;
		}
		return 0;
	}

}
