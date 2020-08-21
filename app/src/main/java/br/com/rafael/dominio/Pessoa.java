package br.com.rafael.dominio;

public abstract class Pessoa implements Apresentacao
{
    public static final Integer codigoInicial = 1;
    private Integer codigo;
    private String nome;

    public Pessoa()    {
    }

    public Pessoa(Integer codigo, String nome)    {
        this.codigo = codigo;
        this.nome = nome;
    }
    public Integer getCodigo()    {
        return codigo;
    }
    public void setCodigo(Integer codigo)
    {
        this.codigo = codigo;
    }
    public void setCodigo(Integer codigo1, Integer codigo2)
    {
        this.codigo = codigo1 + codigo2;
    }
    public void setCodigo(String codigo)
    {
        this.codigo = Integer.valueOf(codigo);
    }
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public abstract String getIdentificador();
}
