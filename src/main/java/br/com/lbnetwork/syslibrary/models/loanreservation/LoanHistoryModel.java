package br.com.lbnetwork.syslibrary.models.loanreservation;

import br.com.lbnetwork.syslibrary.models.book.BookModel;
import br.com.lbnetwork.syslibrary.models.user.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "loan_history")
public class LoanHistoryModel extends RepresentationModel<LoanHistoryModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "loan_history_id_pk")
    private UUID idLoanHistory;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id_fk", nullable = false)
    private BookModel bookId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_fk", nullable = false)
    private UserModel userId;

    @NotNull
    @Column(name = "loan_date")
    private Date loanDate;

    @NotNull
    @Column(name = "return_date")
    private Date returnDate;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public UUID getIdLoanHistory() {
        return idLoanHistory;
    }

    public void setIdLoanHistory(UUID idLoanHistory) {
        this.idLoanHistory = idLoanHistory;
    }

    public BookModel getBookId() {
        return bookId;
    }

    public void setBookId(BookModel bookId) {
        this.bookId = bookId;
    }

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
