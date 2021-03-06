/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left lift:  "left_hand"
 * Servo channel:  Servo to open right lift: "right_hand"
 */

public class HardwareMap21
{

    // motors
    public DcMotor  FleftDrive  = null;
    public DcMotor  BleftDrive  = null;
    public DcMotor  FrightDrive = null;
    public DcMotor  BrightDrive = null;
    public DcMotor  carousel = null;

    // servos
    public Servo clasp = null;
    public Servo claw = null;

    // define numerical variables
    public static final double CLOSED_SERVO   =  0 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareMap21(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // reference to hardware map
        hwMap = ahwMap;

        // define and initialize motors & servos
        FleftDrive  = hwMap.get(DcMotor.class, "FleftDrive");
        BleftDrive  = hwMap.get(DcMotor.class, "BleftDrive");
        FrightDrive = hwMap.get(DcMotor.class, "FrightDrive");
        BrightDrive = hwMap.get(DcMotor.class, "BrightDrive");
        carousel = hwMap.get(DcMotor.class, "carousel");
        clasp = hwMap.get(Servo.class, "clasp");
        claw = hwMap.get(Servo.class, "claw");

        // set power
        FleftDrive.setPower(0);
        BleftDrive.setPower(0);
        FrightDrive.setPower(0);
        BrightDrive.setPower(0);
        carousel.setPower(0);

        // set mode (use encoder!)
        BleftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FleftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BrightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        carousel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // set direction
        BleftDrive.setDirection(DcMotor.Direction.FORWARD);
        FleftDrive.setDirection(DcMotor.Direction.FORWARD);
        BrightDrive.setDirection(DcMotor.Direction.REVERSE);
        FrightDrive.setDirection(DcMotor.Direction.REVERSE);
        carousel.setDirection(DcMotor.Direction.REVERSE);

        // initialize all servos
        clasp.setPosition(0);
        claw.setPosition(0);
    }
}