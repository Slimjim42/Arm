package frc.robot.Subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// RADIANS

public class ArmSubsystemCAN extends SubsystemBase {
    AbsoluteEncoder lowEncoder = new AbsoluteEncoder(0);
    AbsoluteEncoder highEncoder = new AbsoluteEncoder(9);

    CANSparkMax bottom_left = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax bottom_right = new CANSparkMax(2, MotorType.kBrushless);
    CANSparkMax top = new CANSparkMax(1, MotorType.kBrushless);

    // CONNECT USING the white, red, and black cable.
    // The WHITE cable is the signal wire.

    public ArmSubsystemCAN()
    {
        bottom_right.setInverted(true);
    }


    // Getters and Setters
    public void setBottom(double speed) {
        bottom_left.set(speed);
        bottom_right.set(speed);
    }
    public void setBottomL(double speed) {
        bottom_left.set(speed);
    }
    public void setBottomR(double speed) {
        bottom_right.set(speed);
    }
    public void stopBottom() {
        bottom_left.stopMotor();
        bottom_right.stopMotor();
    }

    public void setTop(double speed) {
        top.set(speed);
    }
    public void stopTop() {
        top.stopMotor();
    }

    public boolean exist() {
        return true;
    }
    public double getBottomSpeed() {
        return top.get();
    }
    public double getTopRotation() {
        return highEncoder.getRotation();
    }
    public double getBottomRotation() {
        return lowEncoder.getRotation();
    }
}
