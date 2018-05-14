package com.example.fredd.heroesofdota2.Services;

import android.util.JsonReader;

import com.example.fredd.heroesofdota2.Entities.Hero;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HeroService implements IHeroService {
    @Override
    public ArrayList<Hero> getHeroes() {
        ArrayList <Hero> heroArrayList =
                new ArrayList<>();

        try {
            URL apiUrl =
                    new URL("https://api.opendota.com/api/heroStats");

            //Create connection
            HttpURLConnection myConnection = (HttpURLConnection) apiUrl.openConnection();

            //Process response
            if (myConnection.getResponseCode() == 200){
                // Success
                // Further processing here

                // Read response
                InputStream responseBody = myConnection.getInputStream();

                // Use reader for response
                InputStreamReader responseBodyReader =
                        new InputStreamReader(responseBody, "UTF-8");

                // Read JSON
                JsonReader jsonReader = new JsonReader(responseBodyReader);

                // Start reading array
                jsonReader.beginArray();

                // Read elements
                while (jsonReader.hasNext()){
                    // Read every object
                    jsonReader.beginObject();
                    int id = 0;
                    String name = null;
                    String localized_name = null;
                    String primary_attr =null;
                    String attack_type = null;
                    ArrayList<String> roles = new ArrayList<>();
                    String URLIcon = null;
                    int legs = 0;
                    while (jsonReader.hasNext()){
                        String property = jsonReader.nextName();
                        switch (property.toLowerCase()){
                            case "id":
                                id = jsonReader.nextInt();
                                break;
                            case "name":
                                name = jsonReader.nextString();
                                break;
                            case "localized_name":
                                localized_name = jsonReader.nextString();
                                break;
                            case "primary_attr":
                                primary_attr = jsonReader.nextString();
                                break;
                            case "attack_type":
                                attack_type = jsonReader.nextString();
                                break;
                            case "roles":
                                // Start reading roles array
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()){
                                    roles.add(jsonReader.nextString());
                                }
                                // End reading roles array
                                jsonReader.endArray();
                                break;
                            case "icon":
                                URLIcon = jsonReader.nextString();
                                break;
                            case "legs":
                                legs = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    // Add item to the list
                    URLIcon = "https://api.opendota.com" + URLIcon;
                    Hero objHero = new Hero(id, name, localized_name, primary_attr, attack_type,roles,legs, URLIcon);
                    objHero.save();
                    heroArrayList.add(objHero);
                    jsonReader.endObject();
                }
                jsonReader.endArray();
                jsonReader.close();
                myConnection.disconnect();
            }else {
                // Error handling code goes here
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return heroArrayList;
    }
}
