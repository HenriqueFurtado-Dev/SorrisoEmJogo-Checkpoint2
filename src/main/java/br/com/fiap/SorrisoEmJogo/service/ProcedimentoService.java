package br.com.fiap.SorrisoEmJogo.service;

import br.com.fiap.SorrisoEmJogo.model.Procedimento;
import br.com.fiap.SorrisoEmJogo.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentoService {

    private final ProcedimentoRepository procedimentoRepository;

    @Autowired
    public ProcedimentoService(ProcedimentoRepository procedimentoRepository) {
        this.procedimentoRepository = procedimentoRepository;
    }

    public List<Procedimento> findAll() {
        return procedimentoRepository.findAll();
    }

    public Procedimento findById(Long id) {
        return procedimentoRepository.findById(id).orElse(null);
    }

    public Procedimento save(Procedimento procedimento) {
        return procedimentoRepository.save(procedimento);
    }

    public void delete(Long id) {
        procedimentoRepository.deleteById(id);
    }
}
