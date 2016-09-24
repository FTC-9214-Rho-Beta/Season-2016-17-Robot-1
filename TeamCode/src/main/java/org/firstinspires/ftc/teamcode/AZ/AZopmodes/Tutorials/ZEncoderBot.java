package org.firstinspires.ftc.teamcode.AZ.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by az_vasquez on 9/5/16 at 3:36 PM with the purpose of...
 */
public class ZEncoderBot extends OpMode {

	DcMotor leftMotor, rightMotor;
	double leftEncoder, rightEncoder;

	@Override
	public void init() {
		leftMotor = hardwareMap.dcMotor.get("motorL");
		rightMotor = hardwareMap.dcMotor.get("motorR");
		leftEncoder = 0;
		rightEncoder = 0;

	}

	@Override
	public void loop() {
		double leftPower = (-0.5*Math.pow(gamepad1.left_stick_y,2))+(0.5*Math.pow(gamepad1.right_stick_x,2));
		double rightPower = (-0.5*Math.pow(gamepad1.left_stick_y,2))-(0.5*Math.pow(gamepad1.right_stick_x,2));
		leftMotor.setPower(leftPower);
		rightMotor.setPower(rightPower);
		if (gamepad1.a){
			resetEncoders();
		}

		leftEncoder = leftMotor.getCurrentPosition();
		rightEncoder = rightMotor.getCurrentPosition();
		telemetry.addData("Press A to reset encoder","");
		telemetry.addData("L Encoder:	", leftEncoder);
		telemetry.addData("R Encoder:	", rightEncoder);
	}


	public void resetEncoders(){
		leftMotor.setTargetPosition(0);
		rightMotor.setTargetPosition(0);
	}
}
