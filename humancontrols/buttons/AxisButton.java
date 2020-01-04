package frc.molib.humancontrols.buttons;

import edu.wpi.first.wpilibj.GenericHID;

public class AxisButton extends Button {
	protected final GenericHID ctlSource;
	protected final int axisNumber;
	protected double threshold;

	public AxisButton(GenericHID ctlSource, int axisNumber) { this(ctlSource, axisNumber, 0.5); }
	public AxisButton(GenericHID ctlSource, int axisNumber, double threshold) {
		this.ctlSource = ctlSource;
		this.axisNumber = axisNumber;
		this.threshold = threshold;
	}

	public void configThreshold(double threshold) { this.threshold = threshold; }

	@Override public boolean get() { return ctlSource.getRawAxis(axisNumber) > threshold; }
}