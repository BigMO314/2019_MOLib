package frc.molib.pid;

import frc.molib.sensors.MagEncoder;

public class MagLoop extends PIDLoop {
	private final MagEncoder encSource;
	
	public MagLoop(MagEncoder source) { this(0.0, 0.0, 0.0, 0.0, source); }
	public MagLoop(double pValue, double iValue, double dValue, MagEncoder source) { this(pValue, iValue, dValue, 0.0, source); }
	public MagLoop(double pValue, double iValue, double dValue, double fValue, MagEncoder source) { 
		super(pValue, iValue, dValue, fValue, source);
		this.encSource = source;
	}

	@Override
	public void resetSource() { encSource.reset(); }
}
