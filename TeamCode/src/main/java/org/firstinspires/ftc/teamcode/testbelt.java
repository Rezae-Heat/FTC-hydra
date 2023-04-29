package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp()
public class testbelt extends OpMode {

    // creates 2 empty objects for motorsj
    DcMotor leftMotor = null;
    DcMotor rightMotor = null;





    public void init() {
        // passings hardware setups to the motors

        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        double speedMod=0.5;
    }

    public void loop() {
        if (gamepad2.a) {

        }

        leftMotor.setPower(gamepad1.left_stick_y);
        if (gamepad1.left_stick_y==0) {
            leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        rightMotor.setPower(gamepad1.right_stick_y);
        if (gamepad1.right_stick_y==0){
            rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        // assign speed modifier






        // Mecanum Drive

        /*from https://ftcforum.firstinspires.org/forum/
        ftc-technology/android-studio/6361-mecanum-wheels-drive-code-example
         */

    }

}
