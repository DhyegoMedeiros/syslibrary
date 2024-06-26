package br.com.lbnetwork.syslibrary.repositories.book;

import br.com.lbnetwork.syslibrary.models.book.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
    Optional<CategoryModel> findByName(String Name);
}
