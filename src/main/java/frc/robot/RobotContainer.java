/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.Constants.OIConstants;
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
        UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(0);
        cam1.setResolution(320,240);

    System.out.println("=====> Starting");
    // Configure the button bindings
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
    m_drivetrainSubsystem.setDefaultCommand(
      new RunCommand(() -> 
        m_drivetrainSubsystem.arcadeDrive(
          m_driverController.getY(GenericHID.Hand.kLeft), 
          m_driverController.getX(GenericHID.Hand.kRight)), m_drivetrainSubsystem
      ));
    new JoystickButton(m_driverController, Button.kBumperRight.value)
    .whenPressed(()  -> { m_drivetrainSubsystem.setMaxOutput(0.5);})
    .whenReleased(() -> { m_drivetrainSubsystem.setMaxOutput(1.0);});
    // A split-stick arcade command, with forward/backward controlled by the left  
    // hand, and turning controlled by the right.

    // m_drivetrainSubsystem.setDefaultCommand(

    // new RunCommand(() -> {
    //   DriveCommand cmd = new DriveCommand(m_drivetrainSubsystem);
    //   cmd.setMoveValue(m_driverController.getRawAxis(OIConstants.kMoveAxis));
    //   cmd.setRotateValue(m_driverController.getRawAxis(OIConstants.kRotateAxis));
    //   cmd.execute();
    // }));
    
    // m_drive.arcadeDrive(
    //  driverController.getY(GenericHID.Hand.kLeft),
    //   driverController.getX(GenericHID.Hand.kRight)),
    //   m_robotDrive)

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
  }
}