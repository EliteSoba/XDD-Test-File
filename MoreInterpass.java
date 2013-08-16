package xdd;

import javax.swing.*;
import java.awt.*;

public class MoreInterpass extends ArgumentPanel {
	private static final long serialVersionUID = 5083712262104774052L;

	Argument syncio, syncwrite, deskew;
	JCheckBox desk, syncw;
	JLabel synci, synco;
	JTextField si;
	
	public MoreInterpass() {
		setVisible(true);
		
		syncio = new Argument("syncio","",false);
		syncwrite = new Argument("syncwrite","",false);
		deskew = new Argument("deskew","",false);
		
		desk = new JCheckBox("Deskew");
		syncw = new JCheckBox("Sync Write");
		synci = new JLabel("Sync IO Every ");
		si = new JTextField(7);
		synco = new JLabel(" Passes");
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 1;
		add(desk, c);
		c.gridx = 1;
		add(syncw, c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		add(synci,c);
		c.gridx = 1;
		add(si,c);
		c.gridx = 2;
		add(synco,c);
	}

	public String getArgs() {
		deskew.setEnabled(desk.isSelected());
		syncwrite.setEnabled(syncw.isSelected());
		
		syncio.setArgument(si.getText());
		syncio.setEnabled(!si.getText().equals(""));
		
		return deskew.toString() + syncwrite.toString() + syncio.toString();
	}

}
