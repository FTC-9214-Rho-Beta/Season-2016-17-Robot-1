package org.firstinspires.ftc.teamcode.AZ.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.PeerDiscovery;

/**
 * Created by az_vasquez on 9/3/16 at 9:46 PM with the purpose of..
 *
 * 1. finding maximum and minimum positions for all servos
 * 2. noting direction of servo (pos vs neg, cw vs ccw)
 * 3. noting properties of mirrored servos
 * 4. noting positions as angles in degrees (if possible)
 */
public class ZServoBot extends OpMode {

	Servo servo1, servo2;
	double deltaPos = 0.1;
	int servoState = 0;
	double initPos = 0;
	double servo1pos;
	double servo2pos;


	@Override
	public void init() {
		servo1 = hardwareMap.servo.get("servo1");
		servo2 = hardwareMap.servo.get("servo2");
		servo1.setPosition(initPos);
		servo2.setPosition(initPos);
		servo1.setDirection(Servo.Direction.REVERSE);

	}

	@Override
	public void loop() {

		telemetry.addData("SERVO DATA", "");
		telemetry.addData("L/R to change servo, U/D to edit servo","");

		if (gamepad1.dpad_right){
			servoState++;
		} else if (gamepad1.dpad_left){
			servoState--;
		}

		if (servoState % 2 == 0){
			if (gamepad1.dpad_up){
				servo1pos+=deltaPos;
			} else if (gamepad1.dpad_down){
				servo1pos-=deltaPos;
			}
			telemetry.addData("EDITING SERVO:	", "Servo1");
		} else {
			if (gamepad1.dpad_up){
				servo2pos+=deltaPos;
			} else if (gamepad1.dpad_down){
				servo2pos-=deltaPos;
			}
			telemetry.addData("EDITING SERVO:	", "Servo2");
		}
		servo1.setPosition(servo1pos);
		servo2.setPosition(servo2pos);

		telemetry.addData("Servo1 Pos:	", servo1.getPosition());
		telemetry.addData("Servo2 Pos:	", servo2.getPosition());



	}
}
