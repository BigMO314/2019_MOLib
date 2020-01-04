package frc.molib.vision;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.molib.DashTable;

public class Limelight implements PIDSource {
	public enum LEDMode {
		kDefault(0),
		kOff(1),
		kBlink(2),
		kOn(3);

		private final int VALUE;
		public static final LEDMode[] VALUES = LEDMode.values();
		private LEDMode(int value) { VALUE = value; }

		public int getValue() { return VALUE; }
	}

	public enum CamMode {
		kVisionProcessor(0),
		kDriverCam(1);
		
		private final int VALUE;
		public static final CamMode[] VALUES = CamMode.values();
		private CamMode(int value) { VALUE = value; }

		public int getValue() { return VALUE; }
	}

	public enum StreamMode {
		kStandard(0),
		kPrimaryPiP(1),
		kSecondaryPiP(2);

		private final int VALUE;
		public static final StreamMode[] VALUES = StreamMode.values();
		private StreamMode(int value){ VALUE = value; }

		public int getValue() { return VALUE; }
	}
	
	public enum PIDAxis { 
		HorizontalAxis, 
		VerticalAxis; 
	}
	
	private static final DashTable TABLE = new DashTable("limelight");
	private static final Limelight INSTANCE = new Limelight();

	public static final DashTable.Entry<Boolean>	dshHasTarget = TABLE.new Entry<Boolean>("tv");
	public static final DashTable.Entry<Double> 	dshPosX = TABLE.new Entry<Double>("tx");
	public static final DashTable.Entry<Double> 	dshPosY = TABLE.new Entry<Double>("ty");
	public static final DashTable.Entry<Integer> 	dshWidth = TABLE.new Entry<Integer>("thor");
	public static final DashTable.Entry<Integer> 	dshHeight = TABLE.new Entry<Integer>("tver");
	public static final DashTable.Entry<Double> 	dshArea = TABLE.new Entry<Double>("ta");
	
	public static final DashTable.Entry<Integer>	dshLEDMode = TABLE.new Entry<Integer>("ledMode");
	public static final DashTable.Entry<Integer>	dshCamMode = TABLE.new Entry<Integer>("camMode");
	public static final DashTable.Entry<Integer>	dshPipeline = TABLE.new Entry<Integer>("pipeline");
	public static final DashTable.Entry<Integer>	dshStreamMode = TABLE.new Entry<Integer>("stream");

	private Limelight() {}

	public static Limelight getDefaultInstance() { return INSTANCE; }

	private static PIDAxis pidAxis = PIDAxis.HorizontalAxis;

	public static boolean hasTarget() { return dshHasTarget.get(); }
	public static double getPosX() { return dshPosX.get(); }
	public static double getPosY() { return dshPosY.get(); }
	public static int getWidth() { return dshWidth.get(); }
	public static int getHeight() { return dshHeight.get(); }
	public static double getArea() { return dshArea.get(); }
	
	public static void setLEDMode(LEDMode mode) { dshLEDMode.set(mode.getValue()); }
	public static void setCamMode(CamMode mode) { dshCamMode.set(mode.getValue()); }
	public static void setPipeline(int pipeline) { dshPipeline.set(pipeline); }
	public static void setStream(StreamMode stream) { dshStreamMode.set(stream.getValue()); }

	public static LEDMode getLEDMode() { return LEDMode.VALUES[dshLEDMode.get()]; }
	public static CamMode getCamMode() { return CamMode.VALUES[dshCamMode.get()]; }
	public static int getPipeline() { return dshPipeline.get(); }
	public static StreamMode getStreamMode() { return StreamMode.VALUES[dshStreamMode.get()]; }

	//Use PIDAxis instead of PIDSourceType
	public static void setPIDAxis(PIDAxis axis) { pidAxis = axis; }
	public static PIDAxis getPIDAxis() { return pidAxis; }
	
	//PIDSourceType not applicable
	@Override public void setPIDSourceType(PIDSourceType pidSource) { }
	@Override public PIDSourceType getPIDSourceType() { return null; }

	@Override
	public double pidGet() {
		switch(pidAxis) {
		case HorizontalAxis:
			return getPosX();
		case VerticalAxis:
			return getPosY();
		default:
			return 0.0;
		}
	}
	
}
