package br.com.lbnetwork.syslibrary.dtos.book;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record LanguageRecordDto(@NotNull String name,
                                Date createdAt,
                                Date updatedAt) {
}
