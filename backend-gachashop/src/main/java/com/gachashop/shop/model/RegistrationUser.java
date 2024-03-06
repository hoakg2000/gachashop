package com.gachashop.shop.model;


import com.gachashop.shop.datatype.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@Table(name = "registration_user")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RegistrationUser {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(6)
    @Max(12)
    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "facebook", nullable = false)
    private String facebook;

    @Column(name = "preference", nullable = false)
    private String preference;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.PENDING;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        updatedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }

}
