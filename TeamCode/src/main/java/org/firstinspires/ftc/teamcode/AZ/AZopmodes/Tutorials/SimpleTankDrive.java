package com.qualcomm.ftcrobotcontroller.opmodes.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by administrator on 9/10/16.
 */
public class SimpleTankDrive extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;

    @Override
    public void init(){
        leftMotor = hardwareMap.dcMotor.get("motorL");
        rightMotor = hardwareMap.dcMotor.get("motorR");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop(){
        leftMotor.setPower(-gamepad1.left_stick_y);
        rightMotor.setPower(-gamepad1.right_stick_y);
    }
}
