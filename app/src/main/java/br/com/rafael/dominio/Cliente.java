package br.com.rafael.dominio;

import java.io.Serializable;

public class Cliente implements Serializable
{
    private Long codigo;
    private String email;
    private String nome;
    private Double latitude;
    private Double longitude;
    private Boolean confirmado;

    public Long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Long codigo)
    {
        this.codigo = codigo;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }

    public Boolean getConfirmado()
    {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado)
    {
        this.confirmado = confirmado;
    }
}

