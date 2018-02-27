package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String JSON_NAME="name";
    public static final String JSON_MAIN_NAME="mainName";
    public static final String JSON_ALSO_KNOWN_AS="alsoKnownAs";
    public static final String JSON_PLACE_OF_ORIGIN="placeOfOrigin";
    public static final String JSON_DESCRIPTION="description";
    public static final String JSON_INGREDIENTS="ingredients";
    public static final String JSON_IMAGE= "image";

    public static Sandwich parseSandwichJson(String json) throws JSONException {


        //Create JSON object from passed string
        JSONObject reader = new JSONObject(json);


        //Start grabbing JSON info to variables
        JSONObject name = reader.getJSONObject(JSON_NAME);

        //Changed getString for optString
        String mainName= name.optString(JSON_MAIN_NAME);
        String placeOfOrigin=  reader.optString(JSON_PLACE_OF_ORIGIN);
        String description= reader.optString(JSON_DESCRIPTION);
        String image= reader.optString(JSON_IMAGE);


        //Go through the 2 arrays and add it's info to list objects
        JSONArray alsoKnownAsJsonArray = name.getJSONArray(JSON_ALSO_KNOWN_AS);
        List<String> alsoKnownAsList= new ArrayList<>();
        for (int i = 0; i<alsoKnownAsJsonArray.length();i++){
            alsoKnownAsList.add(alsoKnownAsJsonArray.getString(i));
        }

        JSONArray ingredientsJsonArray= reader.getJSONArray(JSON_INGREDIENTS);
        List<String> ingredients= new ArrayList<>();
        for (int i=0; i<ingredientsJsonArray.length(); i++){
            ingredients.add(ingredientsJsonArray.getString(i));
        }

        //Create the sandwich object
        return new Sandwich(mainName,alsoKnownAsList,placeOfOrigin,description,image,ingredients);
    }
}
