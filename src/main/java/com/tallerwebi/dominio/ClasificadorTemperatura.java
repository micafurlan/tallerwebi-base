package com.tallerwebi.dominio;

public class ClasificadorTemperatura {
    public String clasificarTemperatura(Integer grados){
        if(grados<=0){
            return ClasificacionTemperatura.CONGELANTE.name();
        } else if (grados>0 && grados<=15){
            return ClasificacionTemperatura.FRIA.name();
        } else if (grados>15 && grados<=25){
            return ClasificacionTemperatura.TEMPLADA.name();
        } else if(grados>25 && grados<=35){
            return ClasificacionTemperatura.CALUROSA.name();
        }else if (grados>35){
            return ClasificacionTemperatura.PELIGROSA.name();
        }
        return null;
}
public String clasificarTemperaturaFahrenheit(Double grados){
    Integer temperaturaEnCelsius = (int)Math.round((grados - 32) / 1.8);
    return clasificarTemperatura(temperaturaEnCelsius);
}
public String clasificarTemperaturaEnString (String grados){
    
    Integer temperaturaEnCelsius = Integer.parseInt(grados);
    return clasificarTemperatura(temperaturaEnCelsius);
}
}
