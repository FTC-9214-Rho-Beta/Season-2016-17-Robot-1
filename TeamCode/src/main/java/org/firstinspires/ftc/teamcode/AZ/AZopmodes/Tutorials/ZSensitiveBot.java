package org.firstinspires.ftc.teamcode.AZ.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;
import java.util.Locale;

/**
 * Created by az_vasquez on 9/2/16 at 9:45 PM with the purpose of being ready to test sensors.
 *
 * DPAD UP/DOWN to change drive modes (cod def)
 * DPAD L/R	to change telemetry
 * A button for led.
 */
public class ZSensitiveBot extends OpMode {

	ZSampleSwitchBot switchBotObj = new ZSampleSwitchBot();
	boolean codBoolean;
	DcMotor leftMotor, rightMotor;

	UltrasonicSensor usDistanceS;
	OpticalDistanceSensor opDistanceS;
	ColorSensor colorS;
	GyroSensor gyroS;
	IrSeekerSensor irS;
	LightSensor lightS;
	TouchSensor touchS;

	int pageN;

	public void init() {
		usDistanceS = hardwareMap.ultrasonicSensor.get("ultrasonic");
		opDistanceS = hardwareMap.opticalDistanceSensor.get("optical");
		colorS = hardwareMap.colorSensor.get("color");
		gyroS = hardwareMap.gyroSensor.get("gyro");
		irS = hardwareMap.irSeekerSensor.get("ir");
		lightS = hardwareMap.lightSensor.get("light");
		touchS = hardwareMap.touchSensor.get("touch");

		leftMotor = hardwareMap.dcMotor.get("motorL");
		rightMotor = hardwareMap.dcMotor.get("motorR");
		pageN = 0;
		telemetry.addData("4 testing sensors", "");
	}

	public void loop() {
		if (gamepad1.dpad_up){codBoolean = true;}
		if (gamepad1.dpad_down){codBoolean = false;}

		switchBotObj.switchDriveOn(codBoolean);

		if (gamepad1.dpad_right){pageN++;}
		if (gamepad1.dpad_left){pageN--;}

		showData(pageN);
	}

	private void showData(int i) {
		int x = 7;
		telemetry.addData(String.format(Locale.US,"<<	Page %1$d / %2$d", i, x),"	>>");
		if (i % x == 0) {
			telemetry.addData("ULTRASONIC SENSOR", "");
			telemetry.addData("UltraS lvl:	", usDistanceS.getUltrasonicLevel());
			telemetry.addData("","");
			telemetry.addData("OPTICAL DISTANCE SENSOR", "");
			telemetry.addData("OpLight:	", opDistanceS.getLightDetected());
			telemetry.addData("OpLightRaw:	", opDistanceS.getRawLightDetected());
			telemetry.addData("OpLightRawMax:	", opDistanceS.getRawLightDetectedMax());
		} else if (i % x == 1) {
			telemetry.addData("COLOR SENSOR","");
			telemetry.addData("R:	", colorS.red());
			telemetry.addData("G:	", colorS.green());
			telemetry.addData("B:	", colorS.blue());
			telemetry.addData("argb:	", colorS.argb());
			telemetry.addData("alpha:	", colorS.alpha());
			telemetry.addData("I2c:	", colorS.getI2cAddress());
			telemetry.addData("Press 'A' to enable LED.","");
			colorS.enableLed(gamepad1.a);
		} else if (i % x == 2) {
			telemetry.addData("GYRO SENSOR", "");
			telemetry.addData("Heading:	", gyroS.getHeading());
			telemetry.addData("Rot. Fraction:	", gyroS.getRotationFraction());
			telemetry.addData("Heading(?):	", gyroS.getHeading());
			telemetry.addData("rawX:	", gyroS.rawX());
			telemetry.addData("rawY:	", gyroS.rawY());
			telemetry.addData("rawZ:	", gyroS.rawZ());
			telemetry.addData("Status:	", gyroS.status());
			telemetry.addData("calibrating?:	", gyroS.isCalibrating());
			telemetry.addData("Press 'A' to calibrate.","");
			if (gamepad1.a){
				gyroS.calibrate();
			}
		} else if (i % x == 3) {
			telemetry.addData("IR SEEKER SENSOR", "");
			telemetry.addData("Signal?:	", irS.signalDetected());
			telemetry.addData("Signal Threshold:	", irS.getSignalDetectedThreshold());
			telemetry.addData("Strength:	", irS.getStrength());
			telemetry.addData("Θ:	", irS.getAngle());
			telemetry.addData("Mode:	", irS.getMode());
			telemetry.addData("I2c:	", irS.getI2cAddress());
			telemetry.addData("individual sensors:	", irS.getIndividualSensors());
		} else if (i % x == 4) {
			telemetry.addData("LIGHT SENSOR", "");
			telemetry.addData("L det'd:	", lightS.getLightDetected());
			telemetry.addData("L det'd RAW:	", lightS.getRawLightDetected());
			telemetry.addData("L det'd RAW Max:	", lightS.getRawLightDetectedMax());
			telemetry.addData("Status:	", lightS.status());
			telemetry.addData("Press 'A' to enable LED", "");
			lightS.enableLed(gamepad1.a);
		} else if (i % x == 5) {
			telemetry.addData("TOUCH SENSOR", "");
			telemetry.addData("Pressed?:	", touchS.isPressed());
			telemetry.addData("Value:	", touchS.getValue());
		} else if (i % x == 6) {
			telemetry.addData("MOTOR ENCODERS", "");
			telemetry.addData("LMotor:	", leftMotor.getCurrentPosition());
			telemetry.addData("RMotor:	", rightMotor.getCurrentPosition());
			telemetry.addData("Press 'A' to zero the encoders", "");
			if (gamepad1.a){
				leftMotor.setTargetPosition(0);
				rightMotor.setTargetPosition(0);
			}
		}





	}

}
