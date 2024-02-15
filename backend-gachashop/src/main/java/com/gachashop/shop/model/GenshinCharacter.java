package com.gachashop.shop.model;


import com.gachashop.shop.datatype.EGenshinElement;
import com.gachashop.shop.datatype.EGenshinWeapon;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Entity
@Table(name = "genshin_character")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GenshinCharacter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "elemental", nullable = false)
    private EGenshinElement element;

    @Column(name = "weapon", nullable = false)
    private EGenshinWeapon weapon;

    @Column(name = "star", nullable = false)
    private int star;

}
