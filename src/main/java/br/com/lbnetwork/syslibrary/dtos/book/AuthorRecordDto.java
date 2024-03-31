package br.com.lbnetwork.syslibrary.dtos.book;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AuthorRecordDto(@NotNull String fullName,
                              @NotNull Date createdAt,
                              Date updatedAt) {
}
