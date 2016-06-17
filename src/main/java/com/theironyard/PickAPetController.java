package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

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
    public String showPet(String q1, String q2, HttpSession session) {

        Iterable<Dog> dogList = DogRepo.findAll();
        Iterable<TraitsScore> traitsList = TraitsRepo.findAll();


        for (Dog d : dogList) {
            for (TraitsScore t : traitsList){
                if(t.question == 1 && t.traitValue == d.energy && t.answer == Integer.parseInt(q1)){
                    d.score += t.score;
                }
                if(t.question == 2 && t.traitValue == d.attention && t.answer == Integer.parseInt(q2)){
                    d.score += t.score;
                }

            }


        }
        //return the home template
        return "home";
    }
}

   /* public void questionsQ1(String q1, Dog d) {
        switch (q1) {
            case "1":
                if (d.attention == 1) {
                    d.score += 4;
                } else {
                    d.score += 1;
                }
                break;
            case "2":
                switch (d.attention) {
                    case 1:
                        break;
                    case 2:
                        d.score += 4;
                        break;
                    default:
                        d.score += 1;
                }
                break;
            case "3":
                switch (d.attention) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                        d.score += 4;
                        break;
                    default:
                        d.score += 1;
                }
                break;
            case "4":
                switch (d.attention) {
                    case 1:
                    case 2:
                    case 3:
                    default:
                        d.score += 4;
                }
                break;
        }
    }

    public void questionsQ2(String q2, Dog d) {
        switch (q2) {
            case "1":
                if (d.exercise == 1) {
                    d.score += 3;
                } else {
                    d.score += 1;
                }
                break;
            case "2":
                if (d.exercise == 2) {
                    d.score += 3;
                } else {
                    d.score += 1;
                }
                break;
            case "3":
                if (d.exercise == 3) {
                    d.score += 3;
                } else {
                    d.score += 1;
                }
                break;
        }
    }

    /*public void questionsQ3(String q3, Dog d) {
        switch (q3) {
            case "1":
                if (d.size == 1) {
                    d.score += 5;
                }
                if (d.size == 2) {
                    d.score += 2;
                } else {
                    d.score += 0;
                }
                break;
            case "2":
                if (d.size == 1) {
                    d.score += 1;
                }
                if (d.size == 2) {
                    d.score += 5;
                }
                if (d.size == 3) {
                    d.score += 1;
                } else {
                    d.score += 0;
                }
                break;
            case "3":
                if (d.size == 1) {
                    d.score += 0;
                }
                if (d.size == 2) {
                    d.score += 1;
                }
                if (d.size == 3) {
                    d.score += 5;
                }
                if (d.size == 4) {
                    d.score += 1;
                }
                if (d.size == 5) {
                    d.score += 0;
                }
                break;
            case "4":
                if (d.size == 1) {
                    d.score += 0;
                }
                if (d.size == 2) {
                    d.score += 1;
                }
                if (d.size == 3) {
                    d.score += 5;
                }
                if (d.size == 4) {
                    d.score += 1;
                }
                if (d.size == 5) {
                    d.score += 0;
                }
                break;
            case 5:
            default:
                d.score += 1;
                break;
        }

    }

    @RequestMapping(path = "/", method = RequestMethod.POST)

    //It should take the model and the session as arguments
    public String showPet(String q1, String q2, HttpSession session) {

        Iterable<Dog> dogList = DogRepo.findAll();

        for (Dog d : dogList) {
            questionsQ1(q1, d);
            questionsQ2(q2, d);
        }
        //return the home template
        return "home";
    }


}*/