package br.com.fiap.SorrisoEmJogo.controller;

import br.com.fiap.SorrisoEmJogo.controller.dto.HabitoDTO;
import br.com.fiap.SorrisoEmJogo.model.Habito;
import br.com.fiap.SorrisoEmJogo.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitos")
public class HabitoController {

    @Autowired
    private HabitoService habitoService;

    @GetMapping
    public ResponseEntity<List<Habito>> getAllHabitos() {
        return ResponseEntity.ok(habitoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habito> getHabitoById(@PathVariable Long id) {
        return ResponseEntity.ok(habitoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Habito> createHabito(@RequestBody HabitoDTO habitoDTO) {
        Habito habito = new Habito();
        habito.setDescricao(habitoDTO.getDescricao());
        habito.setTipo(habitoDTO.getTipo());
        habito.setFrequenciaIdeal(habitoDTO.getFrequenciaIdeal());
        return ResponseEntity.ok(habitoService.save(habito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habito> updateHabito(@PathVariable Long id, @RequestBody HabitoDTO habitoDTO) {
        Habito existingHabito = habitoService.findById(id);
        existingHabito.setDescricao(habitoDTO.getDescricao());
        existingHabito.setTipo(habitoDTO.getTipo());
        existingHabito.setFrequenciaIdeal(habitoDTO.getFrequenciaIdeal());
        return ResponseEntity.ok(habitoService.save(existingHabito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabito(@PathVariable Long id) {
        habitoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
