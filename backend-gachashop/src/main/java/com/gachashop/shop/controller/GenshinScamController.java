package com.gachashop.shop.controller;

import com.gachashop.shop.model.GenshinScamUID;
import com.gachashop.shop.service.IGenshinScamUIDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/GenshinScamUID")
public class GenshinScamController {

    @Autowired
    private IGenshinScamUIDService scamService;

    @GetMapping("/{id}")
    public GenshinScamUID getScamById(@PathVariable long id) {
        return scamService.getById(id);
    }

    @GetMapping("/")
    public List<GenshinScamUID> getAllScams() {
        return scamService.getAll();
    }

    @PostMapping("/create")
    public GenshinScamUID createScam(@Valid @RequestBody GenshinScamUID genshinScamUID) {
        return scamService.create(genshinScamUID);
    }

    @PutMapping("/{id}")
    public GenshinScamUID updateScam(@PathVariable long id, @Valid @RequestBody GenshinScamUID genshinScamUID) {
        return scamService.update(id, genshinScamUID);
    }

    @DeleteMapping("/{id}")
    public void deleteScam(@PathVariable long id) {
        scamService.delete(id);
    }

    @GetMapping("/uid/{uid}")
    public GenshinScamUID getScamByUid(@PathVariable String uid) {
        return scamService.findByUid(uid);
    }
}
