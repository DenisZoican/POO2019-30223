package test;

public class Songs {
	int duration;
	String genre;
	String nameOfSong;
	boolean forParties;
	
	
	Songs(int duration,String genre,String nameOfSong,boolean forParties){
		this.duration = duration;
		this.genre = genre;
		this.nameOfSong = nameOfSong;
		this.forParties = forParties;
	}
	
	public void play() {
		System.out.println("Now playing "+nameOfSong);
	}
	
	public void stop() {
		System.out.println("Stopped "+nameOfSong+ ".\nSilence");
	}
}
