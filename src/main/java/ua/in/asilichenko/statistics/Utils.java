package ua.in.asilichenko.statistics;

public class Utils {

    public static double round(double val, int places) {
        final double shift = Math.pow(10, places);
        return Math.round(val * shift) * 1d / shift;
    }
}
