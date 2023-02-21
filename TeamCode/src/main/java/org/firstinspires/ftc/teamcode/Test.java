package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="Test", group="Linear Opmode")
//@Disabled
public class Test extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorRiseyRise = null;
    private DcMotor motorSlideySlide = null;

    Servo servoFAL;
    Servo servoFAR;

    int up = 145 ;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        motorRiseyRise  = hardwareMap.get(DcMotor.class, "motorRiseyRise");
        motorSlideySlide = hardwareMap.get(DcMotor.class, "motorSlideySlide");


        motorRiseyRise.setDirection(DcMotor.Direction.REVERSE);
        motorSlideySlide.setDirection(DcMotor.Direction.FORWARD);

        motorRiseyRise.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorSlideySlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();


        motorRiseyRise.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorSlideySlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // High Junction = 58
        // Low Junction = 20
        // 5 cone = 9
        // 4 cone = 7
        // 3 cone = 5

        motorRiseyRise.setTargetPosition(5*up);
        motorSlideySlide.setTargetPosition(5*up);

       motorSlideySlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorRiseyRise.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorSlideySlide.setPower(.8);
        motorRiseyRise.setPower(.8);

        while (motorSlideySlide.isBusy()){}

        motorRiseyRise.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorSlideySlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



        // run until the end of the match (driver presses STOP)

    }
}
