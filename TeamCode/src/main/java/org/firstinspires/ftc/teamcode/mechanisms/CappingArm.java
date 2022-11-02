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
        armServo.setPosition(armServo.getPosition()+.1);

    }
    public void turnInwards() {
        //precise/increments
        armServo.setPosition(armServo.getPosition()+.1);

    }

    public void spinOut() {
        //woo woo like very agrressive
        armServo.setPosition(1);

    }

    public void spinIn() {
        armServo.setPosition(0);
    }

    public void defaultPosition() {
        armServo.setPosition(0.5);

    }

    public double getServoPos() {
        return armServo.getPosition();
    }
}