package Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by George on 14/03/2015.
 */
public class SettingsModel {
    private boolean celcius;
    private boolean mph;
    private static SettingsModel instance;

    public static SettingsModel getInstance() {
        if (instance == null) instance = new SettingsModel();
        return instance;
    }

    private SettingsModel() {
        File settingsFile = new File("settings.ini");
        if (!settingsFile.exists()) {
            celcius = true;
            mph = true;
        } else {
            try {
                Scanner s = new Scanner(settingsFile);
                celcius = s.nextBoolean();
                mph = s.nextBoolean();
                System.out.println(celcius);
                System.out.println(mph);
                s.close();
            } catch (Exception e) {
                celcius = true;
                mph = true;
            }
        }
    }

    public boolean isCelcius() {
        return celcius;
    }

    public void setCelcius(boolean celcius) {
        this.celcius = celcius;
        saveValues();
    }

    public boolean isMph() {
        return mph;
    }

    public void setMph(boolean mph) {
        this.mph = mph;
        saveValues();
    }

    public void saveValues() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("settings.ini", false));
            pw.println(celcius ? "true" : "false");
            pw.println(mph ? "true" : "false");
            pw.close();
        } catch (Exception e) {
        }
    }
}
