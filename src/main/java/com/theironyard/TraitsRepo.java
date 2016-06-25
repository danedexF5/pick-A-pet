package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TraitsRepo extends JpaRepository<Traitsscore, Long> {



    //Given question#, Trait value and answer, write a function to retrieve a certain row
    @Query ("SELECT t FROM Traitsscore t WHERE t.question = ?1 AND t.answer = ?2 AND t.traitValue = ?3")
    Traitsscore findByRow(String question, int answer, int traitValue);

}
