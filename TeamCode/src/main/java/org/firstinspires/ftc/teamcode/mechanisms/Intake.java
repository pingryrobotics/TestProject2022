package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
	private DcMotor intakeMotor;
	public double power;

	public Intake(HardwareMap hardwareMap) {
		intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		power = 1.0;
	}

	public void intakeIn() { // intake

	}
	
	public void intakeOut() { // Reverse Intake

	}
	
	public void stop() {

	}
}