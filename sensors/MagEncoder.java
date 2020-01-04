package frc.molib.sensors;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MagEncoder implements PIDSource{
	private PIDSourceType sourceType = PIDSourceType.kDisplacement;
	private final TalonSRX mtrSource;
	private double distancePerPulse;
	
	public MagEncoder(TalonSRX mtrSource) { this.mtrSource = mtrSource; }
	
	public void configDistancePerPulse(double distancePerPulse) { this.distancePerPulse = distancePerPulse; }
	public double getDistance() { return mtrSource.getSelectedSensorPosition(0) * distancePerPulse; }
	public double getRate() { return mtrSource.getSelectedSensorVelocity(0) * distancePerPulse; }
	public void reset() { mtrSource.setSelectedSensorPosition(0, 0, 0); }

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) { this.sourceType = pidSource; }

	@Override
	public PIDSourceType getPIDSourceType() { return sourceType; }

	@Override
	public double pidGet() {
		switch(sourceType) {
		case kDisplacement:
			return getDistance();
		case kRate:
			return getRate();
		default:
			return 0.0;
		}
	}

}
