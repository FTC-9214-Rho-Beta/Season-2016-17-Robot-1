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

	}
}
