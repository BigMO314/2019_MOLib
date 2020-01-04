package frc.molib.humancontrols.buttons;

import edu.wpi.first.wpilibj.GenericHID;

public class BasicButton extends Button {
	protected final GenericHID ctlSource;
	protected final int buttonNumber;

	public BasicButton(GenericHID ctlSource, int buttonNumber) {
		this.ctlSource = ctlSource;
		this.buttonNumber = buttonNumber;
	}

	@Override public boolean get() { return ctlSource.getRawButton(buttonNumber); }
}