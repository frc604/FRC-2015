package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerPOV;
import edu.wpi.first.wpilibj.Joystick;

public class XboxControllerDpad {
	public final ControllerPOV pad;
	
	public XboxControllerDpad (Joystick joystick){
		this.pad = new ControllerPOV(joystick, 0);
	}
}
