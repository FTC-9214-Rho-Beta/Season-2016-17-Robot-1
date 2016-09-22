package org.firstinspires.ftc.teamcode.AZ.myopmodes.opmodesfrom2015;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 104514 on 12/14/2015.
 */
public class BobRossBot extends OpMode {        //IS THAT SERIOUSLY OUR ROBOT'S FUCKING NAME????
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armMotor;
    Servo clawServo1;
    Servo clawServo2;

    //Find the servo positions from Claw Bot; Do we need 2 settings for 2 kinds of debris?
    final double CLAW_SERVO_1_REST = 0.1;
    final double CLAW_SERVO_2_REST = 0.1;

    final double CLAW_SERVO_1_GRIP = 0.9;
    final double CLAW_SERVO_2_GRIP = 0.9;

    final double ARMSPEED = 0.3;

    double drive;

    enum State {STATE_GRIPPING, STATE_REST, STATE_COD, STATE_TANK, STATE_ARCADE,}
    State CURRENT_CLAW_STATE;
    State DRIVE_STATE;


    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("motor_left");
        rightMotor = hardwareMap.dcMotor.get("motor_right");
        armMotor = hardwareMap.dcMotor.get("motor_arm");
        clawServo1 = hardwareMap.servo.get("servo_claw1");
        clawServo2 = hardwareMap.servo.get("servo_claw2");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        CURRENT_CLAW_STATE = State.STATE_REST;
        DRIVE_STATE = State.STATE_TANK;


    }

    @Override
    public void loop() {

        //telemetry.addData("0", String.format("%4.1f", CURRENT_CLAW_STATE.toString()));

        double leftStickX = gamepad1.left_stick_x;
        double leftStickY = gamepad1.left_stick_y;
        double rightStickX = gamepad1.right_stick_x;
        double rightStickY = gamepad1.right_stick_y;

        // Tank Drive setup
        double leftDrive1 = -gamepad1.left_stick_y;
        double rightDrive1 = -gamepad1.right_stick_y;


        // Arcade Drive setup
        double getY2 = -gamepad1.left_stick_y;
        double getX2 = gamepad1.left_stick_x;
        double halfY2 = (0.5 * getY2);
        double halfX2 = (0.5 * getX2);
        double leftDrive2 = (halfY2 + halfX2);
        double rightDrive2 = (halfY2 - halfX2);


		/* CODDRIVE SETUP */
        double getY3 = -gamepad1.left_stick_y;
        double getX3 = gamepad2.right_stick_x;
        double halfY3 = (0.5 * getY3);
        double halfX3 = (0.5 * getX3);
        double leftDrive3 = (halfY3 + halfX3);
        double rightDrive3 = (halfY3 - halfX3);

		/* Constants ... commentized for testing the driving states
        leftMotor.setPower(leftdrive);
        rightMotor.setPower(rightdrive);
		*/

        //JUST A TEST!! ;)
        switch (DRIVE_STATE) {
            case STATE_TANK:
                leftMotor.setPower(leftDrive1);
                rightMotor.setPower(rightDrive1);
                drive = 1;
                if (gamepad1.y) {DRIVE_STATE = State.STATE_COD;}
                break;

            case STATE_COD:
                leftMotor.setPower(leftDrive3);
                rightMotor.setPower(rightDrive3);
                drive = 2;
                if (gamepad1.y) {DRIVE_STATE = State.STATE_COD;}
                break;

            case STATE_ARCADE:
                leftMotor.setPower(leftDrive2);
                rightMotor.setPower(rightDrive2);
                drive = 3;
                if (gamepad1.y) {DRIVE_STATE = State.STATE_TANK;}
                break;
        }

        switch (CURRENT_CLAW_STATE) {
            case STATE_REST:
                clawServo1.setPosition(CLAW_SERVO_1_REST);
                clawServo2.setPosition(CLAW_SERVO_2_REST);
                if (gamepad1.a) {CURRENT_CLAW_STATE = State.STATE_GRIPPING;}
                break;

            case STATE_GRIPPING:
                clawServo1.setPosition(CLAW_SERVO_1_GRIP);
                clawServo2.setPosition(CLAW_SERVO_2_GRIP);
                if (gamepad1.a) {CURRENT_CLAW_STATE = State.STATE_REST;}
                break;
        }

        if (gamepad1.left_bumper) {armMotor.setPower(ARMSPEED);}
        else if (gamepad1.right_bumper) {armMotor.setPower(-ARMSPEED);}
        else {armMotor.setPower(0);}
        //MIGHT NEED TO REVERSE DIRECTIONS!!

        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("Drive", "drive:  " + String.format("%s", CURRENT_CLAW_STATE));
        telemetry.addData("Drive#", "drive: " + String.format("%d", drive));
        telemetry.addData("Left stick", "x: " + String.format("%d", leftStickX));
        telemetry.addData("Left stick", "y: " + String.format("%d", leftStickY));
        telemetry.addData("Right stick", "x: " + String.format("%d", rightStickX));
        telemetry.addData("Right stick", "y: " + String.format("%d", rightStickY));
        /*  telemetry.addData("claw", "claw:  " + String.format("%.2f", clawPosition));
        *   telemetry.addData("left tgt pwr",  "left  pwr: " + String.format("%.2f", left));
        *   telemetry.addData("right tgt pwr", "right pwr: " + String.format("%.2f", right));
        */
    }

}
	/* As it is right now,
	2 joysticks are for driving,
	A button is for Gripping and un-gripping,
	Bumpers control arm motor,
	Y button switches drives */

