package com.gachashop.shop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Entity
@Table(name = "scammer")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Scammer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "game_scam")
    private String gameScam;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;
}
