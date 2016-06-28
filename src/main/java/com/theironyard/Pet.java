package com.theironyard;

import org.json.JSONArray;
import org.json.JSONObject;

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
            //description = HtmlEscape.escapeBr(petData.getJSONObject("description").getString("$t"));
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
            JSONObject jsonContact = petData.getJSONObject("contact");
            contact = jsonContact.getJSONObject("address1").getString("$t") + "\n";
            //contact += jsonContact.getJSONObject("address2").getString("$t");
            contact += jsonContact.getJSONObject("city").getString("$t") + "\n";
            contact += jsonContact.getJSONObject("state").getString("$t") + "\n";
            contact += jsonContact.getJSONObject("zip").getString("$t") + "\n";
            contact += jsonContact.getJSONObject("email").getString("$t") + "\n";
        } catch (Exception e){
            System.out.println("no contact");
        }
        try {
            JSONArray photoArray = petData.getJSONObject("media").getJSONObject("photos").getJSONArray("photo");
            photo = photoArray.getJSONObject(3).getString("$t");
        } catch (Exception e){
            System.out.println("no gender");
        }
    }

}
