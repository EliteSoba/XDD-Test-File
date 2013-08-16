package xdd;

import java.awt.*;
import javax.swing.*;

public class Memory extends ArgumentPanel {
	private static final long serialVersionUID = -7799895074220046761L;

	Argument proclock, noproclock, maxprio, nomemlock;
	ButtonGroup proclocks;
	JRadioButton plock, noplock;
	JCheckBox maxpri,nomemlo;
	
	public Memory() {
		this.setVisible(true);
		
		proclock = new Argument("proclock","",false);
		noproclock = new Argument("noproclock","",false);
		maxprio = new Argument("maxpri","",false);
		nomemlock = new Argument("nomemlock","",false);
		
		plock = new JRadioButton("Processor Lock");
		noplock = new JRadioButton("No Processor Lock");
		proclocks = new ButtonGroup();
		proclocks.add(plock);
		proclocks.add(noplock);
		
		setLayout(new GridLayout(2,2));
		
		maxpri = new JCheckBox("Max Priority");
		nomemlo = new JCheckBox("No Memory Lock");
		
		add(plock);
		add(noplock);
		add(maxpri);
		add(nomemlo);
		
	}
	
	public String getArgs() {
		proclock.setEnabled(plock.isSelected());
		noproclock.setEnabled(noplock.isSelected());
		maxprio.setEnabled(maxpri.isSelected());
		nomemlock.setEnabled(nomemlo.isSelected());
		return proclock.toString() + noproclock.toString() + maxprio.toString() + nomemlock.toString();
	}

}
