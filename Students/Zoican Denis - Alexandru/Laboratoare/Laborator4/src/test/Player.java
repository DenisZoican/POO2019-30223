package test;
public class Player {
	RockSongs songsRock[] = new RockSongs[100];
	OldSongs songsOld[] = new OldSongs[100];
	int currSong = -1;
	String searchedWord = null;
	
	Player(String searchedWord)
	{
		this.searchedWord = searchedWord;
		if(searchedWord.compareTo("Rock")==0)
		{
			songsRock[0] = new RockSongs(4,"Rock","Toxicity",false,true);
			songsRock[1] = new RockSongs(4,"Rock","American Idiot",true,false);
			songsRock[2] = new RockSongs(4,"Rock","Sky is over",false,false);
			songsRock[3] = new RockSongs(4,"Rock","Kryptonite",true,false);
			songsRock[4] = new RockSongs(4,"Rock","21 Guns",false,false);
		} else if(searchedWord.compareTo("Old")==0) {
			songsOld[0] = new OldSongs(4,"Old","The Letter",true);
			songsOld[1] = new OldSongs(4,"Old","Slip Away",true);
			songsOld[2] = new OldSongs(4,"Old","Pelisades Park",true);
			songsOld[3] = new OldSongs(4,"Old","Sh-Boom",true);
			songsOld[4] = new OldSongs(4,"Old","Knock on Wood",true);
		} else {
			System.out.println("No songs");
		}
	}
	
	public void playRandomSong()
	{
		if(searchedWord.compareTo("Rock")==0)
		{
		if(currSong!=-1)
		songsRock[currSong].stop();
		currSong = (int)(Math.random()*10%5);
		songsRock[currSong].play();
		} else if(searchedWord.compareTo("Old")==0)
		{
		if(currSong!=-1)
		songsOld[currSong].stop();
		currSong = (int)(Math.random()*10%5);
		songsOld[currSong].play();
		}
	}
	
	public void stopCurrentSong(){
		if(searchedWord.compareTo("Rock")==0)
		{
		songsRock[currSong].stop();
		} else if(searchedWord.compareTo("Old")==0)
		{
		songsOld[currSong].stop();
		}
	}
}
