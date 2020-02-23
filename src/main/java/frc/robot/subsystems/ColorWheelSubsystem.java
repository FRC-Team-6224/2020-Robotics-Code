/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import org.ejml.dense.row.misc.DeterminantFromMinor_DDRM;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorWheelSubsystem extends SubsystemBase {
private final I2C.Port m_i2cPort = I2C.Port.kOnboard;
private final ColorSensorV3 m_colorSensor = new ColorSensorV3(m_i2cPort);


  /**
   * Creates a new ExampleSubsystem.
   */
  public ColorWheelSubsystem() {
      

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Color detectedcolor = m_colorSensor.getColor();
    // System.out.println("Color detected" + detectedcolor.red + " " + detectedcolor.green + " " + detectedcolor.blue);
  }
}
