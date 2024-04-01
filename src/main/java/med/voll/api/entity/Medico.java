package med.voll.api.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.EnderecoDTO;
import med.voll.api.record.DadosAtualizacaoMedico;
import med.voll.api.record.DadosCadastroMedico;
import med.voll.api.type.Especialidade;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
    private String email;
    private String telefone;
    private String crm;
    private String ativo;
    @Enumerated(EnumType.STRING)    
    private Especialidade especialidade;
    @Embedded
    private EnderecoDTO endereco; 

    public Medico() {
    	
    }
    
    public Medico(DadosCadastroMedico dados) {
    	this.nome = dados.nome();
    	this.email = dados.email();
    	this.crm = dados.crm();
    	this.endereco = new EnderecoDTO(dados.endereco());
    	this.especialidade = dados.especialidade();
    	this.telefone = dados.telefone();
    	this.ativo = "S";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
		if(dados.nome()!=null) {
			this.nome = dados.nome();
		}
		if(dados.telefone()!=null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco()!=null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

	public void inativar() {
		this.ativo = "N";
	}
	
	public void ativar() {
		this.ativo = "S";
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

}
