package br.edu.monitoramento.java.controllers;

import br.edu.monitoramento.java.dto.SensorDTO;
import br.edu.monitoramento.java.model.Sensor;
import br.edu.monitoramento.java.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<Sensor> cadastrarSensor(@RequestBody SensorDTO sensorDTO) {
        Sensor novoSensor = sensorService.criarSensor(sensorDTO);
        return new ResponseEntity<>(novoSensor, HttpStatus.CREATED);
    }
}
