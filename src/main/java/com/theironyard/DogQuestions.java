package com.theironyard;


public class DogQuestions {

    int questionNumber;
    String question;
    String questionOptions[];
    int correctOptionIndex;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String[] questionOptions) {
        this.questionOptions = questionOptions;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }
}
