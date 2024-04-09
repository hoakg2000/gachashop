package com.gachashop.shop.model;


import com.gachashop.shop.datatype.EGenshinElement;
import com.gachashop.shop.datatype.EGenshinWeapon;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;


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

    @NotNull
    @Size(min = 4, max = 128)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "elemental", nullable = false)
    private EGenshinElement element;

    @NotNull
    @Column(name = "weapon", nullable = false)
    private EGenshinWeapon weapon;

    @NotNull
    @Size(min = 4, max = 5)
    @Column(name = "star", nullable = false)
    private int star;

    @Valid

    @Size(min = 0, max = 6)
    @OneToMany(mappedBy = "genshinCharacter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GenshinConstellation> constellations;

}
