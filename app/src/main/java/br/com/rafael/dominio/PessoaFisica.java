package br.com.rafael.dominio;

public class PessoaFisica extends Pessoa
{
    private String cpf;

    public PessoaFisica(Integer codigo, String nome, String cpf)
    {
        super(codigo, nome);
        this.cpf = cpf;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    @Override
    public String getIdentificador()
    {
        return cpf;
    }

    @Override
    public String realizaApresentacao()
    {
        return "Olá, eu sou uma pessoa Física que se chama " + getNome();
    }
}
