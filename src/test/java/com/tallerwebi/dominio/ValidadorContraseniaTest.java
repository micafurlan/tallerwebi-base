package com.tallerwebi.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ValidadorContraseniaTest {


    ValidadorContrasenia validador;
    @BeforeEach
    public void init(){
        this.validador = new ValidadorContrasenia();
    }
    @Test
    public void alEscribirUnaContraseniaVaciaSeValidaInvalida(){
        String contraseniaInvalida = "";
        String tipoObtenido = validador.validarFortaleza(contraseniaInvalida);
        String tipoEsperado = FortalezaContrasenia.INVALIDA.name();
        assertEquals(tipoObtenido, tipoEsperado);
    } 
    @Test
    public void alEscribirUnaContraseniaNulaSeValidaInvalida(){
        String contraseniaInvalida = null;
        String tipoObtenido = validador.validarFortaleza(contraseniaInvalida);
        String tipoEsperado = FortalezaContrasenia.INVALIDA.name();
        assertEquals(tipoObtenido, tipoEsperado);
}

   @Test
    public void alEscribirUnaContraseniaConMenosDeOchoCaracteresSeValidaDebil(){
        String contraniaDebil = "misery";
        String fortalezaObtenida = validador.validarFortaleza(contraniaDebil);
        String fortalezaBuscada = FortalezaContrasenia.DEBIL.name();
        assertEquals(fortalezaBuscada, fortalezaObtenida);
    }

    @Test
    public void alEscribirUnaContraseniaDeOchoCaracteresSeValidaDebil(){
        String contraniaDebil = "miseryLL";
        String fortalezaObtenida = validador.validarFortaleza(contraniaDebil);
        String fortalezaBuscada = FortalezaContrasenia.DEBIL.name();
        assertEquals(fortalezaBuscada, fortalezaObtenida);
    }

    @Test
    public void alEscribirUnaContraseniaConMasDeOchoCaracteresUnNumeroYUnCaracterEspecialSeValidaMediana(){
        String contraseniaMediana = "perro%loco5";
        String fortalezaObtenida = validador.validarFortaleza(contraseniaMediana);
        String fortalezaEsperada = FortalezaContrasenia.MEDIANA.name();
        assertEquals(fortalezaEsperada,fortalezaObtenida);
    }

    @Test
    public void alEscribirUnaContraseniaConMasDeOchoCaracteresCuatroLetrasDosNumerosYDosCaracteresEspecialesSeValidaFuerte(){
        String contraniaFuerte = "pato67@%";
        String fortalezaObtenida = validador.validarFortaleza(contraniaFuerte);
        String fortalezaEsperada = FortalezaContrasenia.FUERTE.name();
        assertEquals(fortalezaEsperada,fortalezaObtenida);
    }

}