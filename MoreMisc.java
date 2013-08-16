package xdd;

import javax.swing.*;

import java.awt.*;

public class MoreMisc extends ArgumentPanel {
	private static final long serialVersionUID = 9017872677437448577L;

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
			panel.add(label, c);
			c.gridx++;
			panel.add(field, c);
			c.gridx--;
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
	
	Target combined, report, heartbeat, maxerr;
	
	public MoreMisc() {
		setVisible(true);
		combined = new Target("Combined File","combined");
		report = new Target("Report Threshold","report_threshold");
		heartbeat = new Target("Heartbeat","heartbeat");
		maxerr = new Target("Maximum Error Count","maxerrors");
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		combined.add(this, c);
		heartbeat.add(this, c);
		//c.gridx = 2;
		//c.gridy = 0;
		report.add(this,c);
		maxerr.add(this,c);
	}

	public String getArgs() {
		return combined.toString() + report.toString() + heartbeat.toString() + maxerr.toString();
	}

}
