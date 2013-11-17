package com.barbosa.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="interessado")
@XmlAccessorType(XmlAccessType.FIELD)
public class Interessado {
	
	@XmlAttribute
	private Integer id;
	@XmlElement
	private String nome;
	@XmlElement
	private String telefone;
	@XmlElement
	private String email;
	@XmlElement
	private String interesse;
	
	public Interessado(){}
	
	public Interessado(Integer id, String nome, String telefone, String email, String interesse){
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.interesse = interesse;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setInteresse(String interesse){
		this.interesse = interesse;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getTelefone(){
		return this.telefone;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getInteresse(){
		return this.interesse;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer()
			.append("id:").append(this.id)
			.append("; nome:").append(this.nome)
			.append("; telefone:").append(this.telefone)
			.append("; email:").append(this.email)
			.append("; interesse:").append(this.interesse);
		
		return sb.toString();
	}
}
