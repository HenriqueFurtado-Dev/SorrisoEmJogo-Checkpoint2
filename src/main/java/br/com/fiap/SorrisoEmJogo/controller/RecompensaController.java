package br.com.fiap.SorrisoEmJogo.controller;

import br.com.fiap.SorrisoEmJogo.controller.dto.RecompensaDTO;
import br.com.fiap.SorrisoEmJogo.model.Recompensa;
import br.com.fiap.SorrisoEmJogo.service.RecompensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recompensas")
public class RecompensaController {

    private final RecompensaService recompensaService;

    @Autowired
    public RecompensaController(RecompensaService recompensaService) {
        this.recompensaService = recompensaService;
    }

    // Obtém todas as recompensas
    @GetMapping
    public ResponseEntity<List<Recompensa>> getAllRecompensas() {
        // Obtém todas as recompensas
        return ResponseEntity.ok(recompensaService.getAllRecompensas());
    }

    // Obtém uma recompensa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Recompensa> getRecompensaById(@PathVariable Long id) {
        Recompensa recompensa = recompensaService.getRecompensaById(id);
        return recompensa != null ? ResponseEntity.ok(recompensa) : ResponseEntity.notFound().build();
    }

    // Cria uma nova recompensa
    @PostMapping
    public ResponseEntity<String> createRecompensa(@RequestBody RecompensaDTO recompensaDTO) {
        try {
            recompensaService.inserirRecompensa(recompensaDTO);  // Chama o serviço para inserir a recompensa
            return ResponseEntity.ok("Recompensa criada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro: " + e.getMessage());
        }
    }

    // Atualiza uma recompensa existente
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRecompensa(@PathVariable Long id, @RequestBody RecompensaDTO recompensaDTO) {
        try {
            recompensaService.atualizarRecompensa(id, recompensaDTO);  // Chama o serviço para atualizar a recompensa
            return ResponseEntity.ok("Recompensa atualizada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro: " + e.getMessage());
        }
    }

    // Exclui uma recompensa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecompensa(@PathVariable Long id) {
        try {
            recompensaService.excluirRecompensa(id);  // Chama o serviço para excluir a recompensa
            return ResponseEntity.ok("Recompensa excluída com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro: " + e.getMessage());
        }
    }
}
