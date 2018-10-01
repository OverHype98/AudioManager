package procesare;

public class Song {
	
	private int id;
	private String songName;
	private String artist;
	private int launchDate;
	private SongType genre;
	private int rating;
	
	
	public Song(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(int launchDate) {
		this.launchDate = launchDate;
	}
	public SongType getGenre() {
		return genre;
	}
	public void setGenre(SongType genre) {
		this.genre = genre;
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}



}
