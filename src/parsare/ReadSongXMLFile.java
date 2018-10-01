package parsare;

import procesare.Song;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import procesare.SongType;


public class ReadSongXMLFile extends DefaultHandler{


	private boolean bSongName;
	private boolean bArtist;
	private boolean blaunchDate;
	private boolean bGenre;
	private boolean brating;
	private boolean bDescription;
	
	
	private Song music;
	private SongType musicType;
	private ArrayList<Song> collection;
	
	public List<Song> getCollection(){
		return collection;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("Cantec")) {
			music = new Song();
			musicType = new SongType();
			if (attributes.getValue("id") != null) {
				music.setId(Integer.parseInt(attributes.getValue("id")));
			}
		} else if (qName.equalsIgnoreCase("name")) {
			bSongName = true;
		} else if (qName.equalsIgnoreCase("genre")) {
			bGenre = true;
		} else if (qName.equalsIgnoreCase("description")) {
			bDescription = true;
		} else if (qName.equalsIgnoreCase("rating")) {
			brating = true;
		}else if (qName.equalsIgnoreCase("artist")) {
			bArtist = true;
		}else if(qName.equalsIgnoreCase("date")) {
			blaunchDate = true;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if(bSongName) {
			music.setSongName(new String(ch, start, length));
		} else if(bGenre) {
			musicType.setGenreName(new String(ch, start, length));
			
			music.setGenre(musicType);
		}else if(bDescription) {
			musicType.setDescription(new String(ch, start, length));
			System.out.println(musicType.getDescription());
			music.setGenre(musicType);
		}else if(brating) {
			music.setRating(Integer.parseInt(new String(ch, start, length)));
		}else if(bArtist) {
			music.setArtist(new String(ch,start,length));
		}else if(blaunchDate) {
			music.setLaunchDate(Integer.parseInt(new String(ch, start, length)));
		}
		
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(qName.equalsIgnoreCase("Cantec")) {
			if(collection == null) {
				collection = new ArrayList<Song>();
			}
			collection.add(music);
			
			 music = null;
		} else if (qName.equalsIgnoreCase("name")) {
			bSongName = false;
		} else if (qName.equalsIgnoreCase("genre")) {
			bGenre = false;
		} else if (qName.equalsIgnoreCase("description")) {
			bDescription = false;
		} else if (qName.equalsIgnoreCase("rating")) {
			brating = false;
		}else if(qName.equalsIgnoreCase("artist")) {
			bArtist = false;
		}else if(qName.equalsIgnoreCase("date")) {
			blaunchDate = false;
		}
	}


}
