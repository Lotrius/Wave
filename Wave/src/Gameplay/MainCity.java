/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Chris
 */
public class MainCity {
    private int mHeight;
    private int mWidth;
    private int tHeight;
    private int tWidth;
    String[] maps;
    
    MainCity(String path) throws JSONException {
        JSONObject obj = new JSONObject(path);
        mHeight = obj.getInt("height");
        mWidth = obj.getInt("width");
        tHeight = obj.getInt("tileheight");
        tWidth = obj.getInt("tilewidth");
        JSONArray arr = obj.getJSONArray("tilesets");
        maps = new String[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            String mapPath = arr.getJSONObject(i).getString("source");
            maps[i] = mapPath.substring(mapPath.lastIndexOf("/") + 1, mapPath.lastIndexOf("."));
        }
    }
}
