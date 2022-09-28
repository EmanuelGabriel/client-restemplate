package com.example.client.mapper.response;

/**
 * 
 * @author emanuel.sousa
 *
 */

public class ListaInforAdicionalResponseDTO {

	private String codigoInformacaoAdicional;
	private String textoInformacaoAdicional;

	public ListaInforAdicionalResponseDTO() {
	}

	public ListaInforAdicionalResponseDTO(String codigoInformacaoAdicional, String textoInformacaoAdicional) {
		this.codigoInformacaoAdicional = codigoInformacaoAdicional;
		this.textoInformacaoAdicional = textoInformacaoAdicional;
	}

	public String getCodigoInformacaoAdicional() {
		return codigoInformacaoAdicional;
	}

	public String getTextoInformacaoAdicional() {
		return textoInformacaoAdicional;
	}

	public void setCodigoInformacaoAdicional(String codigoInformacaoAdicional) {
		this.codigoInformacaoAdicional = codigoInformacaoAdicional;
	}

	public void setTextoInformacaoAdicional(String textoInformacaoAdicional) {
		this.textoInformacaoAdicional = textoInformacaoAdicional;
	}

}
