package br.com.rafael.banco;

public class ContaFisica extends Conta
{
    private String cpf;
    private String nome;

    public ContaFisica(Integer numero, String nomeBanco, Double saldo, String cpf, String nome)
    {
        super(numero, nomeBanco, saldo);
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    @Override
    public String getIdentificacaoCorrentista()
    {
        return cpf;
    }

    @Override
    public boolean credito(Double valor)
    {
        Double saldoAtual = getSaldo();
        setSaldo(saldoAtual + valor - 5);
        registraOperacao(valor);
        return true;
    }

    @Override
    public boolean debito(Double valor)
    {
        Double saldoAtual = getSaldo();
        setSaldo(saldoAtual - valor - 5);
        registraOperacao(-valor);
        return true;
    }
}
