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

    @PostMapping("/character")
    public Character addCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    @PutMapping("/character/{id}")
    public Character updateCharacter(@PathVariable int id, @RequestBody Character character) {
        Character updated = characterService.updateCharacter(id, character);
        if (updated == null) {
            System.out.println("Update failed");
        }
        return updated;
    }

    @GetMapping("/local-characters")
    public List<Character> getLocalCharacters() {
        return characterService.getLocalCharacters();
    }

    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
}