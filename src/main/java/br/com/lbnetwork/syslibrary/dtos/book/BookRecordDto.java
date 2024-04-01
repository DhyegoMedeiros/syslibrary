package br.com.lbnetwork.syslibrary.dtos.book;

import br.com.lbnetwork.syslibrary.models.book.AuthorModel;
import br.com.lbnetwork.syslibrary.models.book.CategoryModel;
import br.com.lbnetwork.syslibrary.models.book.LanguageModel;
import br.com.lbnetwork.syslibrary.models.book.PublisherModel;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record BookRecordDto(@NotNull String title,
                            @NotNull AuthorModel author,
                            @NotNull CategoryModel category,
                            @NotNull LanguageModel language,
                            @NotNull PublisherModel publisher,
                            @NotNull Integer publicationYear,
                            @NotNull Integer numberOfPages,
                            String summary,
                            @NotNull String isbn,
                            Integer copy,
                            Date createdAt,
                            Date updatedAt) {
}
