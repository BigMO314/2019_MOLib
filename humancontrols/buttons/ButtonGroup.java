package frc.molib.humancontrols.buttons;

public class ButtonGroup extends Button {
	private final Button[] buttonList;

	public ButtonGroup(Button[] buttonList) {
		this.buttonList = buttonList;
	}

	@Override public boolean get() {
		boolean returnValue = true;
		for (Button btn : buttonList) returnValue = returnValue && btn.get();
		return returnValue;
	}
}