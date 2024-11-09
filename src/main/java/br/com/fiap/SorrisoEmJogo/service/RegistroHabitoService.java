package br.com.fiap.SorrisoEmJogo.service;

import br.com.fiap.SorrisoEmJogo.model.RegistroHabito;
import br.com.fiap.SorrisoEmJogo.repository.RegistroHabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroHabitoService {

    @Autowired
    private RegistroHabitoRepository registroHabitoRepository;

    @Autowired
    private UsuarioService usuarioService; // Certifique-se de ter este serviço

    @Autowired
    private HabitoService habitoService; // Certifique-se de ter este serviço

    public List<RegistroHabito> findAll() {
        return registroHabitoRepository.findAll();
    }

    public RegistroHabito findById(Long id) {
        return registroHabitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de hábito não encontrado"));
    }

    public RegistroHabito save(RegistroHabito registroHabito) {
        return registroHabitoRepository.save(registroHabito);
    }

    public void delete(Long id) {
        registroHabitoRepository.deleteById(id);
    }
}
