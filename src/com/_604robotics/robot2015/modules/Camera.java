package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.CameraServer;

public class Camera extends Module {
	private static CameraServer Camera;
	public Camera() {
		Camera.startAutomaticCapture();
	}
}
