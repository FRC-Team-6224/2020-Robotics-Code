/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Drive command to move robot. NOT USED CURRENTLY
 */
public class DriveCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DriveTrainSubsystem m_driveTrainSubsystem;

    private double m_moveValue;
    private double m_rotateValue;

    /**
     * Creates a new DriveCommand.
     *
     * @param driveTrainSubsystem The DriveTrain subsystem used by this command.
     */
    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem) {
        m_driveTrainSubsystem = driveTrainSubsystem;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(driveTrainSubsystem);
    }


    public void setMoveValue(double moveValue) {
        m_moveValue = moveValue;
    }

    public double getMoveValue() {
        return m_moveValue;
    }

    public void setRotateValue(double rotateValue) {
        m_rotateValue = rotateValue;
    }

    public double getRotateValue() {
        return m_rotateValue;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // send Values to the drivetrain
        m_driveTrainSubsystem.arcadeDrive(m_moveValue, m_rotateValue);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
