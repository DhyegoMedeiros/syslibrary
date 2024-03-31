package br.com.lbnetwork.syslibrary.repositories.book;

import br.com.lbnetwork.syslibrary.models.book.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
