package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;

@TeleOp()
public class MecanumDrive extends OpMode {

    // creates 2 empty objects for motorsj
    DcMotor backLMotor = null;
    DcMotor backRMotor = null;

    DcMotor frontLMotor = null;
    DcMotor frontRMotor = null;
    RevBlinkinLedDriver lighting = null;

    public void init() {
        // passings hardware setups to the motors
        backLMotor = hardwareMap.get(DcMotor.class, "backL");
        backRMotor = hardwareMap.get(DcMotor.class, "backR");

        frontLMotor = hardwareMap.get(DcMotor.class, "frontL");
        frontRMotor = hardwareMap.get(DcMotor.class, "frontR");
        lighting = hardwareMap.get(RevBlinkinLedDriver.class, "lighting");
    }

    public void loop() {
        if (gamepad2.a) {
            lighting.setPattern(RevBlinkinLedDriver.BlinkinPattern.CP2_BREATH_FAST);
        }
        // assign speed modifier
        int speedMod = 2;


        if (gamepad1.right_bumper) {
            speedMod = 1;
        }
        if (gamepad1.left_bumper) {
            speedMod = 3;
        }

        // Mecanum Drive
        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.right_stick_x);
        double robotAngle = Math.atan2(- 1 * gamepad1.right_stick_x, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.left_stick_y;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        frontLMotor.setPower(v1 / speedMod);
        frontRMotor.setPower(v2 / speedMod);
        backLMotor.setPower(v3 / speedMod);
        backRMotor.setPower(v4 / speedMod);

        /*from https://ftcforum.firstinspires.org/forum/
        ftc-technology/android-studio/6361-mecanum-wheels-drive-code-example
         */

    }

}
