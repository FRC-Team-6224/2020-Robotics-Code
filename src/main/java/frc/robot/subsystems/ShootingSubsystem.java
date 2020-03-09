/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootingSubsystem extends SubsystemBase {
    private CANSparkMax m_leftMotor;
    private CANSparkMax m_rightMotor;
    /**
     * Creates a new ExampleSubsystem.
     */
    public ShootingSubsystem() {
       m_rightMotor = new CANSparkMax(10, MotorType.kBrushless);
        m_leftMotor = new CANSparkMax(11, MotorType.kBrushless);

    }

    public void shoot(double speed){
       m_rightMotor.set(speed);
         m_leftMotor.set(-speed);
    }


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
