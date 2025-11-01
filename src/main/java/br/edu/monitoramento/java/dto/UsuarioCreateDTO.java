package br.edu.monitoramento.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateDTO {
    private String nomeUsuario;
    private String emailUsuario;
    private EmpresaDTO empresa;
}

