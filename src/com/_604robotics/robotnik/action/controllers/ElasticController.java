package com._604robotics.robotnik.action.controllers;

import com._604robotics.robotnik.action.ActionController;

// TODO: Auto-generated Javadoc
/**
 * The Class ElasticController.
 */
public class ElasticController extends ActionController {
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.action.ActionController#pickAction(java.lang.String, java.lang.String)
     */
    protected String pickAction (String lastAction, String triggeredAction) {
        if (triggeredAction.equals("")) {
            return this.getDefaultAction();
        } else {
            return triggeredAction;
        }
    }
}
