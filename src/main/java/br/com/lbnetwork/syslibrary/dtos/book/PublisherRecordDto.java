package br.com.lbnetwork.syslibrary.dtos.book;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PublisherRecordDto(@NotNull String name,
                                 String contact,
                                 Date createdAt,
                                 Date updatedAt) {
}
