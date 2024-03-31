package br.com.lbnetwork.syslibrary.repositories.user;

import br.com.lbnetwork.syslibrary.models.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
