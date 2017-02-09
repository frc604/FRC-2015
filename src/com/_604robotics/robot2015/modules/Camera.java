package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.CameraServer;

public class Camera extends Module {
	public Camera() {
		CameraServer Camera = CameraServer.getInstance();
		Camera.startAutomaticCapture("cam1");
//		this.set(new ElasticController() {{
//			addDefault("Start", new Action () {
//				public void begin(ActionData data) {
//				}
//			});
//		}});
	}
}
