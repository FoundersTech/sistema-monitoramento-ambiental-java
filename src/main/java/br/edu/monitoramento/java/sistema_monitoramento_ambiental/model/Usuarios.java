package br.edu.monitoramento.java.sistema_monitoramento_ambiental.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "usuario")
    private Empresas empresa;

    private String nomeUsuario;
    private String emailUsuario;
    private Date criadoEm;
    private Date atualizadoEm;
}

