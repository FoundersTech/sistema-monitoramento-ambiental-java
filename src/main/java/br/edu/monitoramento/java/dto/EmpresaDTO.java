package br.edu.monitoramento.java.dto;

import br.edu.monitoramento.java.shared.Enums.TipoEmpresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
    private String cnpjEmpresa;
    private String nomeEmpresa;
    private TipoEmpresa tipoEmpresa;
    private String areaAtuacaoEmpresa;
    private String nomeResponsavelEmpresa;
    private String cargoResponsavelEmpresa;
    private String cpfResponsavelEmpresa;
    private String emailResponsavelEmpresa;
    private String telefoneResponsavelEmpresa;
    private EnderecoDTO endereco;
}

