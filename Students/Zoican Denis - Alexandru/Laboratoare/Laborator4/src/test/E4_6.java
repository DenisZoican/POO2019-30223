package test;

public class E4_6 {
	/*
	 Exemplu de player audio
	 */
	public static void main(String[] args) {
		Player p = new Player("Old");
		p.playRandomSong();
		p.stopCurrentSong();
		
		///Question: In clasa Player pot sa am doar un sir Songs unde pot stoca si RockSongs si OldSongs fara sa pierd atributele
		///specifice fiecarei clase (RockSongs si OldSongs)
	}
}
