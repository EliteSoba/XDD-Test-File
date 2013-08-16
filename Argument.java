package xdd;

public class Argument {
	private String name;
	private String argument;
	private boolean enabled;
	
	public Argument(String name, String argument, boolean enabled) {
		this.name = name;
		this.argument = argument;
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public void disable() {
		enabled = false;
	}
	
	public String toString() {
		if (enabled)
			return "-" + name + " " + argument + "\n";
		return "";
	}
	
	
}
