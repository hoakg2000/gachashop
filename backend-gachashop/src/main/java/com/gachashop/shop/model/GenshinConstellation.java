package com.gachashop.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "genshin_constellation")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GenshinConstellation {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    private GenshinCharacter genshinCharacter;

    @NotNull
    @Size(min = 3, max = 128)
    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;

}
