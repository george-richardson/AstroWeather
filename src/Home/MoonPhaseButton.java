package Home;

import com.bradsbrain.simpleastronomy.MoonPhaseFinder;

import javax.swing.*;
import java.util.Calendar;

public class MoonPhaseButton extends HomeButton {

    public MoonPhaseButton(double angle) {
        super(getMoonPhaseIcon(angle), "Lunar");
    }

    private static Icon getMoonPhaseIcon(double angle) {
        return HomeButton.createIcon("moonPhases/" + getMoonPhaseIconName(angle) + ".png");
    }

    /**
     * @param angle 0 or 360 is NEW, 180 is FULL
     */
    private static String getMoonPhaseIconName(double angle) {
        if (angle < 45) {
            return "young_moon";
        } else if (angle < 90) {
            return "waxing_crescent";
        } else if (angle < 135) {
            return "waxing_quarter";
        } else if (angle < 165) {
            return "waxing_gibbons";
        } else if (angle < 195) {
            return "full_moon";
        } else if (angle < 225) {
            return "waning_gibbons";
        } else if (angle < 270) {
            return "waning_quarter";
        } else if (angle < 315) {
            return "waning_crescent";
        } else {
            return "old_moon";
        }
    }
}