package com.gachashop.shop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "genshin_weapon_detail")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GenshinWeaponDetail {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genshin_weapon_id", referencedColumnName = "id", nullable = false, unique = true)
    private GenshinWeapon genshinWeapon;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genshin_account_id", nullable = false)
    private GenshinAccount genshinAccount;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "refinement_level", nullable = false)
    private int refinementLevel;

}
