package br.com.fiap.SorrisoEmJogo.service;

import br.com.fiap.SorrisoEmJogo.controller.dto.UsuarioDTO;
import br.com.fiap.SorrisoEmJogo.model.Usuario;
import br.com.fiap.SorrisoEmJogo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final JdbcTemplate jdbcTemplate;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(JdbcTemplate jdbcTemplate, UsuarioRepository usuarioRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll(); // Obtém todos os usuários da tabela
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id); // Busca um usuário pelo ID
    }

    public void inserirUsuario(UsuarioDTO usuarioDTO) {
        String sql = "{call inserir_usuario(?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, usuarioDTO.getEmail(), usuarioDTO.getNome(),
                usuarioDTO.getSenha(), new Date(),
                usuarioDTO.getPontosRecompensa());
    }

    public void atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        String sql = "{call atualizar_usuario(?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, id, usuarioDTO.getEmail(), usuarioDTO.getNome(),
                usuarioDTO.getSenha(), usuarioDTO.getPontosRecompensa());
    }

    public void deletarUsuario(Long id) {
        String sql = "{call deletar_usuario(?)}";
        jdbcTemplate.update(sql, id);
    }
}
