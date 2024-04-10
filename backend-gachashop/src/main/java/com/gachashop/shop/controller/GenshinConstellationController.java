package com.gachashop.shop.controller;

import com.gachashop.shop.model.GenshinConstellation;
import com.gachashop.shop.service.IGenshinConstellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genshin-constellations")
public class GenshinConstellationController {

    @Autowired
    private IGenshinConstellationService genshinConstellationService;


    @GetMapping("/")
    public ResponseEntity<List<GenshinConstellation>> getCharacterConstellation() {
        List<GenshinConstellation> genshinConstellationList = genshinConstellationService.getAll();
        return new ResponseEntity<>(genshinConstellationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenshinConstellation> getCharacterConstellation(@PathVariable Long id) {
        GenshinConstellation genshinConstellation = genshinConstellationService.getById(id);
        return new ResponseEntity<>(genshinConstellation, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<GenshinConstellation> createCharacterConstellation(@PathVariable Long id) {
        genshinConstellationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
