package com.example.client.mapper.response;

import java.util.List;

/**
 * 
 * @author emanuel.sousa
 *
 */
public class GuiaArrecadacaoQrCodeResponseDTO {

	private String codigoGuiaRecebimento;
	private String codigoConciliacaoSolicitante;
	private String emailDevedor;
	private int codigoPaisTelefoneDevedor;
	private int dddTelefoneDevedor;
	private String numeroTelefoneDevedor;
	private String timestampCriacaoSolicitacao;
	// default: 3600;
	private long quantidadeSegundoExpiracao; 
	private String estadoSolicitacao;
	private String numeroVersaoSolicitacaoPagamento;
	private String linkQrCode;
	private String qrCode;
	private String cpfDevedor;
	private String cnpjDevedor;
	private String nomeDevedor;
	// 300.00,
	private double valorOriginalSolicitacao; 
	// e2572aa4-52d6-4527-bc69-60c0699ea50d - CHAVE PIX DO ENTE PÚBLICO
	private String codigoSolicitacaoBancoCentralBrasil; 
	private String descricaoSolicitacaoPagamento;
	private List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional;
	private String codigoIdentificadorPagamento;
	private long valorPagamento;
	private String timestampPagamento;
	private int cpfPagador;
	private int cnpjPagador;
	private String nomeClientePagador;
	private String textoInformativoPagador;

	public GuiaArrecadacaoQrCodeResponseDTO() {
		super();
	}

	public String getCodigoConciliacaoSolicitante() {
		return codigoConciliacaoSolicitante;
	}

	public String getEmailDevedor() {
		return emailDevedor;
	}

	public int getCodigoPaisTelefoneDevedor() {
		return codigoPaisTelefoneDevedor;
	}

	public int getDddTelefoneDevedor() {
		return dddTelefoneDevedor;
	}

	public String getNumeroTelefoneDevedor() {
		return numeroTelefoneDevedor;
	}

	public String getTimestampCriacaoSolicitacao() {
		return timestampCriacaoSolicitacao;
	}

	public long getQuantidadeSegundoExpiracao() {
		return quantidadeSegundoExpiracao;
	}

	public String getEstadoSolicitacao() {
		return estadoSolicitacao;
	}

	public String getNumeroVersaoSolicitacaoPagamento() {
		return numeroVersaoSolicitacaoPagamento;
	}

	public String getLinkQrCode() {
		return linkQrCode;
	}

	public String getQrCode() {
		return qrCode;
	}

	public String getCpfDevedor() {
		return cpfDevedor;
	}

	public String getCnpjDevedor() {
		return cnpjDevedor;
	}

	public String getNomeDevedor() {
		return nomeDevedor;
	}

	public double getValorOriginalSolicitacao() {
		return valorOriginalSolicitacao;
	}

	public String getCodigoSolicitacaoBancoCentralBrasil() {
		return codigoSolicitacaoBancoCentralBrasil;
	}

	public String getDescricaoSolicitacaoPagamento() {
		return descricaoSolicitacaoPagamento;
	}

	public List<ListaInforAdicionalResponseDTO> getListaInformacaoAdicional() {
		return listaInformacaoAdicional;
	}

	public String getCodigoIdentificadorPagamento() {
		return codigoIdentificadorPagamento;
	}

	public long getValorPagamento() {
		return valorPagamento;
	}

	public String getTimestampPagamento() {
		return timestampPagamento;
	}

	public int getCpfPagador() {
		return cpfPagador;
	}

	public int getCnpjPagador() {
		return cnpjPagador;
	}

	public String getNomeClientePagador() {
		return nomeClientePagador;
	}

	public String getTextoInformativoPagador() {
		return textoInformativoPagador;
	}

	public void setCodigoConciliacaoSolicitante(String codigoConciliacaoSolicitante) {
		this.codigoConciliacaoSolicitante = codigoConciliacaoSolicitante;
	}

	public void setEmailDevedor(String emailDevedor) {
		this.emailDevedor = emailDevedor;
	}

	public void setCodigoPaisTelefoneDevedor(int codigoPaisTelefoneDevedor) {
		this.codigoPaisTelefoneDevedor = codigoPaisTelefoneDevedor;
	}

	public void setDddTelefoneDevedor(int dddTelefoneDevedor) {
		this.dddTelefoneDevedor = dddTelefoneDevedor;
	}

	public void setNumeroTelefoneDevedor(String numeroTelefoneDevedor) {
		this.numeroTelefoneDevedor = numeroTelefoneDevedor;
	}

	public void setTimestampCriacaoSolicitacao(String timestampCriacaoSolicitacao) {
		this.timestampCriacaoSolicitacao = timestampCriacaoSolicitacao;
	}

	public void setQuantidadeSegundoExpiracao(long quantidadeSegundoExpiracao) {
		this.quantidadeSegundoExpiracao = quantidadeSegundoExpiracao;
	}

	public void setEstadoSolicitacao(String estadoSolicitacao) {
		this.estadoSolicitacao = estadoSolicitacao;
	}

	public void setNumeroVersaoSolicitacaoPagamento(String numeroVersaoSolicitacaoPagamento) {
		this.numeroVersaoSolicitacaoPagamento = numeroVersaoSolicitacaoPagamento;
	}

	public void setLinkQrCode(String linkQrCode) {
		this.linkQrCode = linkQrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public void setCpfDevedor(String cpfDevedor) {
		this.cpfDevedor = cpfDevedor;
	}

	public void setCnpjDevedor(String cnpjDevedor) {
		this.cnpjDevedor = cnpjDevedor;
	}

	public void setNomeDevedor(String nomeDevedor) {
		this.nomeDevedor = nomeDevedor;
	}

	public void setValorOriginalSolicitacao(double valorOriginalSolicitacao) {
		this.valorOriginalSolicitacao = valorOriginalSolicitacao;
	}

	public void setCodigoSolicitacaoBancoCentralBrasil(String codigoSolicitacaoBancoCentralBrasil) {
		this.codigoSolicitacaoBancoCentralBrasil = codigoSolicitacaoBancoCentralBrasil;
	}

	public void setDescricaoSolicitacaoPagamento(String descricaoSolicitacaoPagamento) {
		this.descricaoSolicitacaoPagamento = descricaoSolicitacaoPagamento;
	}

	public void setListaInformacaoAdicional(List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional) {
		this.listaInformacaoAdicional = listaInformacaoAdicional;
	}

	public void setCodigoIdentificadorPagamento(String codigoIdentificadorPagamento) {
		this.codigoIdentificadorPagamento = codigoIdentificadorPagamento;
	}

	public void setValorPagamento(long valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public void setTimestampPagamento(String timestampPagamento) {
		this.timestampPagamento = timestampPagamento;
	}

	public void setCpfPagador(int cpfPagador) {
		this.cpfPagador = cpfPagador;
	}

	public void setCnpjPagador(int cnpjPagador) {
		this.cnpjPagador = cnpjPagador;
	}

	public void setNomeClientePagador(String nomeClientePagador) {
		this.nomeClientePagador = nomeClientePagador;
	}

	public void setTextoInformativoPagador(String textoInformativoPagador) {
		this.textoInformativoPagador = textoInformativoPagador;
	}

	public String getCodigoGuiaRecebimento() {
		return codigoGuiaRecebimento;
	}

	public void setCodigoGuiaRecebimento(String codigoGuiaRecebimento) {
		this.codigoGuiaRecebimento = codigoGuiaRecebimento;
	}

}
