package br.com.fiap.SorrisoEmJogo.service;

import br.com.fiap.SorrisoEmJogo.model.Unidade;
import br.com.fiap.SorrisoEmJogo.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    @Autowired
    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public List<Unidade> findAll() {
        return unidadeRepository.findAll();
    }

    public Unidade findById(Long id) {
        return unidadeRepository.findById(id).orElse(null);
    }

    public Unidade save(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public void delete(Long id) {
        unidadeRepository.deleteById(id);
    }
}
