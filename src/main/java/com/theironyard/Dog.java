package com.theironyard;

import javax.persistence.*;

@Entity
@Table
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public int getExercise() {
        return exercise;
    }

    public void setExercise(int exercise) {
        this.exercise = exercise;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(int outdoor) {
        this.outdoor = outdoor;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public int getSheds() {
        return sheds;
    }

    public void setSheds(int sheds) {
        this.sheds = sheds;
    }

    public int getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(int friendliness) {
        this.friendliness = friendliness;
    }

}
