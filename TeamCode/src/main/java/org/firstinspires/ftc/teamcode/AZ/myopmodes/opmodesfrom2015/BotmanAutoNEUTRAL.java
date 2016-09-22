package org.firstinspires.ftc.teamcode.AZ.myopmodes.opmodesfrom2015;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by AZ on 12/7/2015.
 */
public class BotmanAutoNEUTRAL extends LinearOpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo   armServo;

    //will need to test this (using 0.5 powers) and replace (0.0) with degrees/second
    //TURN_TIME_COEFFICIENT = (0.0)

    //0.88 m/s forward velocity

    //move forward times
    int MOVE_1 = 1385;
    int MOVE_2 = 1469;
    int MOVE_3 = 693;
    int MOVE_4 = 2078;
    int MOVE_5 = 3000;

    int TURN_1 = 0; //45degrees left
    int TURN_2 = 0; //45degrees left
    int TURN_3 = 0; //180degrees left or right
    int TURN_4 = 0; //45degrees left

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("motor_left");
        rightMotor = hardwareMap.dcMotor.get("motor_right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        armServo = hardwareMap.servo.get("servo_arm");

        waitForStart();
        //STEP 1
        leftMotor.setPower(1);
        rightMotor.setPower(1);
        sleep(MOVE_1);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);

        //step 2
        leftMotor.setPower(-0.5);
        rightMotor.setPower(0.5);
        sleep(TURN_1);
        sleep(500);
        leftMotor.setPower(1);
        rightMotor.setPower(1);
        sleep(MOVE_2);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);

        //step 3
        leftMotor.setPower(-0.5);
        rightMotor.setPower(0.5);
        sleep(TURN_2);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);
        leftMotor.setPower(1);
        rightMotor.setPower(1);
        sleep(MOVE_3);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);
        //INSERT HERE DROPPING CLIMBERS//

        //step4
        leftMotor.setPower(-1);
        rightMotor.setPower(-1);
        sleep(MOVE_3);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);

        leftMotor.setPower(0.5);
        rightMotor.setPower(-0.5);
        sleep(TURN_3);

        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);


        leftMotor.setPower(1);
        rightMotor.setPower(1);
        sleep(MOVE_4);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);

        //step 5
        leftMotor.setPower(-0.5);
        rightMotor.setPower(0.5);
        sleep(TURN_4);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);

        leftMotor.setPower(1);
        rightMotor.setPower(1);
        sleep(MOVE_5);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(500);


    }
}
