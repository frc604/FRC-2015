package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerPOV;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class XboxControllerDpad.
 */
public class XboxControllerDpad {
	
	/** The pad. */
	public final ControllerPOV pad;
	
	/**
	 * Instantiates a new xbox controller dpad.
	 *
	 * @param joystick the joystick
	 */
	public XboxControllerDpad (Joystick joystick){
		this.pad = new ControllerPOV(joystick, 0);
	}
}
