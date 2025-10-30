package br.edu.monitoramento.java.model;

import br.edu.monitoramento.java.shared.Enums.TipoEmpresa;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "empresa")
    private List<DadosClimaticos> dadosClimaticos;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @Column(length = 18, unique = true, nullable = false)
    public String cnpjEmpresa;

    public String nomeEmpresa;
    public TipoEmpresa tipoEmpresa = TipoEmpresa.OUTROS;
    public String areaAtuacaoEmpresa;
    public String nomeResponsavelEmpresa;
    public String cargoResponsavelEmpresa;
    public String cpfResponsavelEmpresa;
    public String emailResponsavelEmpresa;
    public String telefoneResponsavelEmpresa;
    public Date criadoEm;
    public Date atualizadoEm;
}
