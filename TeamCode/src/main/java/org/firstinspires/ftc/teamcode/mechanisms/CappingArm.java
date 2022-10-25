package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class CappingArm {
    private final Servo armServo;
    protected final Telemetry telemetry;

    public CappingArm(HardwareMap hardwareMap, Telemetry telemetry) {
        armServo = hardwareMap.get(Servo.class, "cappingServo");
        armServo.setDirection(Servo.Direction.FORWARD);
        this.telemetry = telemetry;
        armServo.scaleRange(0, 0.7);
    }

    public void turnOutwards() {

    }
    public void turnInwards() {

    }

    public void spinOut() {

    }

    public void spinIn() {

    }

    public void defaultPosition() {

    }

    public double getServoPos() {
        return armServo.getPosition();
    }

}