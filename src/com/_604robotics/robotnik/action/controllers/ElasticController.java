package com._604robotics.robotnik.action.controllers;

import com._604robotics.robotnik.action.ActionController;

/**
 * An elastic controller, using the default action when no other action is triggered.
 */
public class ElasticController extends ActionController {
    @Override
    protected String pickAction (String lastAction, String triggeredAction) {
        if (triggeredAction.equals("")) {
            return this.getDefaultAction();
        } else {
            return triggeredAction;
        }
    }
}
