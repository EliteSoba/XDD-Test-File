package xdd;

import javax.swing.*;

import java.awt.*;

public class MoreDuration extends ArgumentPanel{
	private static final long serialVersionUID = 8280739906518327888L;

	private class Target {
		Argument target;
		JLabel label;
		JTextField text;
		public Target(Argument a, String name) {
			target = a;
			label = new JLabel(name);
			text = new JTextField(7);
		}
	}
	
	Target passes, queue;
	
	public MoreDuration() {
		this.setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		passes = new Target(new Argument("passes","1",false), "Passes: ");
		queue = new Target(new Argument("queuedepth","1",false), "Queue Depth: ");
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(passes.label, c);
		c.gridx = 1;
		this.add(passes.text, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(queue.label, c);
		c.gridx = 1;
		this.add(queue.text, c);
		
	}
	
	public String getArgs() {
		passes.target.setArgument(passes.text.getText());
		passes.target.enable();
		if (passes.text.getText().equals(""))
			passes.target.disable();

		queue.target.setArgument(queue.text.getText());
		queue.target.enable();
		if (queue.text.getText().equals(""))
			queue.target.disable();
		
		return passes.target.toString() + queue.target.toString();
	}

}
