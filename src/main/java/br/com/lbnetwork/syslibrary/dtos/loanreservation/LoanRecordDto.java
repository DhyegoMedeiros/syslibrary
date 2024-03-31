package br.com.lbnetwork.syslibrary.dtos.loanreservation;

import br.com.lbnetwork.syslibrary.models.book.BookModel;
import br.com.lbnetwork.syslibrary.models.user.UserModel;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record LoanRecordDto(@NotNull BookModel bookId,
                            @NotNull UserModel userId,
                            @NotNull Date loanDate,
                            @NotNull Date returnDate,
                            @NotNull Date createdAt,
                            Date updatedAt) {
}
