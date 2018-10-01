package procesare;

public class SongType {
	
	private String genreName;
	private String description;
	
	public SongType() {
		
	}
	public SongType(String name, String description) {
		this.genreName = name;
		this.description = description;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

}
