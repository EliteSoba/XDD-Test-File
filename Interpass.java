package xdd;

import java.awt.*;
import javax.swing.*;

public class Interpass extends ArgumentPanel {
	private static final long serialVersionUID = 2290057436270683750L;

	private class Target {
		Argument argument;
		JCheckBox box;
		public Target(String ID, String arg, String arg2) {
			box = new JCheckBox(ID);
			argument = new Argument(arg,arg2,false);
		}
		public String toString() {
			argument.setEnabled(box.isSelected());
			return argument.toString();
		}
	}
	
	JLabel title;
	Target create, delete, nobarrier, recreate, reopen, verifyloc, verifycont, randomize;
	Argument delay;
	JLabel delabel;
	JTextField delaytext;
	
	public Interpass() {
		setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		title = new JLabel("Between Passes:");
		
		create = new Target("Create New File", "createnewfiles", "");
		delete = new Target("Delete Files", "deletefile", "");
		nobarrier = new Target("Run Passes Asynchronously", "nobarrier", "");
		recreate = new Target("Recreate Files", "recreatefiles", "");
		reopen = new Target("Reopen Files", "reopen", "");
		verifyloc = new Target("Verify File Locations", "verify", "location");
		verifycont = new Target("Verify File Contents", "verify", "contents");
		randomize = new Target("Randomize Between Passes", "randomize", "");
		
		delay = new Argument("delay", "", false);
		delabel = new JLabel("Delay: ");
		delaytext = new JTextField(7);
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		
		add(title, c);
		
		c.gridy = 1;
		add(create.box, c);
		
		c.gridy = 2;
		add(delete.box, c);
		
		c.gridy = 3;
		add(nobarrier.box, c);
		
		c.gridy = 4;
		add(recreate.box, c);
		
		c.gridy = 5;
		add(reopen.box, c);
		
		c.gridy = 6;
		add(verifyloc.box, c);
		
		c.gridy = 7;
		add(verifycont.box, c);
		
		c.gridy = 8;
		add(randomize.box, c);
		
		c.gridwidth = 1;
		c.gridy = 9;
		add(delabel, c);
		c.gridx = 1;
		add(delaytext, c);
		
	}

	public String getArgs() {
		if (delaytext.getText().equals(""))
			delay.disable();
		else {
			delay.enable();
			delay.setArgument(delaytext.getText());
		}
		return create.toString() + delete.toString() + nobarrier.toString() + recreate.toString() + reopen.toString() + verifyloc.toString() + verifycont.toString() + randomize.toString() + delay.toString();
	}

}
