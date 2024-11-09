package br.com.fiap.SorrisoEmJogo.service;

import br.com.fiap.SorrisoEmJogo.model.Habito;
import br.com.fiap.SorrisoEmJogo.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitoService {

    @Autowired
    private HabitoRepository habitoRepository;

    public List<Habito> findAll() {
        return habitoRepository.findAll();
    }

    // Método para buscar um Hábito por ID, retornando um Optional
    public Optional<Habito> getHabitoById(Long id) {
        return habitoRepository.findById(id);
    }

    public Habito findById(Long id) {
        return habitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));
    }

    public Habito save(Habito habito) {
        return habitoRepository.save(habito);
    }

    public void delete(Long id) {
        habitoRepository.deleteById(id);
    }
}
