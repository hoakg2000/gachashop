package com.gachashop.shop.controller;

import com.gachashop.shop.model.GenshinCharacter;
import com.gachashop.shop.service.IGenshinCharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/genshin-characters")
public class GenshinCharacterController {

    @Autowired
    private IGenshinCharacterService genshinCharacterService;

    @GetMapping("/{id}")
    public ResponseEntity<GenshinCharacter> getCharacterById(@PathVariable Long id) throws Exception {
        GenshinCharacter character = genshinCharacterService.getById(id);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GenshinCharacter>> getAllCharacters() {
        List<GenshinCharacter> characters = genshinCharacterService.getAll();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenshinCharacter> createCharacter(@Valid @RequestBody GenshinCharacter character) throws Exception {
        GenshinCharacter createdCharacter = genshinCharacterService.create(character);
        return new ResponseEntity<>(createdCharacter, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenshinCharacter> updateCharacter(@PathVariable Long id, @Valid @RequestBody GenshinCharacter character) throws Exception {
        GenshinCharacter updatedCharacter = genshinCharacterService.update(id, character);
        return new ResponseEntity<>(updatedCharacter, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) throws Exception {
        genshinCharacterService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
