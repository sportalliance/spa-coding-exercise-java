package spa.exercise.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spa.exercise.spring.model.Character;
import spa.exercise.spring.model.SwapiResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {

    private RestTemplate restTemplate;
    private List<Character> characterList = new ArrayList<>();

    public CharacterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Character> getAllCharacters() {
        String url = "https://swapi.dev/api/people/";
        SwapiResponse response = restTemplate.getForObject(url, SwapiResponse.class);
        return response.getResults();
    }

    public Character getCharacterById(int id) {
        String url = "https://swapi.dev/api/people/" + id + "/";
        Character character = restTemplate.getForObject(url, Character.class);
        return character;
    }

    public Character getCharacterByName(String name) {
        String url = "https://swapi.dev/api/people/?search=" + name;
        SwapiResponse response = restTemplate.getForObject(url, SwapiResponse.class);
        if (response.getResults().size() > 0) {
            return response.getResults().get(0);
        }
        return null;
    }

    public Character createCharacter(Character character) {
        // SWAPI doesn't support POST, so we'll just add to our local list
        characterList.add(character);
        return character;
    }

    public Character updateCharacter(int id, Character character) {
        // SWAPI doesn't support PUT, so we'll just update in our local list
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).getName().equals(character.getName())) {
                characterList.set(i, character);
                return character;
            }
        }
        return null;
    }

    public void deleteCharacter(int id) {
        // SWAPI doesn't support DELETE, so we'll remove from our local list
        for (int i = 0; i < characterList.size(); i++) {
            Character c = characterList.get(i);
            if (c.getUrl() != null && c.getUrl().contains(String.valueOf(id))) {
                characterList.remove(i);
                break;
            }
        }
    }

    public List<Character> getLocalCharacters() {
        return characterList;
    }
}