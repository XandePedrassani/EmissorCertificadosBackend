package com.OficinaDeSoftware.EmissorCertificadosBackend.model;

public enum ProviderEnum {
    GOOGLE;

    public static ProviderEnum parse(String name) {
        return valueOf(name.toUpperCase());
    }
}