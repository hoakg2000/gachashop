package com.gachashop.shop.model;

import com.gachashop.shop.datatype.EGenshinWeapon;
import jakarta.persistence.*;
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

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "weapon_type", nullable = false)
    private EGenshinWeapon weaponType;

    @Column(name = "star", nullable = false)
    private int star;

    @Column(name = "passive", columnDefinition = "TEXT")
    private String passive;
}
