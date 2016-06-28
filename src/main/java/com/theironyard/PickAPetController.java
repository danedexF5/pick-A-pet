package com.theironyard;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PickAPetController {

    @Autowired
    DogRepo DogRepo;

    @Autowired
    TraitsRepo TraitsRepo;

    @RequestMapping(path = "/", method = RequestMethod.GET)

    //It should take the model and the session as arguments
    public String home(Model model, HttpSession session) {

        //return the home template
        return "home";


    }

    @RequestMapping(path = "/", method = RequestMethod.POST)

    //It should take the model and the session as arguments
    public String showPet(String attention, String energy, String exercise, String size, String space, String outdoor,
                          String kids, String sheds, String friendliness, Model model, HttpSession session, HttpServletRequest request) throws IOException {


        String ip = request.getRemoteAddr();

        CityResponse cityResponse = null;

        try {
            cityResponse = getCity(ip);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }

        String zipcode;

        if (cityResponse != null) {
            zipcode = cityResponse.getPostal().getCode();
        } else {
            zipcode = "27701";
        }

        //Dog dog = new Dog();

        if (attention == null || energy == null || exercise == null || size == null || space == null || outdoor == null
                || kids == null || sheds == null || friendliness == null) {
            return "home";
        }

        List<Dog> dogList = DogRepo.findAll();
        //Iterable<Traitsscore> traitsList = TraitsRepo.findAll();

        Dog dogChoice = dogList.get(0);
        for (Dog d : dogList) {
            d.score += TraitsRepo.findByRow("attention", Integer.parseInt(attention), d.attention).score;
            d.score += TraitsRepo.findByRow("energy", Integer.parseInt(energy), d.energy).score;
            d.score += TraitsRepo.findByRow("exercise", Integer.parseInt(exercise), d.exercise).score;
            d.score += TraitsRepo.findByRow("size", Integer.parseInt(size), d.size).score;
            d.score += TraitsRepo.findByRow("space", Integer.parseInt(space), d.space).score;
            d.score += TraitsRepo.findByRow("outdoor", Integer.parseInt(outdoor), d.outdoor).score;
            d.score += TraitsRepo.findByRow("kids", Integer.parseInt(kids), d.kids).score;
            d.score += TraitsRepo.findByRow("sheds", Integer.parseInt(sheds), d.sheds).score;
            d.score += TraitsRepo.findByRow("friendliness", Integer.parseInt(friendliness), d.friendliness).score;

            if (dogChoice.score < d.score) {
                dogChoice = d;
            }

        }
        JSONArray petsArray = getPets(zipcode, dogChoice.breed);
        ArrayList<Pet> pets = new ArrayList<>();
        for (Object petObj : petsArray) {
            // cast to JSONObject
            JSONObject jsonPet = (JSONObject) petObj;

            // make a pet
            Pet pet = new Pet(jsonPet);

            // add to list
            pets.add(pet);
        }
        model.addAttribute("pets", pets);
        model.addAttribute("dogChoice", dogChoice);
        //return the dog template
        return "dog";
    }

    public CityResponse getCity(String ip) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);

        // get IP
        System.out.println(ipAddress.toString());

        // todo: add try/catch incase something blows up. add "no pets" message or something

        // Do the lookup
        File db = new File("GeoLite2-City.mmdb");
        DatabaseReader reader = new DatabaseReader.Builder(db).build();


        CityResponse response = reader.city(ipAddress);
        return response;
    }

    public JSONArray getPets(String zipcode, String breed) throws IOException {
        String url = "http://api.petfinder.com/pet.find?key=7875e0a922b85853ebf2a9c60216a971&breed=" +
                URLEncoder.encode(breed, "UTF-8") + "&animal=dog&format=json&count=10&output=basic&location=" + zipcode;

        // get json as string from url
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(url);
        HttpResponse result = httpClient.execute(getRequest);
        String json = EntityUtils.toString(result.getEntity(), "UTF-8");

        // parse json and get pets json array
        JSONObject findPetResult = new JSONObject(json);
        JSONArray petsArray = findPetResult.getJSONObject("petfinder").getJSONObject("pets").getJSONArray("pet");
        return petsArray;
    }
}

