package com.gachashop.shop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "genshin_account")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GenshinAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adventure_rank", nullable = false)
    private int ar;

    @Column(name = "price", nullable = false)
    private int price;

    @OneToMany(mappedBy = "genshinAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GenshinCharacterDetail> characters;

    @OneToMany(mappedBy = "genshinAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GenshinWeaponDetail> weapons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
