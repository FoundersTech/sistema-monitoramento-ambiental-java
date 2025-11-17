package br.edu.monitoramento.java.service;

import br.edu.monitoramento.java.dto.DadosClimaticosDTO;
import br.edu.monitoramento.java.model.DadosClimaticos;
import br.edu.monitoramento.java.model.Empresas;
import br.edu.monitoramento.java.model.Sensor;
import br.edu.monitoramento.java.repository.DadosClimaticosRepository;
import br.edu.monitoramento.java.repository.EmpresasRepository;
import br.edu.monitoramento.java.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DadosClimaticosService {

    @Autowired
    private DadosClimaticosRepository dadosClimaticosRepository;

    @Autowired
    private EmpresasRepository empresasRepository;

    @Autowired
    private SensorRepository sensorRepository;

    /**
     * Retorna todos os dados climáticos do banco de dados.
     * @return Lista de todos os dados climáticos.
     */
    public List<DadosClimaticos> listarTodos() {
        return dadosClimaticosRepository.findAll();
    }

    /**
     * Retorna todos os dados climáticos de uma empresa específica.
     * @param empresaId O ID da empresa.
     * @return Lista de dados climáticos da empresa.
     */
    public List<DadosClimaticos> listarPorEmpresa(Integer empresaId) {
        return dadosClimaticosRepository.findByEmpresaId(empresaId);
    }

    public DadosClimaticos salvarDTO(DadosClimaticosDTO dto) {
        DadosClimaticos dados = new DadosClimaticos();

        Empresas empresa = empresasRepository.getReferenceById(dto.getEmpresaId());
        dados.setEmpresa(empresa);

        Sensor sensor = sensorRepository.getReferenceById(dto.getSensorId());
        dados.setSensor(sensor);
        dados.setLocalColeta(sensor.getEndereco());

        dados.setTemperatura(dto.getTemperatura().floatValue());
        dados.setUmidade(dto.getUmidade().floatValue());
        dados.setPeriodoColeta(dto.getPeriodoColeta().toString());
        dados.setLocalizacao(dto.getLocalizacao());
        dados.setCriadoEm(new Date());

        return dadosClimaticosRepository.save(dados);
    }
}
