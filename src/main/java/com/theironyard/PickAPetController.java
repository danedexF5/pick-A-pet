package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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
    public String showPet(String q1, String q2, String q3, String q4, String q5, String q6,
                          String q7, String q8, String q9, Model model, HttpSession session) {

        List<Dog> dogList = DogRepo.findAll();
        Iterable<Traitsscore> traitsList = TraitsRepo.findAll();

        Dog dogChoice = dogList.get(0);
        for (Dog d : dogList) {
            d.score += TraitsRepo.findByRow(1, Integer.parseInt(q1), d.energy).score;
            d.score += TraitsRepo.findByRow(2, Integer.parseInt(q2), d.attention).score;
           /* d.score += TraitsRepo.findByRow(3, Integer.parseInt(q3), d.exercise).score;
            d.score += TraitsRepo.findByRow(4, Integer.parseInt(q4), d.size).score;
            d.score += TraitsRepo.findByRow(5, Integer.parseInt(q5), d.space).score;
            d.score += TraitsRepo.findByRow(6, Integer.parseInt(q6), d.outdoor).score;
            d.score += TraitsRepo.findByRow(7, Integer.parseInt(q7), d.kids).score;
            d.score += TraitsRepo.findByRow(8, Integer.parseInt(q8), d.sheds).score;
            d.score += TraitsRepo.findByRow(9, Integer.parseInt(q9), d.friendliness).score;*/

           if(dogChoice.score < d.score){
               dogChoice = d;
           }

        }
        model.addAttribute("dogChoice", dogChoice);
        //return the home template
        return "dog";
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