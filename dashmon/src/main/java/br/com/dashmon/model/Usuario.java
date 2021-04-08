package br.com.dashmon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 				        //indica que a classe Usuário é armazenável em BD
@Table(name="itmn_usuario")
public class Usuario {

		@Id					//indica que o atributo é chave-primaria
		@GeneratedValue(strategy=GenerationType.IDENTITY) // informo que é AUTO_INCREMENTE
		@Column(name="id_usuario") // informa o nome da coluna no banco de dados
		private int id;
		
		@Column(name="nome_usuario", length =100, nullable = false, unique = false)
		private String nome;
		
		@Column(name="email_usuario", length =50, nullable = false, unique = true)
		private String email;
		
		@Column(name="racf_usuario", length =7, nullable = false, unique = true)
		private String racf;
		
		@Column(name="senha_usuario", length =30, nullable = false, unique = false)
		private String senha;
		
		@Column(name="ramal_usuario", length =10, nullable = false, unique = false)
		private String ramal;

		@Column(name="foto_usuario", length =255, nullable = false, unique = false)
		private String Foto;

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", racf=" + racf + ", senha=" + senha
					+ ", ramal=" + ramal + ", Foto=" + Foto + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
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

		public String getRacf() {
			return racf;
		}

		public void setRacf(String racf) {
			this.racf = racf;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getRamal() {
			return ramal;
		}

		public void setRamal(String ramal) {
			this.ramal = ramal;
		}

		public String getFoto() {
			return Foto;
		}

		public void setFoto(String foto) {
			Foto = foto;
		}

		public Usuario(int id, String nome, String email, String racf, String senha, String ramal, String foto) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.racf = racf;
			this.senha = senha;
			this.ramal = ramal;
			Foto = foto;
		}

		public Usuario() {
			super();
		}
		
	
	
}
