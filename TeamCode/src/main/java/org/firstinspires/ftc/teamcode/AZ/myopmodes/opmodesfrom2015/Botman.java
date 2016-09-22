package org.firstinspires.ftc.teamcode.AZ.myopmodes.opmodesfrom2015;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 104514 on 12/6/2015.
 */
public class Botman extends OpMode{
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armMotor;
    DcMotor spoolMotor;
    Servo armServo;
    Servo zipLServo;
    //Servo zipRServo;


    double ARM_STARTING_POSITION = 0.2;
    double CURRENT_ARM_POSITION;
    double DELTA_ARM = 0.1;
    double ARM_MAX_RANGE = 0.9;
    double ARM_MIN_RANGE = 0.1;

    @Override
    public void init() {
        armMotor = hardwareMap.dcMotor.get("motor_arm");
        leftMotor = hardwareMap.dcMotor.get("motor_left");
        rightMotor = hardwareMap.dcMotor.get("motor_right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        spoolMotor = hardwareMap.dcMotor.get("motor_spool");
        armServo = hardwareMap.servo.get("servo_arm");
        zipLServo = hardwareMap.servo.get("servo_zipL");
        //zipRServo = hardwareMap.servo.get("servo_zipR");

        CURRENT_ARM_POSITION = 0.2;


    }

    @Override
    public void loop() {

        /*  TANK DRIVE setup
        double leftdrive = -gamepad1.left_stick_y;
        double rightdrive = -gamepad1.right_stick_y;
        */

        /*  CODDRIVE setup    */
        double GetY = -gamepad1.left_stick_y;
        double GetX = gamepad1.right_stick_x;
        double leftdrive = ((0.5 * GetY) + (0.5 * GetX));
        double rightdrive = ((0.5 * GetY) - (0.5 * GetX));


        leftMotor.setPower(leftdrive);
        rightMotor.setPower(rightdrive);

        if ((gamepad1.y) || (gamepad2.y))  {armMotor.setPower(0.2);}
        else if (gamepad1.a) {armMotor.setPower(-0.2);}
        else {armMotor.setPower(0);}

        if ((gamepad1.right_bumper) || (gamepad2.right_bumper)) {spoolMotor.setPower(1.0);}
        else if ((gamepad1.left_bumper) || (gamepad2.left_bumper)) {spoolMotor.setPower (-1.0);}
        else {spoolMotor.setPower(0);}

        if ((gamepad1.b) || (gamepad2.b)) {CURRENT_ARM_POSITION += DELTA_ARM;}

        if ((gamepad1.x)||(gamepad2.x)) {CURRENT_ARM_POSITION -= DELTA_ARM;}

        if ((gamepad1.left_trigger != 0)||(gamepad2.left_trigger != 0)) {zipLServo.setPosition(1.0);}
        else {zipLServo.setPosition(0);}

        /*
        if ((gamepad1.right_trigger != 0)||(gamepad2.right_trigger != 0)) {zipRServo.setPosition(1.0);}
        else {zipRServo.setPosition(0.0);}
        */

        armServo.setPosition(CURRENT_ARM_POSITION);

        CURRENT_ARM_POSITION = Range.clip(CURRENT_ARM_POSITION, ARM_MIN_RANGE, ARM_MAX_RANGE);

        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("arm", "arm:  " + String.format("%.2f", CURRENT_ARM_POSITION));




    }
}
