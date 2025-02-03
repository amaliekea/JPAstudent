package org.example.jpastudent2.config;

import org.example.jpastudent2.model.Unicode;
import org.example.jpastudent2.repositories.UnicodeRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitUnicodeData implements CommandLineRunner {

    @Autowired
    private UnicodeRespository unicodeRepository;

    @Override
    public void run(String... args) throws Exception {
        Set<Character> unicodeSet = new HashSet<>();

        // Tilføj eksempler på Unicode-tegn til sættet
        for (char c = 'A'; c <= 'Z'; c++) { // Store bogstaver A-Z
            unicodeSet.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) { // Små bogstaver a-z
            unicodeSet.add(c);
        }

        // Gem alle Unicode-tegn i databasen
        unicodeSet.forEach(character -> {
            Unicode entity = new Unicode();
            entity.setBogstav(character);
            unicodeRepository.save(entity);
        });

        System.out.println("Unicode characters saved in database!");
    }
}
