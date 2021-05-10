package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LocaleCheck {
    private static String curLocale(){
        String address = null;
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            address =  br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }

    public static String getCity() throws IOException {
        URL url = new URL("http://ip-api.com/csv/" + curLocale());
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String response = br.readLine();
        return response.split(",")[5];
    }

}
