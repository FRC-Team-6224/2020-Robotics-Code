/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrainSubsystem extends SubsystemBase {
    private VictorSP m_left;
    private VictorSP m_right;
    private DifferentialDrive m_drive;

    private boolean m_crawlMode;
    //private DigitalInput m_testSwitch = new DigitalInput(0);

    public DriveTrainSubsystem() {
        m_left = new VictorSP(DriveTrainConstants.kLeftDrive);
        m_right = new VictorSP(DriveTrainConstants.kRightDrive);
        m_drive = new DifferentialDrive(m_left, m_right);
    }

    public void drive(double moveValue, double rotateValue) {
        m_drive.arcadeDrive(moveValue, rotateValue);
    }

    public void enableCrawlMode(boolean enabled) {
        m_crawlMode = enabled;
    }

    public void setMaxOutput(double maxOutput) {
        double m = maxOutput;
        if (m_crawlMode) {
            m = m * 0.5;
        }

        m_drive.setMaxOutput(m);
    }

    @Override
    public void periodic() {

    }
}
