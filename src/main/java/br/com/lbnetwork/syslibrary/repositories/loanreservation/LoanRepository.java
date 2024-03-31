package br.com.lbnetwork.syslibrary.repositories.loanreservation;

import br.com.lbnetwork.syslibrary.models.loanreservation.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LoanRepository extends JpaRepository<LoanModel, UUID> {
}
