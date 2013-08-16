package xdd;

import javax.swing.*;

public class Misc extends ArgumentPanel {
	private static final long serialVersionUID = 7507053888695147202L;
	
	ButtonGroup verboses;
	JCheckBox diobox;
	JCheckBox rand;
	JRadioButton none, verbose, really;
	Argument dio;
	Argument verb;
	Argument random;

	public Misc() {
		setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		diobox = new JCheckBox("Direct IO (dio)");
		rand = new JCheckBox("Random Seek");
		none = new JRadioButton("Not Verbose");
		none.setSelected(true);
		verbose = new JRadioButton("Verbose");
		really = new JRadioButton("Really Verbose");
		
		dio = new Argument("dio","",false);
		verb = new Argument("","",true);
		random = new Argument("seek","random",false);
		
		verboses = new ButtonGroup();
		verboses.add(none);
		verboses.add(verbose);
		verboses.add(really);
		add(diobox);
		add(rand);
		add(none);
		add(verbose);
		add(really);
	}
	
	public String getArgs() {
		dio.setEnabled(diobox.isSelected());
		random.setEnabled(rand.isSelected());
		verb.setEnabled(!none.isSelected());
		if (verbose.isSelected())
			verb.setName("verbose");
		else
			verb.setName("reallyverbose");
		
		return dio.toString() + verb.toString() + random.toString();
	}

}
