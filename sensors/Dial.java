package frc.molib.sensors;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Dial {
	private AnalogPotentiometer pot_Source;
	private final int maxPosition;
	private final double maxVoltage = 1.0;
	
	public Dial(int channel, int maxPosition) {
		this.pot_Source = new AnalogPotentiometer(channel);
		this.maxPosition = maxPosition;
	}
	
	public int get() {
		double currentVoltage = pot_Source.get();
		for (int position = 1; position <= maxPosition + 1; position++)
			if (currentVoltage <= ((maxVoltage / (double) (maxPosition + 1)) * (double) position))
				return position;
		return -1;
	}
}
