package com.gachashop.shop.controller;

import com.gachashop.shop.model.Scammer;
import com.gachashop.shop.service.IScammerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scammers")
public class ScammerController {

    @Autowired
    private IScammerService scammerService;

    @GetMapping("/{id}")
    public Scammer getScammerById(@PathVariable long id) {
        return scammerService.getById(id);
    }

    @GetMapping("/all")
    public List<Scammer> getAllScammers() {
        return scammerService.getAll();
    }

    @PostMapping("/create")
    public Scammer createScammer(@Valid @RequestBody Scammer scammer) {
        return scammerService.create(scammer);
    }

    @PutMapping("/{id}")
    public Scammer updateScammer(@PathVariable long id, @Valid @RequestBody Scammer scammer) {
        return scammerService.update(id, scammer);
    }

    @DeleteMapping("/{id}")
    public void deleteScammer(@PathVariable long id) {
        scammerService.delete(id);
    }
}
