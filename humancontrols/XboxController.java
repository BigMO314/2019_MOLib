package frc.molib.humancontrols;

public class XboxController extends edu.wpi.first.wpilibj.XboxController {
	public static final class ButtonIndex {
		public static final int A = 0,
								B = 1,
								X = 2,
								Y = 3,
								Back = 8,
								Start = 9;
		public static final int Bumper(Hand hand) { return hand == Hand.kLeft ? 4 : 5; }
		public static final int Stick(Hand hand) { return hand == Hand.kLeft ? 6 : 7; }
	}

	public static final class AxisIndex {
		public static final int X(Hand hand) { return hand == Hand.kLeft ? 0 : 2; }
		public static final int Y(Hand hand) { return hand == Hand.kLeft ? 1 : 3; }
		public static final int Trigger(Hand hand) { return hand == Hand.kLeft ? 4 : 5; }
	}

	private double deadzoneThreshold, triggerThreshold;
	
	public XboxController(int port) { this(port, 0.0, 0.5); }
	public XboxController(int port, double deazoneThreshold) { this(port, deazoneThreshold, 0.5); }
	public XboxController(int port, double deadzoneThreshold, double triggerThreshold) {
		super(port);
		this.deadzoneThreshold = deadzoneThreshold;
		this.triggerThreshold = triggerThreshold;
	}
	
	public void configDeadzoneThreshold(double value) { this.deadzoneThreshold = value; }
	public void configTriggerThreshold(double value) { this.triggerThreshold = value; }

	public void setRumble(double value) { setRumble(value, value); }
	public void setRumble(double leftValue, double rightValue) {
		super.setRumble(RumbleType.kLeftRumble, leftValue);
		super.setRumble(RumbleType.kRightRumble, rightValue);
	}
	
	private double deaden(double value) {
		if (Math.abs(value) < deadzoneThreshold)
			return 0.0;
		else if (value < 0.0)
			return (value + deadzoneThreshold) / (1.0 - deadzoneThreshold);
		else
			return (value - deadzoneThreshold) / (1.0 - deadzoneThreshold);
	}
	
	@Override public double getRawAxis(int axis) { return this.deaden(super.getRawAxis(axis)); }
	public boolean getTriggerButton(Hand hand) { return super.getTriggerAxis(hand) > this.triggerThreshold; }
}
