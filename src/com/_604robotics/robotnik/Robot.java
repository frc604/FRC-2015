package com._604robotics.robotnik;

import com._604robotics.robotnik.coordinator.CoordinatorList;
import com._604robotics.robotnik.coordinator.ModeMap;
import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.logging.TimeSampler;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.module.ModuleMap;

import edu.wpi.first.wpilibj.SampleRobot;

/**
 * The base of robot code.
 */
public class Robot extends SampleRobot {
    private final IndexedTable table = IndexedTable.getTable("robotnik");
    private final TimeSampler loopTime = new TimeSampler("Loop", 1D);
    
    private ModuleManager modules = new ModuleManager(new ModuleMap(), this.table.getSubTable("modules"));
    private CoordinatorList systems = new CoordinatorList();
    private ModeMap modes = new ModeMap();
    
    private final Safety safety;

    /**
     * Instantiates a new robot (with exception protection enabled by default).
     */
    public Robot () {
        this(Safety.ENABLED);
    }
    
    /**
     * Instantiates a new robot.
     *
     * @param safety Whether or not exception protection is enabled. Only
     *               disable this if you know what you're doing! And don't run
     *               with safety disabled in competition.
     */
    public Robot (Safety safety) {
        printBanner();

        this.safety = safety;

        if (safety.disabled()) {
            Logger.warn("Exception protection has been disabled. Make sure you know what you're doing!");
        }
    }
    
    /**
     * Sets the module map to use.
     *
     * @param moduleMap the module map
     */
    protected void set (ModuleMap moduleMap) {
        this.modules = new ModuleManager(moduleMap, this.table.getSubTable("modules"));
    }
    
    /**
     * Sets the coordinator list to use.
     *
     * @param coordinatorList the coordinator list
     */
    protected void set (CoordinatorList coordinatorList) {
        this.systems = coordinatorList;
    }
    
    /**
     * Sets the mode map to use.
     *
     * @param modeMap the mode map
     */
    protected void set (ModeMap modeMap) {
        this.modes = modeMap;
    }
    
    @Override
    public void robotInit () {
        this.systems.attach(this.modules);
        this.modes.attach(this.modules);
    }
    
    @Override
    public void autonomous () {
        modeLoop(GameMode.AUTONOMOUS);
    }
    
    @Override
    public void operatorControl () {
        modeLoop(GameMode.TELEOP);
    }
    
    @Override
    public void disabled () {
        modeLoop(GameMode.DISABLED);
    }
    
    private void modeLoop (GameMode gameMode) {
        Logger.log(" -- " + gameMode.prettyName() + " mode begin.");

        if (gameMode != GameMode.DISABLED) {
            modules.start(safety);

            loopTime.start();
        }

        while (gameMode.active()) {
            modules.update(safety);
            systems.update();

            if (gameMode != GameMode.DISABLED) {
                modes.update(gameMode);
                modules.execute(safety);

                loopTime.sample();
            }
        }

        if (gameMode != GameMode.DISABLED) {
            loopTime.stop();

            modules.stop(safety);
            modes.stop(gameMode);
        }

        Logger.log(" -- " + gameMode.prettyName() + " mode end.");
    }
    
    private void printBanner () {
        System.out.println(
            "\n\n\n" +
            "                       ..            .`\n" +
            "                   .:oyhho.        .ohhy+:\n" +
            "                 +yhhhhhhhhoossssoohhhhhhhhy/\n" +
            "                 ohhhhhhhhhhhhhhhhhhhhhhhhhh+\n" +
            "      :/.        :hhhhhhhhhhhhhhhhhhhhhhhhhh-        ./-\n" +
            "       yhy+-    /hhhhhhhhhhhhhhhhhhhhhhhhhhhy:    -+yhs\n" +
            "       .hhhhho:shhhhhy/.``./yhhhhy/.``./yhhhhho:ohhhhy`\n" +
            "     `.-shhhhhhhhhhhh`      .hhhh`      .hhhhhhhhhhhho-.`\n" +
            "  /shhhhhhhhhhhhhhhhy       `hhhy       `hhhhhhhhhhhhhhhhys/\n" +
            "   ./yhhhhhhhhhhhhhhhs-    -shhhhs-    -shhhhhhhhhhhhhhhy/`\n" +
            "      :hhhhhhhhhhhhhhhhhyyhhhhhhhhhhyyhhhhhhhhhhhhhhhhh:\n" +
            "     /hhhhhhhhhhhhhhhhyyhyhhhhhhhhhhyhyyhhhhhhhhhhhhhhhy:\n" +
            "   -yhhhyysshhh+  ho`  `ho:hhhhhhhh-sh   `sh  +hhhosyyhhhs-\n" +
            " .  ``      shhy- h+   `ho .shhhhs. sh    oh -hhh+      ``.\n" +
            "            :hhhhoh+   `ho   `ys`   sh    ohohhhh.\n" +
            "             +hhhhhs`  `ho    ys    sh   .shhhhh:\n" +
            "              +hhhhhhs/:ho    ys    sh-/shhhhhh/\n" +
            "               :yhhhhhhhhhs+/:yy:/+shhhhhhhhhy-\n" +
            "                `+hhhhhhhhhhhhhhhhhhhhhhhhhy/\n" +
            "                  `:shhhhhhhhyyyhhhhhhhhho-\n" +
            "                     `:+syhhh:  /hhhyo/-\n" +
            "                          `.-`  `..\n" +
            "\n" +
            "                      _           _         _ _\n" +
            "                     | |         | |       (_) |\n" +
            "            _ __ ___ | |__   ___ | |_ _ __  _| | __\n" +
            "           | '__/ _ \\| '_ \\ / _ \\| __| '_ \\| | |/ /\n" +
            "           | | | (_) | |_) | (_) | |_| | | | |   <\n" +
            "           |_|  \\___/|_.__/ \\___/ \\__|_| |_|_|_|\\_\\\n" +
            "           framework\n" +
            "\n\n"
        );
    }
}
