package br.com.rafael.banco;

public interface OperacaoBancaria
{
    public boolean credito(Double valor);

    public boolean debito(Double valor);
}
