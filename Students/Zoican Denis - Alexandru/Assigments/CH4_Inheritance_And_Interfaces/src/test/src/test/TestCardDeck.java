package test.src.test;

import org.junit.Assert;

public class TestCardDeck {
	private CardPackWithCardClass cardPack;

	public TestCardDeck(CardPackWithCardClass a) {
		cardPack = a;
	}

	public void testIteration() {
		Card a = null;
		int i = 0;
		
		
		System.out.println();
		while(cardPack.hasNext())
		{
			a = (Card)cardPack.next();
			Assert.assertTrue(a!=null);
			if(i==1)
			{
				Card ca = new Card('3','C');
				cardPack.putComparable(ca);
			}
			System.out.println("-->"+ (++i) +": "+a.getNumber() +" "+ a.getSuit());
		}
		
		///Checking if i accessed al the cards in the pack
		Assert.assertTrue(i==cardPack.getNumberOfCards());
	}
	public void testInsertAndRemove() {
		Card c1 = new Card('1', 'C');
		Card c2 = new Card('4', 'D');
		Card c3 = new Card('2', 'H');
		Card c4 = new Card('2', 'D');
		Card c6 = new Card('Q', 'D');
		Card c7 = new Card('A', 'D');
		/// Creating some cards
		Card c5 = new Card('L', 'H');

		/// Checking if my deck is empty
		Assert.assertTrue(cardPack.getNumberOfCards() == 0);

		/// Inserting the cards in the deck
		Assert.assertTrue(cardPack.putComparable(c1) == 1);
		Assert.assertTrue(cardPack.putComparable(c2) == 1);
		Assert.assertTrue(cardPack.putComparable(c3) == 1);
		Assert.assertTrue(cardPack.putComparable(c4) == 1);
		Assert.assertTrue(cardPack.putComparable(c6) == 1);
		Assert.assertTrue(cardPack.putComparable(c7) == 1);
		Assert.assertTrue(cardPack.putComparable(c1) == 0); /// Checking if I can insert an card that already exists

		/// Remove a card
		cardPack.remove(c2);

		/// Checking the number of cards
		Assert.assertTrue(cardPack.getNumberOfCards() == 5);
	}

}
