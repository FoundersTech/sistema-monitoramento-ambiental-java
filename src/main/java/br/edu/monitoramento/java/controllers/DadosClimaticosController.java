package br.edu.monitoramento.java.controllers;

import br.edu.monitoramento.java.dto.DadosClimaticosDTO;
import br.edu.monitoramento.java.model.DadosClimaticos;
import br.edu.monitoramento.java.service.DadosClimaticosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/dados-climaticos")
public class DadosClimaticosController {

    @Autowired
    private DadosClimaticosService dadosClimaticosService;

    @GetMapping
    public ResponseEntity<List<DadosClimaticos>> obterTodosOsDados() {
        List<DadosClimaticos> dados = dadosClimaticosService.listarTodos();
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<DadosClimaticos>> obterDadosPorEmpresa(@PathVariable Integer empresaId) {
        List<DadosClimaticos> dados = dadosClimaticosService.listarPorEmpresa(empresaId);
        if (dados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dados);
    }

    @PostMapping
    public ResponseEntity<DadosClimaticos> criar(@RequestBody DadosClimaticosDTO dto, UriComponentsBuilder uriBuilder) {
        DadosClimaticos salvo = dadosClimaticosService.salvarDTO(dto);
        return ResponseEntity
                .created(uriBuilder.path("/dados-climaticos/{id}")
                        .buildAndExpand(salvo.getId()).toUri())
                .body(salvo);
    }
}
