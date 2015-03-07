package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerPOV;
import com._604robotics.robotnik.prefabs.controller.ControllerPOVButton;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class XboxControllerDpad.
 */
public class XboxControllerDpad {
	
	/** The pad. */
	public final ControllerPOV PAD;
	public final ControllerPOVButton UP;
	public final ControllerPOVButton DOWN;
	public final ControllerPOVButton LEFT;
	public final ControllerPOVButton RIGHT;
	public final ControllerPOVButton PRESSED;
	
	public class XboxControllerDpadImprecise{
		public final ControllerPOVButton UP;
		public final ControllerPOVButton DOWN;
		public final ControllerPOVButton LEFT;
		public final ControllerPOVButton RIGHT;
		public XboxControllerDpadImprecise(ControllerPOVButton up, ControllerPOVButton down,
				ControllerPOVButton left, ControllerPOVButton right){
			this.UP = up;
			this.DOWN = down;
			this.LEFT = left;
			this.RIGHT= right;
		}
	}
	public final XboxControllerDpadImprecise imprecise;
	
	/**
	 * Instantiates a new xbox controller dpad.
	 *
	 * @param joystick the joystick
	 */
	public XboxControllerDpad (Joystick joystick){
		this.PAD = new ControllerPOV(joystick, 0);
		this.UP = new ControllerPOVButton(joystick, 0, 0);
		this.DOWN = new ControllerPOVButton(joystick, 0, 180);
		this.LEFT = new ControllerPOVButton(joystick, 0, 270);
		this.RIGHT = new ControllerPOVButton(joystick, 0, 90);
		this.PRESSED = new ControllerPOVButton(joystick, 0, 0, 360);
		this.imprecise = new XboxControllerDpadImprecise(
			new ControllerPOVButton(joystick, 0, 315, 45),
			new ControllerPOVButton(joystick, 0, 135, 225),
			new ControllerPOVButton(joystick, 0, 45, 135),
			new ControllerPOVButton(joystick, 0, 225, 315)
		);
	}
}
