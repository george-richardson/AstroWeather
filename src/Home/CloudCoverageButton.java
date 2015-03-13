package Home;

import API.Forecast;

import javax.swing.*;

public class CloudCoverageButton extends HomeButton {

    public CloudCoverageButton(Forecast forecast) {
        super(determineCloudCoverageIcon(forecast), "Cloud");
    }

    private static Icon determineCloudCoverageIcon(Forecast forecast) {
        return HomeButton.createIcon("cloudCoverage/" + determineCloudCoverageIconName(forecast) + ".png");
    }

    private static String determineCloudCoverageIconName(Forecast forecast) {
        double coverage;
        try {
            coverage = Double.parseDouble(forecast.cloudVal);
        } catch (NumberFormatException e) {
            return "sky_obscured";
        }

        if (coverage == 0) {
            return "clear";
        } else if (coverage < 10) {
            return "one_tenth_or_less_but_not_zero";
        } else if (coverage < 30) {
            return "two_tenths_to_three_tenths";
        } else if (coverage < 40) {
            return "four_tenths";
        } else if (coverage < 50) {
            return "five_tenths";
        } else if (coverage < 60) {
            return "six_tenths";
        } else if (coverage < 70) {
            return "seven_tenths_to_eight_tenths";
        } else if (coverage < 90) {
            return "nine_tenths_overcast_with_openings";
        } else {
            return "nine_tenths_completely_overcast";
        }
    }
}
