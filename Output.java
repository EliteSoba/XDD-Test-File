package xdd;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Output extends ArgumentPanel implements ActionListener{
	private static final long serialVersionUID = 138814647999023803L;

	private class Target {
		Argument target;
		JLabel label;
		JTextField text;
		public Target(Argument a, String name) {
			target = a;
			label = new JLabel(name+":  ");
			text = new JTextField(7);
		}
	}
	
	JButton save;
	Target output, id, csv, error;
	
	TestFrame frame;
	
	JFileChooser fc;
	
	public Output(TestFrame frame) {
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.frame = frame;
		
		output = new Target(new Argument("output","",false),"Output");
		id = new Target(new Argument("id","",false),"Name");
		csv = new Target(new Argument("csvout","",false),"CSV Output");
		error= new Target(new Argument("errout","",false),"Error Output");
		save = new JButton("Save");
		save.addActionListener(this);
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(id.label, c);
		c.gridx = 1;
		this.add(id.text, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(output.label, c);
		c.gridx = 1;
		this.add(output.text, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(csv.label, c);
		c.gridx = 1;
		this.add(csv.text, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(error.label, c);
		c.gridx = 1;
		this.add(error.text, c);
		
		c.gridx = 1; c.gridy = 4;
		this.add(save, c);
		
		fc = new JFileChooser();
		
	}
	
	public String getArgs() {

		output.target.setArgument(output.text.getText());
		output.target.enable();
		if (output.text.getText().equals(""))
			output.target.disable();
		
		id.target.setArgument(id.text.getText());
		id.target.enable();
		if (id.text.getText().equals(""))
			id.target.disable();
		
		csv.target.setArgument(csv.text.getText());
		csv.target.enable();
		if (csv.text.getText().equals(""))
			csv.target.disable();
		
		error.target.setArgument(error.text.getText());
		error.target.enable();
		if (error.text.getText().equals(""))
			error.target.disable();
		
		return output.target.toString() + id.target.toString() + csv.target.toString() + error.target.toString();
	}
	
	private String getOutput() {
		String output = frame.duration.getArgs();
		output += frame.targetlist.getArgs();
		output += frame.ratio.getArgs();
		output += frame.misc.getArgs();
		output += frame.moreduration.getArgs();
		output += frame.output.getArgs();
		
		output += frame.memory.getArgs();
		output += frame.datapattern.getArgs();
		output += frame.interpass.getArgs();
		output += frame.offsetc.getArgs();
		output += frame.moreinterpass.getArgs();
		output += frame.moremisc.getArgs();
		
		return output;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(save)) {
			/*System.out.println(getOutput());
			} else{
			/**/
			int option = fc.showSaveDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					FileWriter ot = new FileWriter(file.getAbsoluteFile());
					BufferedWriter out = new BufferedWriter(ot);
					out.write(getOutput());
					out.close();
					ot.close();
				} catch (IOException e1) {
					System.err.println("wat");
				}
			}
		}
	}

}
