package com.gachashop.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Table(name = "games", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Image URL cannot be blank")
    private String imageUrl;
}
