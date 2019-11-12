package test;

import org.junit.Assert;

public class TestCharDeck {
	
	private CardPackWithChar charDeck;
	
	public TestCharDeck(CardPackWithChar a) {
		this.charDeck = a;
	}
	
	public void testRemove() {
		Assert.assertTrue(charDeck.getNrOfCards()==13);///Test if we have al 13 cards in the deck
		charDeck.remove('A'); //Remove card A
		charDeck.remove('6'); //Remove card 6
		charDeck.remove('6'); //Test if we get an error if we remove a card that we removed before
		charDeck.remove('L'); //Test if we get an error if we remove a card that is not valid
		Assert.assertTrue(charDeck.getNrOfCards()==11);///Test if we have 11 cards after we deleted 2 cards
	}
	
	public void testIteration() {
		int nrOfCards = 0;
		while(charDeck.hasNext()) {
			nrOfCards++;
			if(nrOfCards==6)
				{
				charDeck.remove('8');
				}
			char a = (char) charDeck.next(); ///Getting the next card
			Assert.assertFalse(a=='A' || a=='6'); ///Test if we have card A or 6 in our deck
			System.out.print(a+"  "); 
		}
		Assert.assertTrue(nrOfCards==charDeck.getNrOfCards()); ///Test if we accessed all the cards in the deck
	}
	
	
	
}
