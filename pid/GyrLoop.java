package frc.molib.pid;

import edu.wpi.first.wpilibj.GyroBase;

public class GyrLoop extends PIDLoop {
	private final GyroBase gyrSource;
	
	public GyrLoop(GyroBase source) { this(0.0, 0.0, 0.0, 0.0, source); }
	public GyrLoop(double pValue, double iValue, double dValue, GyroBase source) { this(pValue, iValue, dValue, 0.0, source); }
	public GyrLoop(double pValue, double iValue, double dValue, double fValue, GyroBase source) { 
		super(pValue, iValue, dValue, fValue, source);
		this.gyrSource = source;
	}

	@Override
	public void resetSource() { gyrSource.reset(); }
	
	@Override
	public void calibrateSource() { gyrSource.calibrate(); }
}
