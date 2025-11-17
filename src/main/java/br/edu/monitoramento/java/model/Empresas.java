package br.edu.monitoramento.java.model;

import br.edu.monitoramento.java.shared.Enums.TipoEmpresa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresas")
public class Empresas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    @JsonManagedReference
    private Endereco endereco;

    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<DadosClimaticos> dadosClimaticos;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonBackReference("empresa-usuarios")
    private List<Usuarios> usuarios;

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
