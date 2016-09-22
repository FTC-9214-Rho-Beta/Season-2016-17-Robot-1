package org.firstinspires.ftc.teamcode.AZ.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.EventLoopManager;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import java.lang.Thread;

/**
 *
 * For robot with 2 motors only. tank Drive
 */

public class ZSampleTankDrive extends OpMode{
	DcMotor leftMotor;
	DcMotor rightMotor;
	int driveState;

	@Override
	public void init() {
		leftMotor = hardwareMap.dcMotor.get("motorL");
		rightMotor = hardwareMap.dcMotor.get("motorR");
		leftMotor.setDirection(DcMotor.Direction.REVERSE);
		driveState = 0;
	}

	@Override
	public void loop() {
		if (gamepad1.a){driveState=1;}
		if (driveState==0){setDriveTank();}

		telemetry.addData("Text", "*** Robot Data***");
		telemetry.addData("LMotor:	", leftMotor.getPower());
		telemetry.addData("RMotor:	", rightMotor.getPower());
		telemetry.addData("LStick-Y	:", gamepad1.left_stick_y);
		telemetry.addData("RStick-Y	:", gamepad2.right_stick_y);

	}

	public void setDriveTank(){
		double leftStick = gamepad1.left_stick_y;
		double rightStick = gamepad1.right_stick_y;
		leftMotor.setPower(-Math.pow(leftStick,2));
		rightMotor.setPower(-Math.pow(rightStick,2));
	}
}
