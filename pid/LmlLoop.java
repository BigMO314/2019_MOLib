package frc.molib.pid;

import frc.molib.vision.Limelight;

public class LmlLoop extends PIDLoop {
	public LmlLoop(Limelight source) { this(0.0, 0.0, 0.0, 0.0, source); }
	public LmlLoop(double pValue, double iValue, double dValue, Limelight source) { this(pValue, iValue, dValue, 0.0, source); }
	public LmlLoop(double pValue, double iValue, double dValue, double fValue, Limelight source) { 
		super(pValue, iValue, dValue, fValue, source);
	}
}
