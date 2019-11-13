package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

public class AutoSkystone extends LinearOpMode {
    ColorSensor sensorColor;
    DcMotor motor;


    @Override
    public void runOpMode() {
        sensorColor = hardwareMap.get(ColorSensor.class, "sensor_color");
        motor = hardwareMap.dcMotor.get("motor");
        sensorColor.addColorData();
    }


    public void addColorData() {
        telemetry.addData("Red", sensorColor.red());
        telemetry.addData("Green", sensorColor.green());
        telemetry.addData("Blue", sensorColor.blue());

        telemetry.update();

    }




}



