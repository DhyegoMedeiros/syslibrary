package br.com.lbnetwork.syslibrary.dtos.user;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RoleRecordDto(@NotNull String role,
                            @NotNull Date createdAt,
                            Date updatedAt) {
}
