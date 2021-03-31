package serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class Auto {
    private final boolean automaticTransmission;
    private final int horsepower;
    private final String model;
    private final Manufacturer manufacturer;
    private final String[] colors;

    public Auto(boolean automaticTransmission, int horsepower, String model, Manufacturer manufacturer, String[] colors) {
        this.automaticTransmission = automaticTransmission;
        this.horsepower = horsepower;
        this.model = model;
        this.manufacturer = manufacturer;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "automaticTransmission=" + automaticTransmission +
                ", horsepower=" + horsepower +
                ", model='" + model + '\'' +
                ", manufacturer=" + manufacturer +
                ", colors=" + Arrays.toString(colors) +
                '}';
    }

    public boolean isAutomaticTransmission() {
        return automaticTransmission;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getModel() {
        return model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String[] getColors() {
        return colors;
    }

    public static void main(String[] args) {
        final Auto auto = new Auto(false, 102, "Accent",
                new Manufacturer("Hyundai", "Korea"), new String[] {"Black", "White", "Cherry"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("automaticTransmission", auto.isAutomaticTransmission());
        jsonObject.put("horsepower", auto.getHorsepower());
        jsonObject.put("model", auto.getModel());
        jsonObject.put("manufacturer", auto.getManufacturer());
        jsonObject.put("colors", new JSONArray(auto.getColors()));

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(auto).toString());
    }
}
