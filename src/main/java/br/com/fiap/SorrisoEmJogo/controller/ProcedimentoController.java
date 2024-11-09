package br.com.fiap.SorrisoEmJogo.controller;

import br.com.fiap.SorrisoEmJogo.controller.dto.ProcedimentoDTO;
import br.com.fiap.SorrisoEmJogo.model.Procedimento;
import br.com.fiap.SorrisoEmJogo.service.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;

    @GetMapping
    public ResponseEntity<List<Procedimento>> getAllProcedimentos() {
        return ResponseEntity.ok(procedimentoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Procedimento> createProcedimento(@RequestBody ProcedimentoDTO procedimentoDTO) {
        Procedimento procedimento = new Procedimento();
        procedimento.setNome(procedimentoDTO.getNome());
        procedimento.setDescricao(procedimentoDTO.getDescricao());
        return ResponseEntity.ok(procedimentoService.save(procedimento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedimento> getProcedimentoById(@PathVariable Long id) {
        Procedimento procedimento = procedimentoService.findById(id);
        return procedimento != null ? ResponseEntity.ok(procedimento) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Procedimento> updateProcedimento(@PathVariable Long id, @RequestBody ProcedimentoDTO procedimentoDTO) {
        Procedimento existingProcedimento = procedimentoService.findById(id);
        if (existingProcedimento == null) {
            return ResponseEntity.notFound().build();
        }
        existingProcedimento.setNome(procedimentoDTO.getNome());
        existingProcedimento.setDescricao(procedimentoDTO.getDescricao());
        return ResponseEntity.ok(procedimentoService.save(existingProcedimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedimento(@PathVariable Long id) {
        procedimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
