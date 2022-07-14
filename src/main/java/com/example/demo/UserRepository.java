package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    //Optional<User> findByUsername(String username);
   ///List<User> findTop10ByBirthdayOrderByUsernameAsc(LocalDate birthday);
   //User findByUsernameAndAgeAndBirthday(String username,LocalDate birthday);

    @Query("from User where username=:username")
    Optional<User>findCustom(String username);
    @Query(nativeQuery = true,value="SELECT*FROM users where username=:username")
    Optional<User> findCustomNativeQuery(String username);


}
