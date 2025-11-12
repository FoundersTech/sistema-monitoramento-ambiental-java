package br.edu.monitoramento.java.repository;

import br.edu.monitoramento.java.model.DadosClimaticos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadosClimaticosRepository extends JpaRepository<DadosClimaticos, Integer> {
    /**
     * Encontra todos os registros de dados climáticos associados a um ID de empresa.
     * @param empresaId O ID da empresa.
     * @return Uma lista de dados climáticos.
     */
    List<DadosClimaticos> findByEmpresaId(Integer empresaId);
}
