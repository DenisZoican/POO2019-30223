package test;

public class OldSongs extends Songs{
	
	final public boolean chillVar = true;
	
	public void chill() {
		System.out.println("Chill");
	}
	
	OldSongs(int duration,String genre,String nameOfSong,boolean forParties){
		super(duration,genre,nameOfSong,forParties);
	}
}
