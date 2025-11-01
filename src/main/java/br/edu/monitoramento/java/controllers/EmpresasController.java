package br.edu.monitoramento.java.controllers;

import br.edu.monitoramento.java.dto.EmpresaDTO;
import br.edu.monitoramento.java.model.Empresas;
import br.edu.monitoramento.java.service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

    private final EmpresasService empresasService;

    @Autowired
    public EmpresasController(EmpresasService empresasService) {
        this.empresasService = empresasService;
    }

    @PostMapping
    public ResponseEntity<Empresas> createEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        Empresas novaEmpresa = empresasService.createEmpresa(empresaDTO);
        return ResponseEntity.ok(novaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresas> updateEmpresa(@PathVariable Integer id, @RequestBody EmpresaDTO empresaDTO) {
        Empresas empresaAtualizada = empresasService.updateEmpresa(id, empresaDTO);
        return ResponseEntity.ok(empresaAtualizada);
    }
}

