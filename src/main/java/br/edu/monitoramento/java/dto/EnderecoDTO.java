package br.edu.monitoramento.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
    private String numero;
    private String complemento;
    private String bairro;
}
