package frc.molib.pid;

import com.kauailabs.navx.frc.AHRS;

public class IMULoop extends PIDLoop {
	private final AHRS imuSource;

	public IMULoop(AHRS imuSource) { this(0.0, 0.0, 0.0, 0.0, imuSource); }
	public IMULoop(double pValue, double iValue, double dValue, AHRS imuSource) { this(pValue, iValue, dValue, 0.0, imuSource); }
	public IMULoop(double pValue, double iValue, double dValue, double fValue, AHRS imuSource) { 
		super(pValue, iValue, dValue, fValue, imuSource);
		this.imuSource = imuSource;
	}

	@Override
	public void resetSource() { imuSource.reset(); }
}