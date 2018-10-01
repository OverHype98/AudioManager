package parsare;

import java.io.File;
import procesare.Song;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import procesare.SongType;

public class WriteXMLFile {
	public void createXMLFrom(ArrayList<Song> collection, String outputFile) throws ParserConfigurationException, TransformerException
	{
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element root = doc.createElement("Colectie");
		doc.appendChild(root);
		for (Song melody : collection) {
			Element elem = doc.createElement("Cantec");
			elem.setAttribute("id", Integer.toString(melody.getId()));
			elem.setAttribute("name", melody.getSongName());
			elem.setAttribute("genre", melody.getGenre().getGenreName());
			elem.setAttribute("description", melody.getGenre().getDescription());
			int rating = melody.getRating();
			elem.setAttribute("rating",Float.toString(rating));
			
		
			
	
			root.appendChild(elem);
		}
		
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer t = tFactory.newTransformer();
		Result result = new StreamResult(new File(outputFile));
		Source source = new DOMSource(doc);
		t.transform(source, result);
	}
	
	private Song getSongFrom(ArrayList<Song> collection, int idSong) {
		for(Song melody : collection) {
			if (melody.getId() == idSong) {
				return melody;
			}
		}
		return null;
	}
	
	public static void deleteSong(Song song) {
        String songTitle = song.getSongName();
        String songArtist = song.getArtist();
        String songGenre = song.getGenre().getGenreName();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File("songs.xml");
            Document doc = db.parse(file);

            NodeList songList = doc.getElementsByTagName("cantec");

            if (songList != null && songList.getLength() > 0) {
                for (int i = 0; i < songList.getLength(); i++) {

                    Node node = songList.item(i);
                    Element e = (Element) node;
                    NodeList nodeList = e.getElementsByTagName("name");
                    String title = nodeList.item(0).getChildNodes().item(0)
                            .getNodeValue();
                    nodeList = e.getElementsByTagName("genre");
                    String genre = nodeList.item(0).getChildNodes().item(0)
                            .getNodeValue();
                    nodeList = e.getElementsByTagName("artist");
                    String artist = nodeList.item(0).getChildNodes().item(0)
                            .getNodeValue();
                    
                    System.out.println(title + " Title");
                    System.out.println(songTitle + " SongTitle");

                    if (title.equals(songTitle) && artist.equals(songArtist) && genre.equals(songGenre) ) {

                        node.getParentNode().removeChild(node);
                        
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
	
	
}
