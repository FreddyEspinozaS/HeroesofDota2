package com.example.fredd.heroesofdota2;

import java.net.MalformedURLException;
import java.net.URL;

public class ClearbitLogoApiService {
    public static String LOGO_BASE_URL = "https://logo.clearbit.com/";
    public static String getUrlToLogo(String url){
        try{
            url = "https://api.opendota.com" + url;
            return LOGO_BASE_URL  + (new URL(url)).getHost();
        }catch (MalformedURLException e){
            e.printStackTrace();
            url = "https://api.opendota.com" + url;
            return LOGO_BASE_URL + url;
        }
    }
}
