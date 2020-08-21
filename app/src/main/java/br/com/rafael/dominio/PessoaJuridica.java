package br.com.rafael.dominio;

public class PessoaJuridica extends Pessoa
{
    private String cnpj;

    public PessoaJuridica()
    {
    }

    public PessoaJuridica(String cnpj)
    {
        this.cnpj = cnpj;
    }

    public PessoaJuridica(Integer codigo, String nome, String cnpj)
    {
        super(codigo, "PESSOA JURÍDICA: " + nome);
        this.cnpj = cnpj;
    }

    public String getCnpj()
    {
        return cnpj;
    }

    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }

    @Override
    public void setNome(String nome)
    {
        super.setNome("PESSOA JURÍDICA: " + nome);
    }

    @Override
    public String getIdentificador()
    {
        return cnpj;
    }

    @Override
    public String realizaApresentacao()
    {
        return "Pessoa física não fala";
    }
}
