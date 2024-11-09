package br.com.fiap.SorrisoEmJogo.controller;

import br.com.fiap.SorrisoEmJogo.controller.dto.RegistroHabitoDTO;
import br.com.fiap.SorrisoEmJogo.model.Habito;
import br.com.fiap.SorrisoEmJogo.model.RegistroHabito;
import br.com.fiap.SorrisoEmJogo.model.Usuario;
import br.com.fiap.SorrisoEmJogo.service.RegistroHabitoService;
import br.com.fiap.SorrisoEmJogo.service.UsuarioService; // Importando o serviço de Usuário
import br.com.fiap.SorrisoEmJogo.service.HabitoService; // Importando o serviço de Hábito
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/registro-habitos")
public class RegistroHabitoController {

    @Autowired
    private RegistroHabitoService registroHabitoService;

    @Autowired
    private UsuarioService usuarioService; // Injetando o serviço de Usuário

    @Autowired
    private HabitoService habitoService; // Injetando o serviço de Hábito

    @GetMapping
    public ResponseEntity<List<RegistroHabito>> getAllRegistros() {
        return ResponseEntity.ok(registroHabitoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroHabito> getRegistroById(@PathVariable Long id) {
        return ResponseEntity.ok(registroHabitoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RegistroHabito> createRegistro(@Valid @RequestBody RegistroHabitoDTO registroHabitoDTO) {
        RegistroHabito registroHabito = new RegistroHabito();
        registroHabito.setData(registroHabitoDTO.getData());
        registroHabito.setImagem(registroHabitoDTO.getImagem());
        registroHabito.setObservacoes(registroHabitoDTO.getObservacoes());

        // Buscando usuário e hábito com base nos IDs fornecidos
        Usuario usuario = usuarioService.getUsuarioById(registroHabitoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Habito habito = habitoService.getHabitoById(registroHabitoDTO.getHabitoId())
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

        // Definindo o usuário e o hábito no registro
        registroHabito.setUsuario(usuario);
        registroHabito.setHabito(habito);

        // Salvando o registro de hábito
        RegistroHabito savedRegistro = registroHabitoService.save(registroHabito);
        return ResponseEntity.ok(savedRegistro);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RegistroHabito> updateRegistro(@PathVariable Long id, @Valid @RequestBody RegistroHabitoDTO registroHabitoDTO) {
        RegistroHabito existingRegistro = registroHabitoService.findById(id);
        existingRegistro.setData(registroHabitoDTO.getData());
        existingRegistro.setImagem(registroHabitoDTO.getImagem());
        existingRegistro.setObservacoes(registroHabitoDTO.getObservacoes());
        return ResponseEntity.ok(registroHabitoService.save(existingRegistro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistro(@PathVariable Long id) {
        registroHabitoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
