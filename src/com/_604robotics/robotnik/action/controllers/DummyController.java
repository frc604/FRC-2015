package com._604robotics.robotnik.action.controllers;

import com._604robotics.robotnik.action.ActionController;

/**
 * A dummy controller, running no actions.
 */
public class DummyController extends ActionController {
    @Override
    protected String pickAction (String lastAction, String triggeredAction) {
        return "";
    }
}
