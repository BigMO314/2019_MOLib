package frc.molib.lights;

import edu.wpi.first.wpilibj.Solenoid;

public class Toggled {
	private Solenoid sol_Controller;
	
	public Toggled(int channel) { this.sol_Controller = new Solenoid(channel); }
	public void turnOn() { sol_Controller.set(true); }
	public void turnOff() { sol_Controller.set(false); }
	public void toggle() { sol_Controller.set(!sol_Controller.get()); }
}
