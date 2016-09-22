package com.qualcomm.ftcrobotcontroller.opmodes.AZopmodes.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by administrator on 9/10/16.
 */
public class SimpleTankDrive extends OpMode {

    //These classes are each called OpModes. They are all extensions of a super class called OpMode.

    DcMotor leftMotor;
    DcMotor rightMotor;
    int n;

    /**Capitalize each word in name of Class. Do not capitalize first word in object/variable names.
     * Initializing objects of type DcMotor
     * DcMotor is what the robot's motors are called.
     * leftMotor/rightMotor are the names we'll use to refer to each motor in the code. **/

    @Override
    public void init(){

        /**Every OpMode will use the two main methods
         * init() and loop()
         * Variables can be defined, or be given a concrete value.
         * You define DcMotors by assigning the name to an actual motor detected by the robot.**/
        n = 49;
        leftMotor = hardwareMap.dcMotor.get("motorL");
        rightMotor = hardwareMap.dcMotor.get("motorR");

        //Code will search the robot phone for DcMotors titled by the user "motorL" and "motorR"
        //In java, quotations mean that its a String (a string of text)


        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        //Draw diagram on board
        //Explain that one of the motors will need to spin counterclockwise instead of clockwise
    }

    @Override
    public void loop(){

        leftMotor.setPower(-gamepad1.left_stick_y);
        rightMotor.setPower(-gamepad1.right_stick_y);

        //show without minus
        //setPower(); method is one unique to DcMotor objects.

        /**Show how download to phone would happen.
         * 1. Draw out phones relationship to robot.
         * 1. Plug in Phone
         * 2. Hit Play button to download the project to the phone as an application.
         * 3. Demonstrate phone. Select OpMode. This is where method init() happens. It happens once only.
         * 4. Hit Play button. This is where method loop() happens. It loops, continuously updating values.
         */
    }
}
