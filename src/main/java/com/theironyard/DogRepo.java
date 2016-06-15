package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepo extends JpaRepository {

    Dog findByScore(int score);

}
