package com.gachashop.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Table(name = "genshin_character_detail")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GenshinCharacterDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genshin_character_id", referencedColumnName = "id", nullable = false, unique = true)
    private GenshinCharacter genshinCharacter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genshin_account_id", nullable = false)
    private GenshinAccount genshinAccount;

    @Min(1)
    @Max(90)
    @Column(name = "level", nullable = false)
    private int level;

    @Min(1)
    @Max(10)
    @Column(name = "normal_atk_level", nullable = false)
    private int atkLevel;

    @Min(1)
    @Max(10)
    @Column(name = "elemental_skill_level", nullable = false)
    private int eSkillLevel;

    @Min(1)
    @Max(10)
    @Column(name = "elemental_brust_level", nullable = false)
    private int eBrustLevel;

    @Min(0)
    @Max(6)
    @Column(name = "constellation_status", nullable = false)
    private int constellationStatus;
}
