package br.com.rafael.banco;

import java.util.Date;

public class OperacaoRealizada
{
    private Double valor;
    private Date data;

    public OperacaoRealizada(Double valor, Date data)
    {
        this.valor = valor;
        this.data = data;
    }

    public Double getValor()
    {
        return valor;
    }

    public void setValor(Double valor)
    {
        this.valor = valor;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public String getDescricao()
    {
        if (valor > 0)
           return "CREDITO NA DATA " + data.toString() + " no valor de R$ " + valor + "\r\n";
        else
            return "DEBITO NA DATA " + data.toString() + " no valor de R$ " + valor + "\r\n";
    }
}
