package br.edu.monitoramento.java.sistema_monitoramento_ambiental.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "endereco")
    public Empresas empresa;

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
