package br.com.fiap.SorrisoEmJogo.repository;

import br.com.fiap.SorrisoEmJogo.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}
