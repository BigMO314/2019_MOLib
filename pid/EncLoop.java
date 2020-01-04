package frc.molib.pid;

import edu.wpi.first.wpilibj.Encoder;

public class EncLoop extends PIDLoop {
	private final Encoder encSource;
	
	public EncLoop(Encoder source) { this(0.0, 0.0, 0.0, 0.0, source); }
	public EncLoop(double pValue, double iValue, double dValue, Encoder source) { this(pValue, iValue, dValue, 0.0, source); }
	public EncLoop(double pValue, double iValue, double dValue, double fValue, Encoder source) { 
		super(pValue, iValue, dValue, fValue, source); 
		this.encSource = source;
	}

	@Override
	public void resetSource() { encSource.reset(); }
}
