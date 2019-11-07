package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp
public class TeleSkystone extends OpMode {

    //intitializing motors
    DcMotor frontR;
    DcMotor frontL;
    DcMotor backR;
    DcMotor backL;
    DcMotor intakeLow;
    DcMotor elevator;
    DcMotor intakeHigh;
    CRServo slider;
    DcMotor autoMotor;
    Servo hook;


    //initializing servos
    Servo claw;
    Servo gate;

    //Creating values to store stick values
    double lStickY;
    double lStickX;
    double rStickY;
    double rStickX;


    //Creating minimum power and maximum power (getting rid of magic numbers)
    public static final double MIN_POWER = 0;
    public static final double MAX_POWER = 1;


    public void init(){

        //Mapping all components
        elevator = hardwareMap.dcMotor.get("elevator");
        intakeLow = hardwareMap.dcMotor.get("intakeLow");
        intakeHigh = hardwareMap.dcMotor.get("intakeHigh");
        slider = hardwareMap.crservo.get("slider");
        claw = hardwareMap.servo.get("claw");
        frontR = hardwareMap.dcMotor.get("frontR");
        backR = hardwareMap.dcMotor.get("backR");
        frontL = hardwareMap.dcMotor.get("frontL");
        backL = hardwareMap.dcMotor.get("backL");
        autoMotor = hardwareMap.dcMotor.get("autoMotor");
        hook = hardwareMap.servo.get("hook");

        //Reversing appropriate motors
        intakeLow.setDirection(DcMotorSimple.Direction.REVERSE);
        frontR.setDirection(DcMotorSimple.Direction.REVERSE);
        backL.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void loop(){

        //Setting values equal to stick values
        lStickY = gamepad1.left_stick_y;
        lStickX = gamepad1.left_stick_x;
        rStickY = gamepad1.right_stick_y;
        rStickX = gamepad1.right_stick_x;



//ELEVATOR

        //Elevator goes up and down
        if(gamepad1.right_trigger !=0){
            elevator.setPower(-gamepad1.right_trigger);
        }else if (gamepad1.left_trigger != 0){
            elevator.setPower(gamepad1.left_trigger);
        }else{
            elevator.setPower(0);
        }

//SLIDER

        //Slider moves forward and backward
        if(gamepad1.left_bumper){
            slider.setPower(1);
        } else if (gamepad1.right_bumper){
            slider.setPower(-1);
        } else{
            slider.setPower(0.4);
        }

//CLAW

        //Making the claw do its thing
        if (gamepad1.dpad_up){
            claw.setPosition(0);

        }

        if (gamepad1.dpad_down){
            claw.setPosition(1);
        }


//INTAKE

        if (gamepad1.a){
            intakeLow.setDirection(DcMotorSimple.Direction.FORWARD);
            intakeHigh.setDirection(DcMotorSimple.Direction.FORWARD);

            intakeLow.setPower(MAX_POWER);
            intakeHigh.setPower(MAX_POWER);
        }
        if (gamepad1.a && intakeLow.getPower() != 0){
            intakeLow.setPower(MIN_POWER);
            intakeHigh.setPower(MIN_POWER);
        }

//AUTONOMOUS HOOK

        if(gamepad1.x){
            hook.setPosition(1);
        }else if (gamepad1.x && hook.getPosition() < 1){
            hook.setPosition(0);
        }




//DRIVING

        //Drive forward and backward
        if(lStickY != 0){
            frontR.setPower(lStickY);
            backR.setPower(lStickY);
            frontL.setPower(lStickY);
            backL.setPower(lStickY);
        }

        if(lStickX != 0){
            frontR.setPower(-lStickX);
            backR.setPower(-lStickX);
            frontL.setPower(lStickX);
            backL.setPower(lStickX);
        }

//Strafe
        if(rStickX > 0){
            frontR.setPower(rStickX);
            backR.setPower(-rStickX);
            frontL.setPower(-rStickX);
            backL.setPower(rStickX);
        } else if(rStickX < 0){
            frontR.setPower(-rStickX);
            backR.setPower(rStickX);
            frontL.setPower(rStickX);
            backL.setPower(-rStickX);
        } else{
            frontR.setPower(0);
            backR.setPower(0);
            frontL.setPower(0);
            backL.setPower(0);
        }


    }


}
