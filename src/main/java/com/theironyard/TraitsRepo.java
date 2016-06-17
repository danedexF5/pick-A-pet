package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TraitsRepo extends JpaRepository<TraitsScore, Long> {



    //Given question#, Trait value and answer, write a function to retrieve a certain row
    @Query


}
