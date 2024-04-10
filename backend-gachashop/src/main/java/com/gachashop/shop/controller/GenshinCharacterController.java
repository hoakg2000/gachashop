package com.gachashop.shop.controller;

import com.gachashop.shop.model.GenshinCharacter;
import com.gachashop.shop.model.GenshinConstellation;
import com.gachashop.shop.service.IGenshinCharacterService;
import com.gachashop.shop.service.IGenshinConstellationService;
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
    @Autowired
    private IGenshinConstellationService genshinConstellationService;

    @GetMapping("/{characterId}")
    public ResponseEntity<GenshinCharacter> getCharacterById(@PathVariable Long characterId) throws Exception {
        GenshinCharacter character = genshinCharacterService.getById(characterId);
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

    @PutMapping("/{characterId}")
    public ResponseEntity<GenshinCharacter> updateCharacter(@PathVariable Long characterId, @Valid @RequestBody GenshinCharacter character) throws Exception {
        GenshinCharacter updatedCharacter = genshinCharacterService.update(characterId, character);
        return new ResponseEntity<>(updatedCharacter, HttpStatus.OK);
    }

    @DeleteMapping("/{characterId}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long characterId) throws Exception {
        genshinCharacterService.delete(characterId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{characterId}/constellations")
    public ResponseEntity<List<GenshinConstellation>> getCharacterConstellation(@PathVariable Long characterId) {
        GenshinCharacter genshinCharacter = genshinCharacterService.getById(characterId);
        return new ResponseEntity<>(genshinCharacter.getConstellations(), HttpStatus.OK);
    }

    @PostMapping("/{characterId}/constellations")
    public ResponseEntity<GenshinConstellation> createCharacterConstellation(@PathVariable Long characterId, @Valid @RequestBody GenshinConstellation genshinConstellation) {
        GenshinConstellation createdGenshinConstellation = genshinConstellationService.create(characterId, genshinConstellation);
        return new ResponseEntity<>(createdGenshinConstellation, HttpStatus.OK);
    }

    @PutMapping("/{characterId}/constellations/{constellationId}")
    public ResponseEntity<GenshinConstellation> updateCharacterConstellation(@PathVariable Long characterId, @PathVariable Long constellationId, @Valid @RequestBody GenshinConstellation genshinConstellation) {
        GenshinConstellation updatedGenshinConstellation = genshinConstellationService.update(characterId, constellationId, genshinConstellation);
        return new ResponseEntity<>(updatedGenshinConstellation, HttpStatus.OK);
    }

    @DeleteMapping("/{characterId}/constellations/{constellationId}")
    public ResponseEntity<GenshinConstellation> deleteCharacterConstellation(@PathVariable Long characterId, @PathVariable Long constellationId) {
        genshinConstellationService.delete(characterId, constellationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{characterId}/remove-constellation/{constellationId}")
    public ResponseEntity<GenshinConstellation> removeCharacterConstellation(@PathVariable Long characterId, @PathVariable Long constellationId) {
        genshinCharacterService.removeConstellation(characterId, constellationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
