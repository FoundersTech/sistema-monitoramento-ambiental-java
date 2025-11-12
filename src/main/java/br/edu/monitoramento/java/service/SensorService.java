package br.edu.monitoramento.java.service;

import br.edu.monitoramento.java.dto.SensorDTO;
import br.edu.monitoramento.java.model.Endereco;
import br.edu.monitoramento.java.model.Sensor;
import br.edu.monitoramento.java.model.Usuarios;
import br.edu.monitoramento.java.repository.EnderecoRepository;
import br.edu.monitoramento.java.repository.SensorRepository;
import br.edu.monitoramento.java.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Transactional
    public Sensor criarSensor(SensorDTO sensorDTO) {
        Endereco endereco = enderecoRepository.findById(sensorDTO.getEnderecoId())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado com id: " + sensorDTO.getEnderecoId()));

        Usuarios usuario = usuariosRepository.findById(sensorDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + sensorDTO.getUsuarioId()));

        Sensor sensor = new Sensor();
        sensor.setModelo(sensorDTO.getModelo());
        sensor.setEndereco(endereco);
        sensor.setUsuario(usuario);

        return sensorRepository.save(sensor);
    }
}
