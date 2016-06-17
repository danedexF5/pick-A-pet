package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepo extends JpaRepository<Dog, Long> {

   /*List<Dog> findByBreedAndDogScore (String Breed, int score);

    @Query("SELECT d FROM Dog d WHERE SIZE(d.size) LIKE LOWER(CONCAT('%', ?1, '%')) AND d.user = ?1")
    List<Dog> findBySizeAndScore(int size, int score);*/

}
