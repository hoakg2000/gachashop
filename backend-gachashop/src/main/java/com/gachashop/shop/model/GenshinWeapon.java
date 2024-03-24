package com.gachashop.shop.model;

import com.gachashop.shop.datatype.EGenshinWeapon;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Table(name = "genshin_weapon")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GenshinWeapon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Image URL cannot be blank")
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @NotNull(message = "Weapon type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "weapon_type", nullable = false)
    private EGenshinWeapon weaponType;

    @Min(value = 4, message = "Star must be at least 4")
    @Max(value = 5, message = "Star must be at most 5")
    @Column(name = "star", nullable = false)
    private int star;

    @Column(name = "passive", columnDefinition = "TEXT")
    private String passive;
}
