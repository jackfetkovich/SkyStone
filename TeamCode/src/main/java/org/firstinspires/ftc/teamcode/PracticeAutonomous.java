package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class PracticeAutonomous extends LinearOpMode {

    DcMotor frontR;
    DcMotor frontL;
    DcMotor backR;
    DcMotor backL;
    Servo hook;



    @Override
    public void runOpMode(){
        frontR = hardwareMap.dcMotor.get("frontR");
        frontL = hardwareMap.dcMotor.get("frontL");
        backR = hardwareMap.dcMotor.get("backR");
        backL = hardwareMap.dcMotor.get("backL");
        hook = hardwareMap.servo.get("hook");

        frontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
waitForStart();


        goBackward(6024, -1); //Initial backup aprx. 2 feet
        sleep(5000);//wait for 5 seconds

        


    }

public void goForward(int encoderClicks, double power){
    frontR.setTargetPosition(encoderClicks);
    frontR.setPower(power);

    frontL.setTargetPosition(encoderClicks);
    frontL.setPower(power);

    backR.setTargetPosition(encoderClicks);
    backR.setPower(power);

    backL.setTargetPosition(encoderClicks);
    backL.setPower(power);


}
public void goBackward(int encoderClicks, double power){


    frontR.setTargetPosition(encoderClicks);
    frontR.setPower(power);

    frontL.setTargetPosition(encoderClicks);
    frontL.setPower(power);

    backR.setTargetPosition(encoderClicks);
    backR.setPower(power);

    backL.setTargetPosition(encoderClicks);
    backL.setPower(power);




}

public void strafeRight(int encoderClicks, double power){

}

public void strafeLeft(int encoderClicks, double power){


}





















}




