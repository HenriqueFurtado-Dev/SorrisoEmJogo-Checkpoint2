package br.com.fiap.SorrisoEmJogo.repository;

import br.com.fiap.SorrisoEmJogo.model.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {
}
