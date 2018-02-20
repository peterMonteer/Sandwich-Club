package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject reader = new JSONObject(json);

        JSONObject name = reader.getJSONObject("name");
        String mainName= name.getString("mainName");

        JSONArray akaJsonArray = name.getJSONArray("alsoKnownAs");
        List<String> akas= new ArrayList<>();

        for (int i = 0; i<akaJsonArray.length();i++){
            String akaString= akaJsonArray.getString(i);
            akas.add(akaString);
        }

        String placeOfOrigin=  reader.getString("placeOfOrigin");

        String description= reader.getString("description");
        String image= reader.getString("image");

        JSONArray ingredientsJsonArray= reader.getJSONArray("ingredients");
        List<String> ingredients= new ArrayList<>();
        for (int i=0; i<ingredientsJsonArray.length(); i++){
            String ingredient= ingredientsJsonArray.getString(i);
            ingredients.add(ingredient);
        }
        Sandwich detailSandwich= new Sandwich(mainName,akas,placeOfOrigin,description,image,ingredients);


        return detailSandwich;
    }
}
