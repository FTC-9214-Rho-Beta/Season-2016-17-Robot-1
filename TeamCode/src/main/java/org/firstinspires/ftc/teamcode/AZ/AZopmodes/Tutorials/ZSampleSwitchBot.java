package org.firstinspires.ftc.teamcode.AZ.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.Locale;

/**
 * Created by az_vasquez on 9/2/16 at 7:04 PM with the purpose of...
 */
public class ZSampleSwitchBot extends OpMode {

	private boolean codDrive;
	DcMotor leftMotor, rightMotor;
	ZSampleTankDrive tankObj = new ZSampleTankDrive();
	ZSampleCodDrive codObj = new ZSampleCodDrive();
	String driveMode;

	@Override
	public void init() {
		leftMotor = hardwareMap.dcMotor.get("motorL");
		rightMotor = hardwareMap.dcMotor.get("motorR");
		leftMotor.setDirection(DcMotor.Direction.REVERSE);

	}

	@Override
	public void loop(){
		if (gamepad1.dpad_up){codDrive=true;}
		if (gamepad1.dpad_down){codDrive=false;}
		switchDriveOn(codDrive);
		if (codDrive) {
			driveMode = "COD Drive";
		} else {
			driveMode = "Tank Drive";
		}

		telemetry.addData("Text", "	DPAD up/down to change mode");
		telemetry.addData("LStick:	", String.format(Locale.US, "%f$1,	%f$2", gamepad1.left_stick_x, gamepad1.left_stick_y));
		telemetry.addData("RStick:	", String.format(Locale.US, "%f$1,	%f$2", gamepad1.right_stick_x, gamepad1.right_stick_y));
		telemetry.addData("Drive Mode	:", driveMode);
	}

	public void switchDriveOn(boolean a) {
		if (a) {
			codObj.setDriveCod();
		} else {
			tankObj.setDriveTank();
		}

	}
}