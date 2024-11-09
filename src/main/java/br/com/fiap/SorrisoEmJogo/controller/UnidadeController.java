package br.com.fiap.SorrisoEmJogo.controller;

import br.com.fiap.SorrisoEmJogo.controller.dto.UnidadeDTO;
import br.com.fiap.SorrisoEmJogo.model.Unidade;
import br.com.fiap.SorrisoEmJogo.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<List<Unidade>> getAllUnidades() {
        return ResponseEntity.ok(unidadeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Unidade> createUnidade(@Valid @RequestBody UnidadeDTO unidadeDTO) {
        Unidade unidade = new Unidade();
        unidade.setNome(unidadeDTO.getNome());
        unidade.setEstado(unidadeDTO.getEstado());
        unidade.setCidade(unidadeDTO.getCidade());
        unidade.setEndereco(unidadeDTO.getEndereco());
        return ResponseEntity.ok(unidadeService.save(unidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> getUnidadeById(@PathVariable Long id) {
        Unidade unidade = unidadeService.findById(id);
        return unidade != null ? ResponseEntity.ok(unidade) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> updateUnidade(@PathVariable Long id, @Valid @RequestBody UnidadeDTO unidadeDTO) {
        Unidade existingUnidade = unidadeService.findById(id);
        if (existingUnidade == null) {
            return ResponseEntity.notFound().build();
        }
        existingUnidade.setNome(unidadeDTO.getNome());
        existingUnidade.setEstado(unidadeDTO.getEstado());
        existingUnidade.setCidade(unidadeDTO.getCidade());
        existingUnidade.setEndereco(unidadeDTO.getEndereco());
        return ResponseEntity.ok(unidadeService.save(existingUnidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidade(@PathVariable Long id) {
        unidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
