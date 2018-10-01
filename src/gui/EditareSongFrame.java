package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import procesare.Song;

@SuppressWarnings("serial")
public class EditareSongFrame extends JFrame {
	private Song song;
	private JTextField txtNume;
	private JTextField txtArtist;
	private JTextField txtRating;
	private JTextField txtGenre;
	private JTextField txtLaunchDate;

	
	public EditareSongFrame(Song temp) {
		super("Editare muzica: "+temp.getSongName());
		song = new Song();
		song.setId(temp.getId());
		song.setSongName(temp.getSongName());
		song.setArtist(temp.getArtist());
		song.setGenre(temp.getGenre());
		song.setLaunchDate(temp.getLaunchDate());
		song.setRating(temp.getRating());
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
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
		
		
		txtNume = new JTextField(song.getSongName());
		txtNume.setBounds(10, 10, 150, 20);
		panel.add(txtNume);
		
		txtArtist = new JTextField(song.getArtist());
		txtArtist.setBounds(110, 40, 150, 20);
		panel.add(txtArtist);

		txtLaunchDate = new JTextField(song.getLaunchDate());
		txtLaunchDate.setBounds(110, 100, 150, 20);
		panel.add(txtLaunchDate);

		txtGenre = new JTextField(""+song.getGenre());
		txtGenre.setBounds(110, 130, 150, 20);
		panel.add(txtGenre);
		
		txtLaunchDate = new JTextField(""+song.getLaunchDate());
		txtGenre.setBounds(110, 160, 150, 20);
		panel.add(txtLaunchDate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//EditareAngajatForm.this.setVisible(false);
				//parent.reloadTable();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				EditareSongFrame.this.setVisible(false);
			}
		});
		btnCancel.setBounds(10, 170, 90, 40);
		panel.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//EditareAngajatForm.this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				//parent.getModel().setValueAt(txtName.getText(), 0, 0);
				//parent.getModel().addTableModelListener();
				//parent.reloadTable();
				EditareSongFrame.this.setVisible(false);
			}
		});
		btnSave.setBounds(110, 170, 90, 40);
		panel.add(btnSave);
	}

	public Song getSong() {
		return song;
	}
}
