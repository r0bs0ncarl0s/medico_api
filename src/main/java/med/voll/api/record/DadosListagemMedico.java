package med.voll.api.record;

import med.voll.api.entity.Medico;
import med.voll.api.type.Especialidade;

public record DadosListagemMedico(
		Long id,
		String nome,
		String email,
		String telefone,
		String crm,
		Especialidade especialidade,
		String ativo){
		
	public DadosListagemMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
	}
}
