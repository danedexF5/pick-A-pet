package com.theironyard;

import org.json.JSONObject;

/**
 * Created by danedexheimer on 6/25/16.
 */
public class Pet {
    String phone = "";
    String age = "";
    String name = "";
    String id = "";
    String gender = "";
    String description = "";
    String photo = "";
    String contact = "";

    public Pet(JSONObject petData){
        try {
            phone = petData.getJSONObject("contact").getJSONObject("phone").getString("$t");
        } catch (Exception e){
            System.out.println("no phone");
        }
        try {
            age = petData.getJSONObject("age").getString("$t");
        } catch (Exception e){
            System.out.println("no age");
        }
        try {
            id = petData.getJSONObject("id").getString("$t");
        } catch (Exception e){
            System.out.println("no id");
        }
        try {
            name = petData.getJSONObject("name").getString("$t");
        } catch (Exception e){
            System.out.println("no name");
        }
        try {
            description = petData.getJSONObject("description").getString("$t");
        } catch (Exception e){
            System.out.println("no description");
        }
        try {
            gender = petData.getJSONObject("sex").getString("$t");
        } catch (Exception e){
            System.out.println("no gender");
        }
        try {
            contact = petData.getJSONObject("contact").toString();
        } catch (Exception e){
            System.out.println("no contact");
        }
    }


}
