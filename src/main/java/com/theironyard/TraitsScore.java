package com.theironyard;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TraitsScore {

    @Id
    @GeneratedValue
    Integer id;

    int question;
    int traitValue;
    int answer;
    int score;

}
