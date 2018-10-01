package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import parsare.ReadSongXMLFile;
import parsare.WriteXMLFile;

import procesare.Collection;
import procesare.Song;
import procesare.SongType;

@SuppressWarnings("serial")
public class MainForm extends JFrame {
	private ArrayList<Song> collection;
	
	private JTable tabelMuzica;

	
	  
	public MainForm() {
		super("Manager Audio");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.darkGray);
		
		
		
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int i = fc.showOpenDialog(MainForm.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					String filepath = f.getPath();
					if(!filepath.endsWith("Music.xml")) {
						JOptionPane.showMessageDialog(MainForm.this, "Nu s-a ales fisierul music");
					} else {
						collection = (ArrayList<Song>)MainForm.this.parseXML(0, filepath);
						EditareDataModel model = new EditareDataModel();
						model.setCollection(collection);
						tabelMuzica.setModel(model);
					}
				}

			}
		});
		button.setText("Alege Muzica.xml");
		button.setBounds(10, 10, 150, 20);
		panel.add(button);
		add(panel);
		
	
		
		tabelMuzica = new JTable();
//		tabel.setEditingColumn(5);
		
		JScrollPane sp = new JScrollPane(tabelMuzica);
		sp.setBounds(200, 10,600, 170);
		panel.add(sp);
		

		JButton btnSave = new JButton();
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WriteXMLFile domWriter = new WriteXMLFile();
				try {
					domWriter.createXMLFrom(collection, "Music.xml");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnSave.setText("Save to XML");
		btnSave.setBounds(450, 250, 150, 20);
		panel.add(btnSave);
		
		
		JButton btnRemove = new JButton();
		btnRemove.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	EditareDataModel model = (EditareDataModel) tabelMuzica.getModel();
		    	try {
		    	int i = tabelMuzica.getSelectedRow();
		    	
		    	model.removeRow(i);
		
		    }catch(Exception ex) {
		    	JOptionPane.showMessageDialog(null,"Unable to delete");
		    }
		    }
		});
		btnRemove.setText("Remove from XML");
		btnRemove.setBounds(270, 250, 150, 20);
		panel.add(btnRemove);
		
		
		JButton btnFilter = new JButton();
		btnFilter.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	
		    	JTextField txtGen;
		    	JPanel panel = new JPanel();
		    	panel.setLayout(null);
				panel.setBackground(Color.LIGHT_GRAY); 
				JFrame frame = new JFrame();
				frame.add(panel);
				frame.setVisible(true);
				frame.setSize(500, 300);
		    	
				JLabel lbl = new JLabel("Filtrare gen");
				lbl.setBounds(10, 10, 85, 20);
				panel.add(lbl);
				
				
				txtGen = new JTextField();
				txtGen.setBounds(110, 10, 150, 20);
				panel.add(txtGen);
				
				
				
			
				
				
				
				JButton btnOk = new JButton();
				btnOk.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent arg0) {
				    	
				    	ArrayList<Song> afterFilter = new ArrayList<Song>();
				    	if(txtGen.getText().equals("")) {
				    		
				    		EditareDataModel model = new EditareDataModel();
							model.setCollection(collection);
							tabelMuzica.setModel(model);
				    		
				    	}else {
				    		
				    		for(Song s : collection) {
							if(s.getGenre().getGenreName().equals(txtGen.getText())) {
								
								afterFilter.add(s);
								
							}
				    		
				    	}
				    	
							EditareDataModel model = new EditareDataModel();
						model.setCollection(afterFilter);
						tabelMuzica.setModel(model);
								
						}
				    	
				    	
				    	
				    	
						
						
						
						
						
				    	
				    	
				    }
				    
				});
				btnOk.setText("Filter");
				btnOk.setBounds(50, 100, 150, 20);
				panel.add(btnOk);
				
				
		    	
		    	
		    }
		});
		btnFilter.setText("Filter Music");
		btnFilter.setBounds(400, 400, 150, 150);
		panel.add(btnFilter);
		
		
		
		EditareDataModel model = new EditareDataModel();
		model.setCollection(collection);
		tabelMuzica.setModel(model);  
	  
		JButton addMusic = new JButton();
		addMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JTextField txtNume;
				JTextField txtArtist;
				JTextField txtRating;
				JTextField txtGenre;
				JTextField txtLaunchDate;
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(Color.LIGHT_GRAY); 
				JFrame frame = new JFrame();
				frame.add(panel);
				frame.setVisible(true);
				
			    JLabel lbl = new JLabel("Song Name");
				lbl.setBounds(10, 10, 85, 20);
				panel.add(lbl);
				lbl = new JLabel("Artist");
				lbl.setBounds(10, 40, 85, 20);
				panel.add(lbl);
				lbl = new JLabel("Genre");
				lbl.setBounds(10, 70, 85, 20);
				panel.add(lbl);
				lbl = new JLabel("Launch Date");
				lbl.setBounds(10, 100, 85, 20);
				panel.add(lbl);
				lbl = new JLabel("Rating");
				lbl.setBounds(10, 130, 85, 20);
				panel.add(lbl);
				
				
				txtNume = new JTextField();
				txtNume.setBounds(110, 10, 150, 20);
				panel.add(txtNume);

				txtArtist = new JTextField();
				txtArtist.setBounds(110, 40, 150, 20);
				panel.add(txtArtist);

				txtLaunchDate = new JTextField();
				txtLaunchDate.setBounds(110, 100, 150, 20);
				panel.add(txtLaunchDate);

				txtGenre = new JTextField();
				txtGenre.setBounds(110, 70, 150, 20);
				panel.add(txtGenre);
				
				txtRating = new JTextField();
				txtRating.setBounds(110, 130, 150, 20);
				panel.add(txtRating);
				
				frame.setSize(500, 300);
				

				JButton btnUpdate = new JButton();
				btnUpdate.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent arg0) {
				    	EditareDataModel model = (EditareDataModel) tabelMuzica.getModel();
				    	try {
				    Song newSong = new Song();
				    SongType genre = new SongType();
				    genre.setGenreName(txtGenre.getText());
				    newSong.setSongName(txtNume.getText());
				    newSong.setArtist(txtArtist.getText());
				    newSong.setLaunchDate(Integer.parseInt(txtLaunchDate.getText()));
				    newSong.setGenre(genre);
				    newSong.setRating(Integer.parseInt(txtRating.getText()));
				    collection.add(newSong);
				    
				    EditareDataModel model1 = (EditareDataModel) tabelMuzica.getModel();
				    model1.fireTableDataChanged();
				
				    }catch(Exception ex) {
				    	JOptionPane.showMessageDialog(null,"Unable to delete");
				    }
				    }
				    
				});
				btnUpdate.setText("Update music");
				btnUpdate.setBounds(300, 70, 150, 20);
				panel.add(btnUpdate);
				
				
				
				
				
				
				
			}
		});
		addMusic.setText("Add music");
		addMusic.setBounds(630, 250, 150, 20);
		panel.add(addMusic);
		

		setSize(850, 800);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	
	
	
	

	
	public Object parseXML(int tip, String file)
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			if(tip == 0) {
				ReadSongXMLFile saxReader = new ReadSongXMLFile();
				parser.parse(file, saxReader);
				return saxReader.getCollection();
			} 
			
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 	
	}
}
