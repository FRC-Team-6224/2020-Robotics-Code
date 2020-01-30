/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrainSubsystem extends SubsystemBase {
  private VictorSP m_left;
  private VictorSP m_right;
  private DifferentialDrive m_drive;


  // private double speedFactor

  public DriveTrainSubsystem() {
    m_left = new VictorSP(DriveTrainConstants.kLeftDrive);
    m_right = new VictorSP(DriveTrainConstants.kRightDrive);
    m_drive = new DifferentialDrive(m_left, m_right);
  }

  public void arcadeDrive(double moveValue, double rotateValue) {
    // // dead bands round up and avoid errors
    // if ((moveValue <= 0.2 && moveValue >= -0.2)) {
    //   moveValue = 0;
    // }

    // // setting max speed for robot so it does not go too fast
    // if (moveValue > 0.9) {
    //   moveValue = 0.9;
    // }

    // if (moveValue < -0.9) {
    //   moveValue = -0.9;
    // }
    // // speed limit by half
    
    // moveValue = moveValue / 1.25;
    // rotateValue = rotateValue / 1.25;

    m_drive.arcadeDrive(moveValue, rotateValue);
  }


  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
