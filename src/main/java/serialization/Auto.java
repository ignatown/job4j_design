package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "auto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Auto {
    @XmlAttribute
    private boolean automaticTransmission;
    @XmlAttribute
    private int horsepower;
    @XmlAttribute
    private String model;
    private Manufacturer manufacturer;
    private String[] colors;

    public Auto() {
    }

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

    public static void main(String[] args) {
        final Auto auto = new Auto(false, 102, "Accent",
                new Manufacturer("Hyundai", "Korea"), new String[] {"Black", "White", "Cherry"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(auto));

        final String autoJson =
                "{"
                        + "\"automaticTransmission\":false,"
                        + "\"horsepower\":102,"
                        + "\"model\":\"Accent\","
                        + "\"manufacturer\":"
                        + "{"
                        + "\"name\":\"Hyundai\","
                        + "\"country\":\"Korea\""
                        + "},"
                        + "\"colors\":"
                        + "[\"Black\",\"White\",\"Cherry\"]"
                        + "}";
        final Auto autoMod = gson.fromJson(autoJson, Auto.class);
        System.out.println(autoMod);
    }
}
