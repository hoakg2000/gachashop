package com.gachashop.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name = "game_scam")
    @NotBlank(message = "Game scam is required")
    private String gameScam;

    @Column(name = "facebook")
    @Pattern(regexp = "^(https?://)?(www\\.)?(facebook\\.com|fb\\.com)/.*$", message = "Invalid Facebook link")
    private String facebook;

    @Column(name = "phone_number")
    @Size(min = 9, message = "Phone number must be at least 9 characters long")
    private String phoneNumber;

    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;
}
