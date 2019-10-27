package test;

public class RockSongs extends Songs{
	
	public boolean headBangVar;
	
	public void headbang ()
	{
		if(headBangVar==true)
		System.out.println("Headbanging");
		else
		System.out.println("Cannot do this");
	}
	
	RockSongs(int duration,String genre,String nameOfSong,boolean forParties,boolean headBangVar){
		super(duration,genre,nameOfSong,forParties);
		this.headBangVar = headBangVar;
	}
}
