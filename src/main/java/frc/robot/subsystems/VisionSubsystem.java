/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    /**
     * Creates a new VisionSubsystem.
     */
    public VisionSubsystem() {

    }

    @Override
    public void periodic() {
        // double hasTarget =
        // NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        // double hOffset =
        // NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        // double vOffset =
        // NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);

        // System.out.println("Has Target " + hasTarget + " hOffset " + hOffset + "
        // vOffset " + vOffset);

        // if (hOffset > 0) {
        // System.out.println("MOVE LEFT");
        // } else {
        // System.out.println("MOVE RIGHT");
        // }
        // if (vOffset > 0) {
        // System.out.println("MOVE DOWN");
        // } else {
        // System.out.println("MOVE UP");
        // }

    }
}
