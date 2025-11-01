package br.edu.monitoramento.java.service;

import br.edu.monitoramento.java.dto.EmpresaDTO;
import br.edu.monitoramento.java.model.Empresas;
import br.edu.monitoramento.java.model.Endereco;
import br.edu.monitoramento.java.repository.EmpresasRepository;
import br.edu.monitoramento.java.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class EmpresasService {
    private final EmpresasRepository empresasRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EmpresasService(EmpresasRepository empresasRepository, EnderecoRepository enderecoRepository) {
        this.empresasRepository = empresasRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public Empresas createEmpresa(EmpresaDTO empresaDTO) {
        if (empresasRepository.findByCnpjEmpresa(empresaDTO.getCnpjEmpresa()).isPresent()) {
            throw new RuntimeException("Empresa com este CNPJ já existe.");
        }

        Endereco endereco = new Endereco();
        endereco.setRua(empresaDTO.getEndereco().getRua());
        endereco.setCidade(empresaDTO.getEndereco().getCidade());
        endereco.setEstado(empresaDTO.getEndereco().getEstado());
        endereco.setCep(empresaDTO.getEndereco().getCep());
        endereco.setPais(empresaDTO.getEndereco().getPais());
        endereco.setNumero(empresaDTO.getEndereco().getNumero());
        endereco.setComplemento(empresaDTO.getEndereco().getComplemento());
        endereco.setBairro(empresaDTO.getEndereco().getBairro());
        endereco.setCriadoEm(new Date());
        endereco.setAtualizadoEm(new Date());
        Endereco savedEndereco = enderecoRepository.save(endereco);

        Empresas empresa = new Empresas();
        empresa.setCnpjEmpresa(empresaDTO.getCnpjEmpresa());
        empresa.setNomeEmpresa(empresaDTO.getNomeEmpresa());
        empresa.setTipoEmpresa(empresaDTO.getTipoEmpresa());
        empresa.setAreaAtuacaoEmpresa(empresaDTO.getAreaAtuacaoEmpresa());
        empresa.setNomeResponsavelEmpresa(empresaDTO.getNomeResponsavelEmpresa());
        empresa.setCargoResponsavelEmpresa(empresaDTO.getCargoResponsavelEmpresa());
        empresa.setCpfResponsavelEmpresa(empresaDTO.getCpfResponsavelEmpresa());
        empresa.setEmailResponsavelEmpresa(empresaDTO.getEmailResponsavelEmpresa());
        empresa.setTelefoneResponsavelEmpresa(empresaDTO.getTelefoneResponsavelEmpresa());
        empresa.setEndereco(savedEndereco);
        empresa.setCriadoEm(new Date());
        empresa.setAtualizadoEm(new Date());
        return empresasRepository.save(empresa);
    }

    @Transactional
    public Empresas updateEmpresa(Integer id, EmpresaDTO empresaDTO) {
        Empresas empresa = empresasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada com o id: " + id));

        empresa.setCnpjEmpresa(empresaDTO.getCnpjEmpresa());
        empresa.setNomeEmpresa(empresaDTO.getNomeEmpresa());
        empresa.setTipoEmpresa(empresaDTO.getTipoEmpresa());
        empresa.setAreaAtuacaoEmpresa(empresaDTO.getAreaAtuacaoEmpresa());
        empresa.setNomeResponsavelEmpresa(empresaDTO.getNomeResponsavelEmpresa());
        empresa.setCargoResponsavelEmpresa(empresaDTO.getCargoResponsavelEmpresa());
        empresa.setCpfResponsavelEmpresa(empresaDTO.getCpfResponsavelEmpresa());
        empresa.setEmailResponsavelEmpresa(empresaDTO.getEmailResponsavelEmpresa());
        empresa.setTelefoneResponsavelEmpresa(empresaDTO.getTelefoneResponsavelEmpresa());
        empresa.setAtualizadoEm(new Date());

        if (empresaDTO.getEndereco() != null) {
            Endereco endereco = empresa.getEndereco();
            if (endereco == null) {
                endereco = new Endereco();
                endereco.setCriadoEm(new Date());
            }
            endereco.setRua(empresaDTO.getEndereco().getRua());
            endereco.setCidade(empresaDTO.getEndereco().getCidade());
            endereco.setEstado(empresaDTO.getEndereco().getEstado());
            endereco.setCep(empresaDTO.getEndereco().getCep());
            endereco.setPais(empresaDTO.getEndereco().getPais());
            endereco.setNumero(empresaDTO.getEndereco().getNumero());
            endereco.setComplemento(empresaDTO.getEndereco().getComplemento());
            endereco.setBairro(empresaDTO.getEndereco().getBairro());
            endereco.setAtualizadoEm(new Date());
            Endereco savedEndereco = enderecoRepository.save(endereco);
            empresa.setEndereco(savedEndereco);
        }

        return empresasRepository.save(empresa);
    }
}
