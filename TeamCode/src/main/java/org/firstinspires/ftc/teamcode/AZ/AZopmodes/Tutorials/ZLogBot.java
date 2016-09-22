package org.firstinspires.ftc.teamcode.AZ.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

import java.util.Locale;

/**
 * Created by administrator on 9/10/16.
 */
public class ZLogBot extends OpMode {


    GyroSensor gyroS;
    int[][] log = new int[5][3];

    @Override
    public void init() {
        gyroS = hardwareMap.gyroSensor.get("gyro");
        telemetry.addData("PLEASE WAIT 30 S FOR GYRO SENSOR TO WARM UP", "");

    }

    @Override
    public void loop() {
        int logX = 0;

        if (gamepad1.a){

            log[logX][0] = gyroS.rawX();
            log[logX][1] = gyroS.rawY();
            log[logX][2] = gyroS.rawZ();

            logX++;
        }

        if (gamepad1.b){
            gyroS.calibrate();
        }



        telemetry.addData("Press A to log current value in form (X, Y, Z)","");
        telemetry.addData("Press B to calibrate sensor","");
        telemetry.addData("Current Value:   ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", gyroS.rawX(), gyroS.rawY(), gyroS.rawZ()));
        telemetry.addData("Log0:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[0][0], log[0][1], log[0][2]));
        telemetry.addData("Log1:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[1][0], log[1][1], log[1][2]));
        telemetry.addData("Log2:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[2][0], log[2][1], log[2][2]));
        telemetry.addData("Log3:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[3][0], log[3][1], log[3][2]));
        telemetry.addData("Log4:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[4][0], log[4][1], log[4][2]));
        if (logX == 5){
            telemetry.addData("5 VALUES LOGGED; FINISHED LOGGING", "");
            stop();
        }

    }

    @Override
    public void stop(){
        telemetry.addData("Log0:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[0][0], log[0][1], log[0][2]));
        telemetry.addData("Log1:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[1][0], log[1][1], log[1][2]));
        telemetry.addData("Log2:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[2][0], log[2][1], log[2][2]));
        telemetry.addData("Log3:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[3][0], log[3][1], log[3][2]));
        telemetry.addData("Log4:    ", String.format(Locale.US, "(%d$1, %d$2,   %d$3)", log[4][0], log[4][1], log[4][2]));
    }
}
