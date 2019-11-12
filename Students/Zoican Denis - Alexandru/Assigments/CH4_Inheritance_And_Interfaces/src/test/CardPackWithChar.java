package test;

import java.util.Iterator;

public class CardPackWithChar implements Iterator{

	private char[] cards;
	private int it;
	private int nrOfCards;
	public CardPackWithChar(){
		cards = new char[]{'2','3','4','5','6','7','8','9','X','A','J','Q','K'};
		nrOfCards = 13;
	}
	
	@Override
	public boolean hasNext() {
		if(it<nrOfCards)
		return true;
		else
		return false;
	}

	@Override
	public Object next() {
		///For this class I chose to throw a Error
		///I didn't really know what to return. Null or an error
		if(it==nrOfCards) {
			throw new Error("There are no more cards");
		}
		return cards[it++];
	}
	
	public void remove(char a) {
		for(int i=0;i<nrOfCards;i++) {
			if(cards[i]==a) {
				
				if(i==it-1 && it>0) //Change the iterator for the next method
					it--;
				
				for(int j=i+1;j<nrOfCards;j++)
				{
					cards[j-1]=cards[j];
				}
				nrOfCards--;
				break;
			}
		}
	}

	public int getNrOfCards() {
		return nrOfCards;
	}
}
