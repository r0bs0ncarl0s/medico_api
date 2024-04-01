package med.voll.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import med.voll.api.entity.Medico;
import med.voll.api.record.DadosListagemMedico;

public interface IMedicoRepository extends JpaRepository<Medico, Long>{

	@Query("SELECT m FROM Medico m WHERE m.ativo = 'S'")
	List<DadosListagemMedico> findAllAtivos();

	@Query("SELECT m FROM Medico m WHERE m.ativo = 'N'")
	List<DadosListagemMedico> findAllInativos();

}
