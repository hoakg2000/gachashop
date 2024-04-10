package com.gachashop.shop.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginRequestDTO {
    @NotNull
    @Size(min = 5, max = 15)
    private String username;

    @NotNull
    private String password;
}
