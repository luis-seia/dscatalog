package com.seiadev.dscatalog.dto;

import com.seiadev.dscatalog.entities.Role;

public class RoleDTO {
    private Long id;
    private String authority;

    public RoleDTO() {}

    public RoleDTO(Role entity) {
        this.id = entity.getId();
        this.authority = entity.getAuthority();
    }

    public RoleDTO(String authority, Long id) {
        this.authority = authority;
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
