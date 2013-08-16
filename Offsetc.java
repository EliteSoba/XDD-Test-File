package xdd;

import java.awt.*;
import javax.swing.*;

public class Offsetc extends ArgumentPanel {
	private static final long serialVersionUID = 6224191776037679707L;

	private class Target {
		Argument argument;
		JLabel label;
		JTextField field;
		
		public Target(String ID, String arg) {
			label = new JLabel(ID + ": ");
			field = new JTextField(10);
			argument = new Argument(arg, "", false);
		}
		
		public void add(JPanel panel, GridBagConstraints c) {
			c.gridx = 0;
			panel.add(label, c);
			c.gridx = 1;
			panel.add(field, c);
			c.gridy++;
		}
		
		public String toString() {
			if (field.getText().equals(""))
				argument.disable();
			else {
				argument.enable();
				argument.setArgument(field.getText());
			}
			return argument.toString();
		}
	}
	
	Target align, pass, preallocate, limit, target;
	
	public Offsetc() {
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		align = new Target("Align Buffer", "align");
		pass = new Target("Pass Offset", "passoffset");
		preallocate = new Target("Preallocate Blocks", "preallocate");
		limit = new Target("Pass Time Limit", "timelimit");
		target = new Target("Thread Target Offset", "targetoffset");
		
		c.gridy = 0;
		
		align.add(this, c);
		pass.add(this, c);
		preallocate.add(this, c);
		limit.add(this, c);
		target.add(this, c);
		
	}

	public String getArgs() {
		return align.toString() + pass.toString() + preallocate.toString() + limit.toString() + target.toString();
	}

}
