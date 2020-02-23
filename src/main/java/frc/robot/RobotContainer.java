/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

    // private final ExampleCommand m_autoCommand = new
    // ExampleCommand(m_exampleSubsystem);

    // the driver's controller
    private final XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);

    private DriveTrainSubsystem m_drivetrainSubsystem = new DriveTrainSubsystem();
    
    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // this creates a USB camera and starts streaming it to the smart dashboard
        // UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(0);
        // cam1.setResolution(320,240);

        configureButtonBindings();
        configureDriverBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        new JoystickButton(m_driverController, Button.kA.value).whenPressed(() -> {
            System.out.println("BUTTON PUSHED");
            // m_driverController.setRumble(RumbleType.kLeftRumble, 1.0);
        });
    }

    private void configureDriverBindings() {

        // m_drivetrainSubsystem.setDefaultCommand(
        // new RunCommand(() ->

        // m_drivetrainSubsystem.drive(
        // m_driverController.getY(GenericHID.Hand.kLeft),
        // m_driverController.getX(GenericHID.Hand.kRight)), m_drivetrainSubsystem
        // ));
        // new JoystickButton(m_driverController, Button.kBumperRight.value)
        // .whenPressed(() -> { m_drivetrainSubsystem.enableCrawlMode(true);})
        // .whenReleased(() -> { m_drivetrainSubsystem.enableCrawlMode(false);});

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return new RunCommand(() -> {
            double hasTarget = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);

            double hOffset = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);

            if (hasTarget == 1.0) {
                double rotate = 0;

                if (hOffset > 2.8) {
                    rotate = -0.5;
                } else if (hOffset < -2.8) {
                    rotate = 0.5;
                }

                m_drivetrainSubsystem.drive(-0.5, rotate);
            }
        });

        // An ExampleCommand will run in autonomous
        // return m_autoCommand;
    }
}
