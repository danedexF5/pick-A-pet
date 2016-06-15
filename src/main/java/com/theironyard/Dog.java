package com.theironyard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    Integer id;
    String breed;
    int energy;
    int attention;
    int exercise;
    int size;
    int space;
    int outdoor;
    int kids;
    int sheds;
    int friendliness;

    @Transient
    int score;

}
