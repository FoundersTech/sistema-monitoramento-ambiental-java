package br.edu.monitoramento.java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "endereco")
    @JsonBackReference
    public Empresas empresa;

    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("sensor-endereco")
    private List<Sensor> sensores;

    public String rua;
    public String cidade;
    public String estado;
    public String cep;
    public String pais;
    public String numero;
    public String complemento;
    public String bairro;
    public Date criadoEm;
    public Date atualizadoEm;
}
