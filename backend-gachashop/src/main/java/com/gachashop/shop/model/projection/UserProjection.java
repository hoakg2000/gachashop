package com.gachashop.shop.model.projection;

import com.gachashop.shop.datatype.UserRole;

public interface UserProjection {

    Long getId();

    String getUsername();

    String getPassword();

    Boolean getActive();

    UserRole getRole();

    String getEmail();
}
