package test;
import org.junit.Assert;
import org.junit.Test;

public class TestDecks {
	
	public static void main(String[] args) {
		
		///Testing the deck made with char
		CardPackWithChar charDeck = new CardPackWithChar();
		TestCharDeck t1 = new TestCharDeck(charDeck);
		
		t1.testRemove();
		t1.testIteration();
		
		// If we try to access the next card,we will get an error
		// charDeck.next();
		
		///Testing the deck made with the Card Class
		CardPackWithCardClass cardPack = new CardPackWithCardClass();
		TestCardDeck t2 = new TestCardDeck(cardPack);
		
		t2.testInsertAndRemove();
		t2.testIteration();
		
	}
}
