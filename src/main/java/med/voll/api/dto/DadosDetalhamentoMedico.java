package med.voll.api.dto;

import med.voll.api.entity.Medico;
import med.voll.api.type.Especialidade;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, EnderecoDTO endereco) {

	public DadosDetalhamentoMedico (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
	
}
