package br.edu.monitoramento.java.sistema_monitoramento_ambiental.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dados_climaticos")
public class DadosClimaticos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    public Empresas empresa;

    public String localizacao;
    public float temperatura;
    public float umidade;
    public String periodoColeta;
    public String localColeta;
    public Date criadoEm;
}
