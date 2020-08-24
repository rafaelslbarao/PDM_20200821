package br.com.rafael.banco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements OperacaoBancaria
{
    private Integer numero;
    private String nomeBanco;
    private Double saldo;
    private List<OperacaoRealizada> listaOperacoes;

    public Conta(Integer numero, String nomeBanco, Double saldo)
    {
        this.numero = numero;
        this.nomeBanco = nomeBanco;
        this.saldo = saldo;
        listaOperacoes = new ArrayList<>();
    }

    public Integer getNumero()
    {
        return numero;
    }

    public void setNumero(Integer numero)
    {
        this.numero = numero;
    }

    public String getNomeBanco()
    {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco)
    {
        this.nomeBanco = nomeBanco;
    }

    public Double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(Double saldo)
    {
        this.saldo = saldo;
    }

    public void registraOperacao(Double valor)
    {
        OperacaoRealizada operacaoRealizada = new OperacaoRealizada(valor, new Date());
        listaOperacoes.add(operacaoRealizada);
    }

    public abstract String getIdentificacaoCorrentista();

    public String getExtrato()
    {
        String extrato = "### Extrato ###\r\n";

        for (OperacaoRealizada operacao : listaOperacoes)
            extrato += operacao.getDescricao();

        return extrato;
    }
}
