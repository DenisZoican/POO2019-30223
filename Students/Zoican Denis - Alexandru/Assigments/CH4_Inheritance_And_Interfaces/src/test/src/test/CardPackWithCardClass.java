package test.src.test;

import java.util.ArrayList;
import java.util.Arrays;

public class CardPackWithCardClass implements OrderedIterator {
	private Card packOfCards[];
	private int itNext;
	private int numberOfCards;

	public CardPackWithCardClass() {
		packOfCards = new Card[32];
	}
	

	public int getNumberOfCards() {
		return numberOfCards;
	}
	
	@Override
	public boolean hasNext() {
		if (itNext < numberOfCards)
			return true;
		return false;
	}

	@Override
	public Object next() {
		///For this class I chose to return null when we get to end of the deck
		///I didn't really know what to return. Null or an error
		if (itNext < numberOfCards) {
			Card c = packOfCards[itNext];
			itNext++;
			return c;
		} else
			return null;
	}

	public void remove(Card a) {
			for(int i=0;i<numberOfCards;i++) {
				if(packOfCards[i]==a) {
					if(i==itNext-1 && itNext>0) //Change the iterator for the next method
						itNext--;
					
					for(int j=i+1;j<numberOfCards;j++)
					{
						packOfCards[j-1]=packOfCards[j];
					}
					numberOfCards--;
				}
			}
	}
	
	@Override
	public int putComparable(Comparable comparable) {

		char number = ((Card) comparable).getNumber();
		char suit = ((Card) comparable).getSuit();

		///Using this condition to check if the card is valid
		if(number == 'Z')
			{
			return 0;
			}
		
		for (int j = 0; j < numberOfCards; j++)
			if (packOfCards[j].equals(comparable)) {
				return 0;
			}

		///I chose this insertion method because I wanted to use Comparable and Array.sort()
		Card a = null;
		if(itNext>0)
		a = packOfCards[itNext-1];
		packOfCards[numberOfCards++] = (Card) comparable;
		Arrays.sort(packOfCards, 0, numberOfCards);
		if(itNext>0)
		for(int i=0;i<numberOfCards;i++)
			if(packOfCards[i].equals(a)==true) {
				itNext=i+1;
			}
		return 1;
	}
}
