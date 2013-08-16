package xdd;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Duration extends ArgumentPanel implements ActionListener {
	
	private static final long serialVersionUID = 122237589838385583L;
	private Argument blocksize, reqsize, kbytes, mbytes, numreqs, runtime;
	private ButtonGroup reqsOrBytes;
	private JRadioButton kilobutton, megabutton, numbutton;
	private JTextField kilotext, megatext, numtext, blocktext, reqtext, runtext;
	
	public Duration() {
		setVisible(true);
		setPreferredSize(new Dimension(400,100));
		setLayout(new GridLayout(2,2));
		
		blocksize = new Argument("blocksize", "1024", false);
		reqsize = new Argument("reqsize","128", true);
		kbytes = new Argument("kbytes","0",false);
		mbytes = new Argument("mbytes","32",true);
		numreqs = new Argument("numreqs","0",false);
		runtime = new Argument("runtime","0", false);
		
		reqsOrBytes = new ButtonGroup();
		kilobutton = new JRadioButton("Kilobytes");
		megabutton = new JRadioButton("Megabytes");
		numbutton = new JRadioButton("Num Reqs");
		reqsOrBytes.add(kilobutton);
		reqsOrBytes.add(megabutton);
		reqsOrBytes.add(numbutton);
		
		kilobutton.addActionListener(this);
		megabutton.addActionListener(this);
		numbutton.addActionListener(this);
		
		kilotext = new JTextField(5);
		megatext = new JTextField(5);
		numtext = new JTextField(5);
		
		megabutton.setSelected(true);
		kilotext.setEnabled(false);
		numtext.setEnabled(false);
		megatext.setText("32");
		
		JPanel radios = new JPanel(new GridLayout(3,2));
		radios.add(kilobutton);
		radios.add(kilotext);
		radios.add(megabutton);
		radios.add(megatext);
		radios.add(numbutton);
		radios.add(numtext);
		
		JLabel blocklabel = new JLabel("Block size:  ");
		blocktext = new JTextField(5);
		blocktext.setText("1024");
		JLabel blockend = new JLabel("bytes");
		
		JPanel blocks = new JPanel();
		blocks.setLayout(new GridBagLayout());
		blocks.add(blocklabel);
		blocks.add(blocktext);
		blocks.add(blockend);
		
		JLabel reqlabel = new JLabel("Request size:  ");
		reqtext = new JTextField(5);
		reqtext.setText("128");
		JLabel reqend = new JLabel("blocks");
		
		JPanel reqs = new JPanel();
		reqs.setLayout(new GridBagLayout());
		reqs.add(reqlabel);
		reqs.add(reqtext);
		reqs.add(reqend);
		
		JLabel runlabel = new JLabel("Run time:  ");
		runtext = new JTextField(5);
		runtext.setText("");
		JLabel runend = new JLabel("s");
		
		JPanel runs = new JPanel();
		runs.setLayout(new GridBagLayout());
		runs.add(runlabel);
		runs.add(runtext);
		runs.add(runend);
		
		this.add(blocks);
		this.add(radios);
		this.add(reqs);
		this.add(runs);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == kilobutton) {
			kilotext.setEnabled(true);
			kbytes.enable();
		}
		else {
			kilotext.setEnabled(false);
			kbytes.disable();
		}
		
		if (e.getSource() == megabutton) {
			megatext.setEnabled(true);
			mbytes.enable();
		}
		else {
			megatext.setEnabled(false);
			mbytes.disable();
		}
		
		if (e.getSource() == numbutton) {
			numtext.setEnabled(true);
			numreqs.enable();
		}
		else {
			numtext.setEnabled(false);
			numreqs.disable();
		}
	}

	public String getArgs() {
		if (blocktext.getText().equals(""))
			blocksize.disable();
		else {
			blocksize.enable();
			blocksize.setArgument(blocktext.getText());
		}
		if (reqtext.getText().equals(""))
			reqsize.disable();
		else {
			reqsize.enable();
			reqsize.setArgument(reqtext.getText());
		}
		if (runtext.getText().equals(""))
			runtime.disable();
		else {
			runtime.enable();
			runtime.setArgument(runtext.getText());
		}
		
		kbytes.setArgument(kilotext.getText());
		mbytes.setArgument(megatext.getText());
		numreqs.setArgument(numtext.getText());
		
		return blocksize.toString() + reqsize.toString() + kbytes.toString() + mbytes.toString() + numreqs.toString() + runtime.toString();
	}
}
