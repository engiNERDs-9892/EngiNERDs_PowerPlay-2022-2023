package org.firstinspires.ftc.teamcode.DriverControl_Code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;


@TeleOp(name="Enginerds_Control", group="Linear Opmode")
//@Disabled

public class Open_HouseCode extends LinearOpMode {

    // The private DcMotor _____; are used to identify a motor that can be used throughout the code

    private DcMotor motorFL = null;
    private DcMotor motorFR = null;
    private DcMotor motorBL = null;
    private DcMotor motorBR = null;

    @Override
    public void runOpMode() {

        // HardwareMap Section (Used to talk to the driver hub for the configuration)

        // Motors

        motorFL = hardwareMap.dcMotor.get("motorFL");
        motorFR = hardwareMap.dcMotor.get("motorFR");
        motorBL = hardwareMap.dcMotor.get("motorBL");
        motorBR = hardwareMap.dcMotor.get("motorBR");


        // Setting the motor Power for Driver Control
        motorFL.setPower(0);
        motorBL.setPower(0);
        motorFR.setPower(0);
        motorBR.setPower(0);


        // Setting the motor Direction, so the motors rotate correctly (Default Direction = Forward)
        motorFL.setDirection(DcMotor.Direction.FORWARD);
        motorFR.setDirection(DcMotor.Direction.REVERSE);
        motorBR.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Variable used for Regular speed (To find the direction that the stick needs to be in)
            double max;

            // The code below talks about the Y-axis (Up and Down / Forward and Backwards)

            double axial = gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value

            // The code below talks about the X-axis (Left and Right)

            double lateral = -gamepad1.left_stick_x; // The bottom two are inverted because motor direction is changed

            // The code below talks about Z-Axis (Spinning around)

            double yaw = -gamepad1.right_stick_x;


            // Combine the joystick requests for each axis-motion to determine each wheel's power
            // And direction for Regular speed
            double leftFrontPower = .6 * (axial + lateral + yaw);
            double rightFrontPower = .6 * (axial - lateral - yaw);
            double leftBackPower = .6 * (axial - lateral + yaw);
            double rightBackPower = .6 * (axial + lateral - yaw);




            ////////////////////////////////////////////////////////////////////////////////////////////
            // use LEFT joystick to go Forward/Backwards & left/Right, and RIGHT joystick to Rotate.///
            //////////////////////////////////////////////////////////////////////////////////////////


            // This calculates the direction & power for Regular Speed
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            // sets the wheels to do whatever the calculation above tells it to do for Regular Speed
            if (max > 1.0) {
                leftFrontPower /= max;
                rightFrontPower /= max;
                leftBackPower /= max;
                rightBackPower /= max;
            }


                motorFL.setPower(leftFrontPower);
                motorBL.setPower(leftBackPower);
                motorFR.setPower(rightFrontPower);
                motorBR.setPower(rightBackPower);


            //////////////////////////////////////////////////////////////
            /////      Servo Code for arms left and right        /////////
            /////////////////////////////////////////////////////////////

            // Close Claws

        }
    }
}

