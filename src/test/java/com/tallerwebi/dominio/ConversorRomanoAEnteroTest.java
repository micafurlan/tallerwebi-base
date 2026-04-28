package com.tallerwebi.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tallerwebi.dominio.excepcion.NumeroRomanoInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConversorRomanoAEnteroTest {

  RepositorioRomanoAEntero repositorio;
  ServicioRomanoAEntero servicio;

  @BeforeEach
  public void init() {
    this.repositorio = mock(RepositorioRomanoAEntero.class);
    this.servicio = new ServicioRomanoAEnteroImpl(this.repositorio);
  }

  @Test
  public void cuandoIngresoUnSoloCharEnNumeroRomanoValidoObtengoSuEntero() {
    String numeroRomano = "V";
    when(repositorio.guardar(anyString(), anyInt())).thenReturn(true);
    Integer numeroEnteroEsperado = 5;
    Integer numeroEnteroObtenido = servicio.romanoAEntero(numeroRomano);
    assertThat(numeroEnteroEsperado, is(numeroEnteroObtenido));
  }

  @Test
  public void cuandoIngresoMasDeUnCharEnNumeroRomanoValidoObtengoSuEntero() {
    String numeroRomano = "VII";
    when(repositorio.guardar(anyString(), anyInt())).thenReturn(true);
    Integer numeroEnteroEsperado = 7;
    Integer numeroEnteroObtenido = servicio.romanoAEntero(numeroRomano);
    assertThat(numeroEnteroEsperado, is(numeroEnteroObtenido));
  }

  @Test
  public void cuandoIngresoMasDeUnCharEnNumeroRomanoInvalidoObtengoUnaException() {
    String numeroRomanoInvalido = "VIIII";
    assertThrows(
      NumeroRomanoInvalidoException.class,
      () -> servicio.romanoAEntero(numeroRomanoInvalido)
    );
  }
}
