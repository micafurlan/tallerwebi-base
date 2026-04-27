package com.tallerwebi.dominio;

public interface ServicioTemperatura {
String clasificarTemperatura(Integer grados);
String clasificarTemperaturaFahrenheit(Double grados);
String clasificarTemperaturaEnString (String grados);
}
