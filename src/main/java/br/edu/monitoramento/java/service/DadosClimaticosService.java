package br.edu.monitoramento.java.service;

import br.edu.monitoramento.java.model.DadosClimaticos;
import br.edu.monitoramento.java.repository.DadosClimaticosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosClimaticosService {

    @Autowired
    private DadosClimaticosRepository dadosClimaticosRepository;

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
}
