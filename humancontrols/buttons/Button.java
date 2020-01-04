package frc.molib.humancontrols.buttons;

import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.buttons.Trigger.ButtonScheduler;

public abstract class Button extends SendableBase {
	private volatile boolean m_sendablePressed;

	protected boolean lastPressed = grab();
	protected boolean lastReleased = !grab();

	public Button() {
		new ButtonScheduler(){
			@Override public void execute() {
				if(grab() && !lastPressed) lastPressed = true;
				if(!grab() && !lastReleased) lastReleased = true;
			}
		}.start();
	}
	
	public abstract boolean get();
	public boolean getPressed() {
		boolean currentPressed = lastPressed;
		lastPressed = false;
		return currentPressed;
	}
	public boolean getReleased() {
		boolean currentReleased = lastReleased;
		lastReleased = false;
		return currentReleased;
	}

	/**
	 * Returns whether get() return true or the internal table for SmartDashboard use is pressed.
	 *
	 * @return whether get() return true or the internal table for SmartDashboard use is pressed.
	 */
	private boolean grab() {
		return get() || m_sendablePressed;
	}

	@Override
	public void initSendable(SendableBuilder builder) {
		builder.setSmartDashboardType("Button");
		builder.setSafeState(() -> m_sendablePressed = false);
		builder.addBooleanProperty("pressed", this::grab, value -> m_sendablePressed = value);
	}
}