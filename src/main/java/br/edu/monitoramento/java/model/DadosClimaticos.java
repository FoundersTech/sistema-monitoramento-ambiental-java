package br.edu.monitoramento.java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dados_climaticos")
public class DadosClimaticos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    @JsonBackReference("empresa-dados")
    public Empresas empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    @JsonBackReference("sensor-dados")
    private Sensor sensor;

    public String localizacao;
    public float temperatura;
    public float umidade;
    public String periodoColeta;
    public String localColeta;
    public Date criadoEm;
}
