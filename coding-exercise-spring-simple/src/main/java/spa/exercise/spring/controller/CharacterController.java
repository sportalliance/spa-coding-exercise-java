package spa.exercise.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spa.exercise.spring.model.Character;
import spa.exercise.spring.service.CharacterService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/character/{id}")
    public Character getCharacter(@PathVariable int id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping("/search")
    public Character searchCharacter(@RequestParam String name) {
        try {
        Character c = characterService.getCharacterByName(name);
        return c;
        } catch (Exception e) {
            System.out.println("Character not found!");
            return null;
        }
    }

    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
}