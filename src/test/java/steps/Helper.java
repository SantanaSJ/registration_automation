package steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {

    private String subtype;
    private final List<String> unsupportedCountries;
    private String country;


    public Helper() {
        this.unsupportedCountries = new ArrayList<>(Arrays.asList("US Minor Outlying Islands", "Cocos (Keeling) Islands", "Cuba", "Zimbabwe",
                "Benin", "Serbia", "Nicaragua", "Saint Pierre and Miquelon", "Ecuador", "Honduras",
                "Nigeria", "Nauru", "Moldova, Republic of", "Ethiopia", "Israel", "Mongolia", "Mali",
                "Dominican Republic", "Guinea", "Burkina Faso", "Bhutan", "Grenada", "Korea, Republic of (South)",
                "New Caledonia", "Kosovo", "Antarctica", "Curacao", "Jordan", "Namibia", "Albania", "Tunisia",
                "Colombia", "Eritrea", "Vietnam", "Libya", "Somalia", "Pakistan", "Republic of North Macedonia", "Pitcairn Island",
                "Indonesia", "Sri Lanka", "Aland Islands", "Tuvalu", "Sierra Leone", "Bosnia and Herzegovina", "Senegal", "Mozambique",
                "Norfolk Island", "Liberia", "Bahamas", "Micronesia, Federated States of", "Barbados", "Russia", "Kiribati", "Sao Tome and Principe",
                "Greenland"));
    }


    public void setSubType(String subtype) {
        this.subtype = subtype;
    }

    public String getSubType() {
        return subtype;
    }

    public boolean isSupported(String country) {
        return unsupportedCountries.contains(country);
    }

    public List<String> getUnsupportedCountries() {
        return unsupportedCountries;
    }

    public void addCountry(String country) {
        if (!unsupportedCountries.contains(country)) {
            unsupportedCountries.add(country);
            System.out.println(country + " added to unsupported countries.");  // Just for debugging
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
