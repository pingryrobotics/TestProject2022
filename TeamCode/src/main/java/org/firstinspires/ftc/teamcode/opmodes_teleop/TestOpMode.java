package org.firstinspires.ftc.teamcode.opmodes_teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.mechanisms.Carousel;
import org.firstinspires.ftc.teamcode.mechanisms.DriveControl;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.LinearSlide;


import teamcode.GamepadController;
import teamcode.GamepadController.ButtonState;
import teamcode.GamepadController.ToggleButton;


@TeleOp(name="Drive: Drive Control OpMode", group="Testing")
public class TestOpMode extends OpMode {
    // tag is used in logcat logs (Log.d()) to identify where the log is coming from
    // logcat is basically like System.out.print (standard output) except through adb
    private static final String TAG = "teamcode.drive-opmode"; // put the name of the opmode

    // put any outside classes you need to use here
    private GamepadController movementController;
    private GamepadController mechanismController;
    private DriveControl driveControl;
    private Intake intake;
    private LinearSlide linearSlide;
    private Carousel carousel;
    private double velocity = 0;
    private int direc = 1;
    private int offsetAngle;
    private double servoPos = 1;
    private int direction = 1;
    private int factor = 1;


    // code to run once when driver hits init on phone
    @Override
    public void init() {
        movementController = new GamepadController(gamepad1);
        mechanismController = new GamepadController(gamepad2);
        driveControl = new DriveControl(hardwareMap, telemetry);
        intake = new Intake(hardwareMap);
        linearSlide = new LinearSlide(hardwareMap, telemetry);
        carousel = new Carousel(hardwareMap);
        offsetAngle = 0;

    }

    // code to loop after init is pressed and before start is pressed
    @Override
    public void init_loop() {
    }

    // code to run once when driver hits start
    @Override
    public void start() {
    }

    // code to loop while opmode is running
    @Override
    public void loop() {

        runControls();


        // update telemetry at the end of the loop
        telemetry.update();
    }

    /**
     * Updates buttons and does controls when buttons are pressed
     */
    public void runControls() {


        telemetry.addData("velocity", velocity);

        // button states need to be updated each loop for controls to work
        movementController.updateButtonStates();
        mechanismController.updateButtonStates();

        // polarmove calculations
        double leftStickX = direction * movementController.getButtonState(GamepadController.FloatButton.LEFT_STICK_X);
        double leftStickY = direction * movementController.getButtonState(GamepadController.FloatButton.LEFT_STICK_Y);
        double rightStickX = direction * movementController.getButtonState(GamepadController.FloatButton.RIGHT_STICK_X);
        double rightStickY = direction * movementController.getButtonState(GamepadController.FloatButton.RIGHT_STICK_Y);

//		double theta = Math.atan2(-leftStickY, leftStickX) - Math.PI/4; // go back to subtracting 90?
        double theta = Math.atan2(-leftStickY, leftStickX) - Math.PI/2; // go back to subtracting 90?
        double magnitude = Math.sqrt(Math.pow(leftStickX, 2) + Math.pow(leftStickY, 2)) /factor ;
        double turn = Range.clip(gamepad1.right_stick_x, -1, 1)/factor;

        driveControl.drive(theta, magnitude, turn);

        telemetry.addData("angle", theta);
        telemetry.addData("magnitude", magnitude);
        telemetry.addData("rotation", turn);

        Servo servo = linearSlide.getServo();
        telemetry.addData("serv position", servo.getPosition());
        telemetry.addData("serv direction", servo.getDirection());
        telemetry.addData("servo pwm status", servo.getController());
        telemetry.addData("controller pwm status", servo.getPortNumber());
        telemetry.addData("servo variable position", servoPos);

        // left trigger: intake goes while pressed
        if (movementController.getButtonState(ToggleButton.LEFT_TRIGGER) == ButtonState.KEY_DOWN) {
            intake.intakeIn();
        } else if (movementController.getButtonState(ToggleButton.LEFT_TRIGGER) == ButtonState.KEY_UP) {
            intake.stop();
        }

        if (movementController.getButtonState(ToggleButton.A) == ButtonState.KEY_DOWN) {
            carousel.spin(1);
        } else if (movementController.getButtonState(ToggleButton.A) == ButtonState.KEY_UP) {
            carousel.stop();
        }

    }


    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }


}
