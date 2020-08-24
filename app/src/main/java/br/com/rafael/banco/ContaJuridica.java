package br.com.rafael.banco;

public class ContaJuridica extends Conta
{
    private String cnpj;
    private String razaoSocial;

    public ContaJuridica(Integer numero, String nomeBanco, Double saldo, String cnpj, String razaoSocial)
    {
        super(numero, nomeBanco, saldo);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj()
    {
        return cnpj;
    }

    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial()
    {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial)
    {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getIdentificacaoCorrentista()
    {
        return cnpj;
    }

    @Override
    public boolean credito(Double valor)
    {
        Double saldoAtual = getSaldo();
        setSaldo(saldoAtual + valor - 10);
        registraOperacao(valor);
        return true;
    }

    @Override
    public boolean debito(Double valor)
    {
        Double saldoAtual = getSaldo();
        setSaldo(saldoAtual - valor - 10);
        registraOperacao(-valor);
        return true;
    }
}
