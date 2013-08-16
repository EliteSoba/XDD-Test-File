package xdd;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TargetList extends ArgumentPanel implements ActionListener{
	private static final long serialVersionUID = -6313184233327564017L;
	
	private class Target {
		Argument target;
		int ID;
		JLabel label;
		JTextField text;
		JLabel x;
		JTextField repeat;
		public Target(Argument a, int i) {
			target = a;
			ID = i;
			label = new JLabel("dev "+ID);
			text = new JTextField(7);
			x = new JLabel("Repeat ");
			repeat = new JTextField(2);
			repeat.setText("1");
		}
	}
	
	private ArrayList<Target> targets;
	private JButton addTarget;
	GridBagConstraints c;
	
	public TargetList() {
		setVisible(true);
		setPreferredSize(new Dimension(200,200));
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.weighty = 1.0;
		c.weightx = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		targets = new ArrayList<Target>();
		addTarget = new JButton("Add Target");
		addTarget.addActionListener(this);
		c.gridwidth = 2;
		c.gridy = 9;
		add(addTarget,c);
		c.gridy = 0;
		c.gridwidth = 1;
		c.weighty = 0.0;
		c.weightx = 0.0;
		add();
		
	}
	
	private int valueOf(String s) {
		try {
			return Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
			return -1;
		}
	}

	public String getArgs() {
		int count = 0;
		
		for (int i = 0; i < targets.size(); i++) {
			Target curTarget = targets.get(i);
			curTarget.target.setArgument(curTarget.text.getText());
			if (!curTarget.target.getArgument().equals(""))
				if (valueOf(curTarget.repeat.getText()) > 0)
					count += valueOf(curTarget.repeat.getText());
		}
		
		String arg = "-targets " + count;
		for (int i = 0; i < targets.size(); i++) {
			if (!targets.get(i).target.getArgument().equals(""))
				for (int j = 0; j < valueOf(targets.get(i).repeat.getText()); j++)
				arg += " " + targets.get(i).target.getArgument();
		}
		
		return arg+"\n";
	}
	
	private void add() {
		if (c.gridy >= 8)
			return;
		targets.add(new Target(new Argument("targets","",true),c.gridy));
		addTarget();
	}
	
	private void addTarget() {
		c.gridx = 0;
		add(targets.get(c.gridy).label,c);
		c.gridx = 1;
		add(targets.get(c.gridy).text,c);
		c.gridx = 2;
		add(targets.get(c.gridy).x,c);
		c.gridx = 3;
		add(targets.get(c.gridy).repeat,c);
		c.gridy++;
		this.revalidate();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == addTarget) {
			add();
		}
	}

}
