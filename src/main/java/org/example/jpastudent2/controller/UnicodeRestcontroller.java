package org.example.jpastudent2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnicodeRestcontroller {

    //Step 2
    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char) i;
        return "unicode=" + i + " char=" + c;
    }

    //Step 3
    @GetMapping("/char/{character}")
    public String charToUnicode(@PathVariable String character) {
        char c = character.charAt(0);
        int unicode = (int) c; //konverterer char til dens unicodeværdi
        return "char=" + c + " unicode=" + unicode;
    }
}
