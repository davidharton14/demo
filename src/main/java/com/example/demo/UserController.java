package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path ="/getUsers")
    public List<User> getUsers(){
        List<User> usersFromDb = new ArrayList<User>();
        for(User user :userRepository.findAll()){
            usersFromDb.add(user);
        }
        return usersFromDb;
    }

    @GetMapping(path="/getUser/{id}")
    public User getUserByIdWithPath(@PathVariable int id){
        Optional<User>optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            return null;
        }
    }
    @GetMapping(path="/getUserByName")
    public User getUserById(@RequestParam String name){
        Optional<User>optionalUser=userRepository.findCustomNativeQuery(name);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            return null;
        }
    }
    @GetMapping(path="/insert")
    public User insert(@RequestParam int id,@RequestParam String username,@RequestParam String birthday){
       User user=new User();
       user.setId(id);
       user.setUsername(username);
       user.setBirthday(LocalDate.parse(birthday));
       return userRepository.save(user);
    }
    @GetMapping(path="/updateUsername")
    public User insert(@RequestParam int id,@RequestParam String newUsername){
        Optional<User>existingUser=userRepository.findById(id);
        User user=existingUser.get();
        existingUser.get().setUsername(newUsername);
        return userRepository.save(user);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable int id) {
        userRepository.deleteById(id);
    }
    @PostMapping(path="/getUser/{id}")
    public User postUserByIdWithPath(@PathVariable int id){
        if(id==1){
            User david=new User();
            david.setId(1);
            david.setUsername("david");
            david.setBirthday(LocalDate.of(1998,4,1 ));
            return david;
        }else if (id==2){
            User maria=new User();
            maria.setId(2);
            maria.setUsername("maria");
            maria.setBirthday(LocalDate.of(1996,7,11));
            return maria;
        }else{
            return null;
        }
    }
}
