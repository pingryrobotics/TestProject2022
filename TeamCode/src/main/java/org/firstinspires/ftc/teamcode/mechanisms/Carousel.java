package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Carousel {
	private DcMotor carouselMotor;
	public double power;

	public Carousel(HardwareMap hardwareMap) {
		carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        carouselMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		power = 0.325; // 1150 rpm
	}

	public void spin() { // spin at speed designated by "power"

	}

	public void spinPower(double power){

	}
	
	public void spinAngle(int angle) { // in radians

	}

	public void reverseSpin() {

	}

	public void stop() {

	}
}

