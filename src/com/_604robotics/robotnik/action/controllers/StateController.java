package com._604robotics.robotnik.action.controllers;

import com._604robotics.robotnik.action.ActionController;

/**
 * A state controller, returning to the last executed action when no action is currently being triggered.
 */
public class StateController extends ActionController {
    @Override
    protected String pickAction (String lastAction, String triggeredAction) {
        return triggeredAction.equals("")
                   ? lastAction.equals("")
                       ? this.getDefaultAction()
                       : lastAction
                   : triggeredAction;
    }
}