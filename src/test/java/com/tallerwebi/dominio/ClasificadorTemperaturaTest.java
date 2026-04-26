package com.tallerwebi.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClasificadorTemperaturaTest {
    ClasificadorTemperatura clasificador;
    @BeforeEach
    public void init(){
        this.clasificador = new ClasificadorTemperatura();
    }
    @Test
    public void cuandoIngresoCeroGradosCellsiusSeClasificaCongelante(){
        Integer temperaturaCongelante = 0;
        String clasificacionObtenida = clasificador.clasificarTemperatura(temperaturaCongelante);
        String clasificacionEsperada = ClasificacionTemperatura.CONGELANTE.name();
        assertEquals(clasificacionEsperada, clasificacionObtenida);
    }
     @Test
    public void cuandoIngresoUnGradoCellsiusSeClasificaFria(){
        Integer temperaturaFria = 1;
        String clasificacionObtenida = clasificador.clasificarTemperatura(temperaturaFria);
        String clasificacionEsperada = ClasificacionTemperatura.FRIA.name();
        assertEquals(clasificacionEsperada, clasificacionObtenida);
    }
     @Test
    public void cuandoIngresoDieciseisGradosCellsiusSeClasificaTEMPLADA(){
        Integer temperaturaTemplada = 16;
        String clasificacionObtenida = clasificador.clasificarTemperatura(temperaturaTemplada);
        String clasificacionEsperada = ClasificacionTemperatura.TEMPLADA.name();
        assertEquals(clasificacionEsperada, clasificacionObtenida);
    }
     @Test
    public void cuandoIngresoVeintiseisGradosCellsiusSeClasificaCALUROSA(){
        Integer temperaturaCalurosa = 26;
        String clasificacionObtenida = clasificador.clasificarTemperatura(temperaturaCalurosa);
        String clasificacionEsperada = ClasificacionTemperatura.CALUROSA.name();
        assertEquals(clasificacionEsperada, clasificacionObtenida);
    }
    @Test
    public void cuandoIngresoVeintiseisGradosCellsiusSeClasificaPELIGROSA(){
        Integer temperaturaPeligrosa = 36;
        String clasificacionObtenida = clasificador.clasificarTemperatura(temperaturaPeligrosa);
        String clasificacionEsperada = ClasificacionTemperatura.PELIGROSA.name();
        assertEquals(clasificacionEsperada, clasificacionObtenida);
    }
    @Test
    public void cuandoIngresoSetentaYOchoComaOchoGradosFahrenheitSeClasificaCALUROSA(){   
        Double temperaturaCalurosa = 78.8;
        String clasificacionEsperada = ClasificacionTemperatura.CALUROSA.name();
        String clasificacionObtenida = clasificador.clasificarTemperaturaFahrenheit(temperaturaCalurosa);
        assertEquals(clasificacionEsperada, clasificacionObtenida);
    }
    @Test
    public void cuandoIngresoMenosUnoYLaLetraEfeSeClasificaCongelante(){
        String temperaturaCongelante = "-1";
        String clasificacionObtenida = clasificador.clasificarTemperaturaEnString(temperaturaCongelante);
        String clasificacionEsperada = ClasificacionTemperatura.CONGELANTE.name();
        assertEquals(clasificacionEsperada, clasificacionObtenida);
    }

}
    
