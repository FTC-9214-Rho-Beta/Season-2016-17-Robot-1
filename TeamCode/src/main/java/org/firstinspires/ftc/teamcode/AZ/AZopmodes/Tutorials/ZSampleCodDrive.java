package org.firstinspires.ftc.teamcode.AZ.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 104514 on 12/6/2015.
 * For robot with 2 motors only. COD Drive
 */

public class ZSampleCodDrive extends OpMode{
	DcMotor leftMotor;
	DcMotor rightMotor;
	int driveState;

	@Override
	public void init() {
		leftMotor = hardwareMap.dcMotor.get("motorL");
		rightMotor = hardwareMap.dcMotor.get("motorR");
		leftMotor.setDirection(DcMotor.Direction.REVERSE);
		driveState = 2;
	}

	@Override
	public void loop() {
		if (gamepad1.b){driveState = 2;}

		if (driveState == 2){
			setDriveCod();
		}
		telemetry.addData("Text", "*** Robot Data***");
		telemetry.addData("LMotor:	", leftMotor.getPower());
		telemetry.addData("RMotor:	", rightMotor.getPower());
		telemetry.addData("LStick-Y:	", gamepad1.left_stick_y);
		telemetry.addData("RStick-X:	", gamepad2.right_stick_x);

	}

	public void setDriveCod() {
		double forwardMove = -0.5*Math.pow(gamepad1.left_stick_y,2);
		double turnMove = 0.5*Math.pow(gamepad2.right_stick_x,2);

		leftMotor.setPower(forwardMove - turnMove);
		rightMotor.setPower(forwardMove + turnMove);
	}


}
