package br.com.lbnetwork.syslibrary.repositories.book;

import br.com.lbnetwork.syslibrary.models.book.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID> {
}
