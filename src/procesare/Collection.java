package procesare;
import procesare.Song;
import java.util.List;
import java.util.ArrayList;

public class Collection {
	
	private List<Song> collection;

	public List<Song> getCollection() {
		return collection;
	}

	public void setCollection(List<Song> collection) {
		this.collection = collection;
	}
	
	public void addMusic(Song x) {
		if (collection == null) {
			collection = new ArrayList<Song>();
		}
		collection.add(x);
	}

}
