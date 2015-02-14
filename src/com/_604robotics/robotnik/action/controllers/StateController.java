package com._604robotics.robotnik.action.controllers;

import com._604robotics.robotnik.action.ActionController;

// TODO: Auto-generated Javadoc
/**
 * The Class StateController.
 */
public class StateController extends ActionController {
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.action.ActionController#pickAction(java.lang.String, java.lang.String)
     */
    protected String pickAction (String lastAction, String triggeredAction) {
        return triggeredAction.equals("")
                   ? lastAction.equals("")
                       ? this.getDefaultAction()
                       : lastAction
                   : triggeredAction;
    }
}