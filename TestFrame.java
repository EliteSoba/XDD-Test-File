package xdd;

import java.awt.*;

import javax.swing.*;

public class TestFrame extends JFrame {
	private static final long serialVersionUID = 6524796969004811374L;
	
	JTabbedPane main;
	JPanel basic;
	JPanel advanced;
	
	
	Duration duration;
	TargetList targetlist;
	Ratio ratio;
	Misc misc;
	MoreDuration moreduration;
	Output output;
	
	Memory memory;
	DataPattern datapattern;
	Interpass interpass;
	Offsetc offsetc;
	MoreInterpass moreinterpass;
	MoreMisc moremisc;
	
	public TestFrame() {
		super("XDD Test File Generator");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main = new JTabbedPane();
		basic = new JPanel();
		advanced = new JPanel();
		
		duration = new Duration();
		targetlist = new TargetList();
		ratio = new Ratio();
		misc = new Misc();
		moreduration = new MoreDuration();
		output = new Output(this);
		
		memory = new Memory();
		datapattern = new DataPattern();
		interpass = new Interpass();
		offsetc = new Offsetc();
		moreinterpass = new MoreInterpass();
		moremisc = new MoreMisc();
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0; c.gridy = 0;
		basic.setLayout(new GridBagLayout());
		basic.add(duration, c);
		c.gridx = 1;
		basic.add(targetlist, c);
		c.gridx = 0; c.gridy = 1;
		basic.add(ratio, c);
		c.gridy = 2;
		basic.add(misc, c);
		c.gridx = 1; c.gridy = 1;
		basic.add(moreduration, c);
		c.gridx = 1; c.gridy = 2;
		basic.add(output, c);
		
		advanced.setLayout(new GridBagLayout());
		c.ipadx = 10;
		c.gridx = 0; c.gridy = 0;
		advanced.add(memory, c);
		c.gridy = 1;
		advanced.add(datapattern, c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 3;
		advanced.add(interpass, c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		advanced.add(offsetc, c);
		c.gridx = 1;
		c.gridy = 3;
		advanced.add(moreinterpass, c);
		c.gridx = 0;
		c.gridy = 3;
		advanced.add(moremisc, c);
		
		
//		JTabbedPane panels = new JTabbedPane();
//		panels.add(new Duration(), "Duration");
//		panels.add(new TargetList(), "Targets");
//		panels.add(new Ratio(), "W/R Ratio");
//		panels.add(new Misc(), "Miscellaneous");
//		panels.add(new MoreDuration(), "More Duration");
//		this.add(panels);
		setVisible(true);
		
		main.add(basic, "Basic");
		main.add(advanced, "Advanced");
		this.add(main);
		pack();
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TestFrame frame = new TestFrame();
	}

}
