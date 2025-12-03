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
        Character c = characterService.getCharacterByName(name);
        if (c == null) {
            System.out.println("Character not found!");
        }
        return c;
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

    @DeleteMapping("/character/{id}")
    public String deleteCharacter(@PathVariable int id) {
        characterService.deleteCharacter(id);
        return "Character deleted";
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