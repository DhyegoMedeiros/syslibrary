package br.com.lbnetwork.syslibrary.dtos.user;

import br.com.lbnetwork.syslibrary.models.user.RoleModel;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record UserRecordDto(@NotNull String username,
                            @NotNull String password,
                            @NotNull RoleModel role,
                            @NotNull String name,
                            @NotNull String address,
                            @NotNull String email,
                            @NotNull String phone,
                            @NotNull Date createdAt,
                            Date updatedAt) {
}
