/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SPXDriveTrainSubsystem extends SubsystemBase {
    private static VictorSPX m_leftFront = new VictorSPX(4);
    private static VictorSPX m_leftRear = new VictorSPX(5);
    private static VictorSPX m_rightFront = new VictorSPX(3);
    private static VictorSPX m_rightRear = new VictorSPX(2);
    /**
     * Creates a new SPXDriveTrainSubsystem.
     */
    public SPXDriveTrainSubsystem() {

    }

    public void arcadeDrive(double turn, double forward) {
        drive(ensureRange(forward + turn, -1d, 1d), ensureRange(forward-turn, -1d, 1d));
    }

    private void drive(double leftSpeed, double rightSpeed) {
        m_leftFront.set(ControlMode.PercentOutput, leftSpeed);
        m_leftRear.set(ControlMode.PercentOutput, leftSpeed);
    
        m_rightFront.set(ControlMode.PercentOutput, rightSpeed);
        m_rightRear.set(ControlMode.PercentOutput, rightSpeed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    private static double ensureRange(double v, double min, double max) {
        return Math.min(Math.max(v, min), max);
    }
}
