package com.gachashop.shop.controller;

import com.gachashop.shop.model.GenshinWeapon;
import com.gachashop.shop.service.IGenshinWeaponService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weapons")
public class GenshinWeaponController {

    @Autowired
    private IGenshinWeaponService weaponService;

    @GetMapping("/{id}")
    public GenshinWeapon getWeaponById(@PathVariable long id) {
        return weaponService.getById(id);
    }

    @GetMapping("/")
    public List<GenshinWeapon> getAllWeapons() {
        return weaponService.getAll();
    }

    @PostMapping("/create")
    public GenshinWeapon createWeapon(@Valid @RequestBody GenshinWeapon weapon) {
        return weaponService.create(weapon);
    }

    @PutMapping("/{id}")
    public GenshinWeapon updateWeapon(@PathVariable long id, @Valid @RequestBody GenshinWeapon weapon) {
        return weaponService.update(id, weapon);
    }

    @DeleteMapping("/{id}")
    public void deleteWeapon(@PathVariable long id) {
        weaponService.delete(id);
    }
}
