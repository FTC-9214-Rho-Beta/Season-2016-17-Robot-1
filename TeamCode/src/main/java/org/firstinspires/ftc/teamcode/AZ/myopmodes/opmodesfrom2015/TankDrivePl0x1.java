package org.firstinspires.ftc.teamcode.AZ.myopmodes.opmodesfrom2015;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 104514 on 12/6/2015.
 */
public class TankDrivePl0x1 extends OpMode{
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armMotor;
    DcMotor spoolMotor;
    Servo armServo;
    Servo zipLServo;
    //Servo zipRServo;

    double armposition;
    double armdelta = 0.1;

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


    }

    @Override
    public void loop() {


        double leftdrive = -gamepad1.left_stick_y;
        double rightdrive = -gamepad1.right_stick_y;
        leftMotor.setPower(leftdrive);
        rightMotor.setPower(rightdrive);

        if (gamepad1.y)  {armMotor.setPower(0.1);}
        else if (gamepad1.a) {armMotor.setPower(-0.1);}
        else {armMotor.setPower(0);}

        if (gamepad1.right_bumper) {spoolMotor.setPower(1.0);}
        else if (gamepad1.left_bumper) {spoolMotor.setPower (-1.0);}
        else {spoolMotor.setPower(0);}

        if (gamepad1.b) {armposition += armdelta;}

        if (gamepad1.x) {armposition -= armdelta;}

        if (gamepad1.right_trigger != 0) {zipLServo.setPosition(1.0);}
        else {zipLServo.setPosition(0);}


        armServo.setPosition(armposition);






    }
}
