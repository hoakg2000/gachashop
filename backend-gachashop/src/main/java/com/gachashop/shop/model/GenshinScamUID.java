package com.gachashop.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Entity
@Table(name = "genshin_scam_uid")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GenshinScamUID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 9, max = 9, message = "UID must be exactly 9 characters long")
    @Column(name = "uid", nullable = false, unique = true)
    private String uid;
}
