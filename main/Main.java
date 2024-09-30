package main;

import srp.*;


public class Main {
    public static void main(String[] args) {
        // Пример SRP
        User user = new User("John");
        UserRepository userRepository = new UserRepository();
        userRepository.save(user);
        

}
