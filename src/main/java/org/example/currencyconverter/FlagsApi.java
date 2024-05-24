package org.example.currencyconverter;

import javafx.scene.image.Image;

public class FlagsApi {

    public static Image getFlagImg(String countryCode)
    {
        String currencyCountryCode = countryCode.substring(0,2);
        String flagUrl = String.format("https://flagsapi.com/%s/flat/64.png",currencyCountryCode);
        return new Image(flagUrl);
    }

}
