package br.edu.monitoramento.java.service;

import br.edu.monitoramento.java.dto.UsuarioCreateDTO;
import br.edu.monitoramento.java.model.Empresas;
import br.edu.monitoramento.java.model.Usuarios;
import br.edu.monitoramento.java.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;
    private final EmpresasService empresaService;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository, EmpresasService empresaService) {
        this.empresaService = empresaService;
        this.usuariosRepository = usuariosRepository;
    }

    public List<Usuarios> buscarTodos(){
        return usuariosRepository.findAll();
    }

    public Usuarios buscarPorId(int id){
        return usuariosRepository.findById(id).orElse(null);
    }

    @Transactional
    public Usuarios salvar(UsuarioCreateDTO usuarioCreateDTO){
        Empresas empresaCriada = empresaService.createEmpresa(usuarioCreateDTO.getEmpresa());

        Usuarios novoUsuario = new Usuarios();
        novoUsuario.setNomeUsuario(usuarioCreateDTO.getNomeUsuario());
        novoUsuario.setEmailUsuario(usuarioCreateDTO.getEmailUsuario());
        novoUsuario.setEmpresa(empresaCriada);
        novoUsuario.setCriadoEm(new Date());
        novoUsuario.setAtualizadoEm(new Date());

        return usuariosRepository.save(novoUsuario);
    }
}
