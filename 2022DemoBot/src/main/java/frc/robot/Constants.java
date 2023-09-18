// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int TALONFL = 7;
    public static final int TALONFR = 1;
/*
    public static final int SPARK_ML = 1;
    public static final int SPARK_MR = 3;*/
    public static final int TALONBL = 2;
    public static final int TALONBR = 3;

    public static final int LEFTSTICK_YAXIS = 5;
    public static final int RIGHTSTICK_YAXIS = 1;
    public static final int RIGHTSTICK_XAXIS = 4;

    public static final int CONTROLLER_PORT = 0;

    public static final double DRIVESPEEDCONSTANT = 0.9;
    public static final double AUTOSPEEDCONTANT = 0.5;
}