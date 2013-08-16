package xdd;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DataPattern extends ArgumentPanel implements ActionListener{
	private static final long serialVersionUID = 4039583193984234066L;

	Argument datapattern;
	JLabel title;
	ButtonGroup buttons;
	JRadioButton random, sequenced, ascii, none, repeat;
	JTextField word;
	
	public DataPattern() {
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		datapattern = new Argument("datapattern","",false);
		title = new JLabel("Data Pattern:");
		
		buttons = new ButtonGroup();
		random = new JRadioButton("Random");
		sequenced = new JRadioButton("Sequenced");
		ascii = new JRadioButton("ASCII");
		repeat = new JRadioButton("Repeat");
		none = new JRadioButton("None");
		
		random.addActionListener(this);
		sequenced.addActionListener(this);
		ascii.addActionListener(this);
		repeat.addActionListener(this);
		none.addActionListener(this);
		
		buttons.add(random);
		buttons.add(sequenced);
		buttons.add(ascii);
		buttons.add(none);
		buttons.add(repeat);
		none.setSelected(true);
		
		word = new JTextField(8);
		word.setEditable(false);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		this.add(title, c);
		
		c.gridwidth = 1;
		c.gridy = 1;
		this.add(none, c);
		
		c.gridx = 1;
		this.add(random, c);
		
		c.gridx = 2;
		this.add(sequenced, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(ascii, c);
		
		c.gridx = 1;
		this.add(repeat, c);
		
		c.gridx = 2;
		this.add(word, c);
	}
	
	public String getArgs() {
		datapattern.setEnabled(true);
		if (random.isSelected())
			datapattern.setArgument("random");
		else if (sequenced.isSelected())
			datapattern.setArgument("sequenced");
		else if (ascii.isSelected() && !word.getText().equals(""))
			datapattern.setArgument("ascii " + word.getText());
		else if (repeat.isSelected() && !word.getText().equals(""))
			datapattern.setArgument(word.getText());
		else
			datapattern.setEnabled(false);
		return datapattern.toString();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(ascii) || arg0.getSource().equals(repeat))
			word.setEditable(true);
		else
			word.setEditable(false);
	}

}
