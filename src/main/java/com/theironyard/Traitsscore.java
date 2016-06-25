package com.theironyard;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Traitsscore {

    @Id
    @GeneratedValue
    Integer id;

    String question;
    int traitValue;
    int answer;
    int score;

}
