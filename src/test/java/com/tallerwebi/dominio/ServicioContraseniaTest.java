package com.tallerwebi.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ServicioContraseniaTest {
    private RepositorioContrasenia repositorioContrasenia;
    private ServicioContrasenia servicioContrasenia;
    @BeforeEach
    public void init(){
    this.repositorioContrasenia = mock(RepositorioContrasenia.class);
    this.servicioContrasenia = new ServicioContraseniaImpl(this.repositorioContrasenia);
    }
    @Test
    public void alEscribirUnaContraseniaVaciaSeValidaInvalida(){
        String contraseniaInvalida = "";
        when(repositorioContrasenia.guardar(anyString(), anyString())).thenReturn(true);
        String tipoObtenido = servicioContrasenia.validarFortaleza(contraseniaInvalida);
        String tipoEsperado = FortalezaContrasenia.INVALIDA.name();
        assertThat(tipoObtenido, is(tipoEsperado));
    } 
    @Test
    public void alEscribirUnaContraseniaNulaSeValidaInvalida(){
        String contraseniaInvalida = null;
            when(repositorioContrasenia.guardar(isNull(), anyString()))
        .thenReturn(true);
        String tipoObtenido = servicioContrasenia.validarFortaleza(contraseniaInvalida);
        String tipoEsperado = FortalezaContrasenia.INVALIDA.name();
        assertThat(tipoObtenido,is(tipoEsperado));

}

   @Test
    public void alEscribirUnaContraseniaConMenosDeOchoCaracteresSeValidaDebil(){
        String contraniaDebil = "misery";
        when(repositorioContrasenia.guardar(anyString(), anyString())).thenReturn(true);
        String fortalezaObtenida = servicioContrasenia.validarFortaleza(contraniaDebil);
        String fortalezaBuscada = FortalezaContrasenia.DEBIL.name();
        assertThat(fortalezaObtenida,is(fortalezaBuscada));
    }

    @Test
    public void alEscribirUnaContraseniaDeOchoCaracteresSeValidaDebil(){
        String contraniaDebil = "miseryLL";
        when(repositorioContrasenia.guardar(anyString(), anyString())).thenReturn(true);
        String fortalezaObtenida = servicioContrasenia.validarFortaleza(contraniaDebil);
        String fortalezaBuscada = FortalezaContrasenia.DEBIL.name();
        assertThat(fortalezaObtenida,is(fortalezaBuscada));
    }

    @Test
    public void alEscribirUnaContraseniaConMasDeOchoCaracteresUnNumeroYUnCaracterEspecialSeValidaMediana(){
        String contraseniaMediana = "perro%loco5";
        when(repositorioContrasenia.guardar(anyString(), anyString())).thenReturn(true);
        String fortalezaObtenida = servicioContrasenia.validarFortaleza(contraseniaMediana);
        String fortalezaEsperada = FortalezaContrasenia.MEDIANA.name();
        assertThat(fortalezaObtenida,is(fortalezaEsperada));
    }

    @Test
    public void alEscribirUnaContraseniaConMasDeOchoCaracteresCuatroLetrasDosNumerosYDosCaracteresEspecialesSeValidaFuerte(){
        String contraniaFuerte = "pato67@%";
        when(repositorioContrasenia.guardar(anyString(), anyString())).thenReturn(true);
        String fortalezaObtenida = servicioContrasenia.validarFortaleza(contraniaFuerte);
        String fortalezaEsperada = FortalezaContrasenia.FUERTE.name();
        assertThat(fortalezaObtenida,is(fortalezaEsperada));
    }

}