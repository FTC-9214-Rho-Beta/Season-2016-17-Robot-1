package org.firstinspires.ftc.teamcode.AZ.myopmodes.opmodesfrom2015;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by AZ on 12/6/2015.
 */
public class CodDrive2 extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
	double Joey;
	double MalikFeed;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("motor_left");
        rightMotor = hardwareMap.dcMotor.get("motor_right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double GetY = -gamepad1.left_stick_y;
        double GetX = gamepad1.right_stick_x;
        double HalfY = (0.5 * GetY);
        double HalfX = (0.5 * GetX);
        double LeftDrive = (HalfY + HalfX);
        double RightDrive = (HalfY - HalfX);

        leftMotor.setPower(LeftDrive);
        rightMotor.setPower(RightDrive);
		




    }
}
