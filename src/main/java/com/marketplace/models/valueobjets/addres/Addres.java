package com.marketplace.models.valueobjets.addres;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public record Addres (String comuna,String direccion,String numero){
    public  Addres{
        Objects.requireNonNull(comuna, "Comuna cannot be null");
        Objects.requireNonNull(direccion, "Direccion cannot be null");
        Objects.requireNonNull(numero, "Numero cannot be null");
    }
}
