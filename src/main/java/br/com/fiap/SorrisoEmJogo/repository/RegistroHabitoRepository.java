package br.com.fiap.SorrisoEmJogo.repository;

import br.com.fiap.SorrisoEmJogo.model.RegistroHabito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroHabitoRepository extends JpaRepository<RegistroHabito, Long> {
}
