package gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import procesare.Song;
import procesare.SongType;

@SuppressWarnings("serial")
public class EditareDataModel extends DefaultTableModel {

	private List<Song> collection = null;
	
	
	
	public void setCollection(List<Song> collection) {
		this.collection = collection;
		
	}

	@Override
	public void removeRow(int row) {
		// TODO Auto-generated method stub

		if(collection.size() > row) {
			collection.remove(row);
			super.fireTableDataChanged();
		}
	}

	@Override
	public int getRowCount() {
		if(collection == null) {
			return 0;
		}
		return collection.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex > 4) {
			return "";
		}
		
			switch (columnIndex) {
			case 0:
				return "Song name";
			case 1:
				return "Artist";
			case 2:
				return "Genre";
			case 3:
				return "Launch date";
			case 4:
				return "Rating";
			}
		

		return "";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
			if (columnIndex == 4 || columnIndex == 3) {
				return Integer.class;
			}
		
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}
	
	public void setValueAt(Object value, int row, int col)
	{
		
	    Song song_info = collection.get(row);
	    if (col==0)
	    song_info.setSongName((String)value);
	    else if (col==1)
	    song_info.setArtist((String)value);
	    else if (col==2) {
	    	SongType genre = new SongType();
	    	genre.setGenreName((String)value);
	    	song_info.setGenre(genre);
	    }
	    else if (col==3)
	    	song_info.setLaunchDate((int)value);
	    else if(col==4)
	    	song_info.setRating((int)value);
	    	
	    fireTableCellUpdated(row,col);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		
	
			if(rowIndex >= collection.size() || columnIndex >= 5) {
				return null;
			}
			Song m = collection.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return m.getSongName();
			case 1:

				return m.getArtist();
			case 2:
				return m.getGenre().getGenreName();
			case 3:
				return m.getLaunchDate();
			case 4:
				return m.getRating();
			}
		
		return null;
	}
}
