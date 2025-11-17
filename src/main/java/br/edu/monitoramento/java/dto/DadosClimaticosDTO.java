package br.edu.monitoramento.java.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DadosClimaticosDTO {
    private Integer empresaId;
    private Integer sensorId;
    private String localizacao;
    private Double temperatura;
    private Double umidade;
    private String periodoColeta;
}
