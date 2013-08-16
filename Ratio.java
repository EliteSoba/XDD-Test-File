package xdd;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class Ratio extends ArgumentPanel implements ActionListener, ChangeListener{
	private static final long serialVersionUID = -4843777603043664844L;

	Argument ratio;
	JSlider bar;
	JLabel read, write;
	JLabel current;
	
	public Ratio() {
		setVisible(true);
		setPreferredSize(new Dimension(400,80));
		this.setLayout(new BorderLayout());
		
		ratio = new Argument("rwratio", "0", true);
		bar = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		bar.setMinorTickSpacing(1);
		bar.setMajorTickSpacing(10);
		bar.setPaintLabels(true);
		bar.setPaintTicks(true);
		bar.setPreferredSize(new Dimension(180, 50));
		bar.addChangeListener(this);
		
		read = new JLabel("Read");
		write = new JLabel("Write");
		
		//this.add(write, BorderLayout.LINE_START);
		this.add(bar, BorderLayout.CENTER);
		this.add(read, BorderLayout.LINE_END);
		
		current = new JLabel("Current %: 0%");
		this.add(current, BorderLayout.PAGE_END);
	}
	
	public String getArgs() {
		ratio.setArgument(""+bar.getValue());
		return ratio.toString();
	}

	public void stateChanged(ChangeEvent arg0) {
		this.remove(current);
		current = new JLabel("Current %: " + bar.getValue() + "%");
		this.add(current, BorderLayout.PAGE_END);
		this.revalidate();
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

}
