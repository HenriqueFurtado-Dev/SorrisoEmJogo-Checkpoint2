package br.com.fiap.SorrisoEmJogo.service;

import br.com.fiap.SorrisoEmJogo.model.Recompensa;
import br.com.fiap.SorrisoEmJogo.controller.dto.RecompensaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Service
public class RecompensaService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RecompensaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para recuperar todas as recompensas
    public List<Recompensa> getAllRecompensas() {
        String sql = "SELECT recompensa_id, descricao, pontos_necessarios FROM recompensa";
        return jdbcTemplate.query(sql, new RowMapper<Recompensa>() {
            @Override
            public Recompensa mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Recompensa recompensa = new Recompensa();
                recompensa.setRecompensaId(rs.getLong("recompensa_id"));
                recompensa.setDescricao(rs.getString("descricao"));
                recompensa.setPontosNecessarios(rs.getFloat("pontos_necessarios"));
                return recompensa;
            }
        });
    }

    // Método para recuperar uma recompensa por ID
    public Recompensa getRecompensaById(Long id) {
        String sql = "SELECT recompensa_id, descricao, pontos_necessarios FROM recompensa WHERE recompensa_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Recompensa recompensa = new Recompensa();
            recompensa.setRecompensaId(rs.getLong("recompensa_id"));
            recompensa.setDescricao(rs.getString("descricao"));
            recompensa.setPontosNecessarios(rs.getFloat("pontos_necessarios"));
            return recompensa;
        });
    }

    // Executando INSERT nas Procedures
    public void inserirRecompensa(RecompensaDTO recompensaDTO) {
        jdbcTemplate.update(connection -> {
            var callableStatement = connection.prepareCall("{call INSERIR_RECOMPENSA(?, ?)}");
            callableStatement.setString(1, recompensaDTO.getDescricao());
            callableStatement.setFloat(2, recompensaDTO.getPontosNecessarios());
            return callableStatement;
        });
    }

    // Executando UPDATE nas Procedures
    public void atualizarRecompensa(Long recompensaId, RecompensaDTO recompensaDTO) {
        jdbcTemplate.update(connection -> {
            var callableStatement = connection.prepareCall("{call ATUALIZAR_RECOMPENSA(?, ?, ?)}");
            callableStatement.setLong(1, recompensaId);
            callableStatement.setString(2, recompensaDTO.getDescricao());
            callableStatement.setFloat(3, recompensaDTO.getPontosNecessarios());
            return callableStatement;
        });
    }

    // Executando DELETE nas Procedures
    public void excluirRecompensa(Long recompensaId) {
        jdbcTemplate.update(connection -> {
            var callableStatement = connection.prepareCall("{call EXCLUIR_RECOMPENSA(?)}");
            callableStatement.setLong(1, recompensaId);
            return callableStatement;
        });
    }
}
