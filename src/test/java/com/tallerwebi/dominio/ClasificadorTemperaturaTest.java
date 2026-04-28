package com.tallerwebi.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClasificadorTemperaturaTest {

  RepositorioTemperatura repositorio;
  ServicioTemperatura servicio;

  @BeforeEach
  public void init() {
    this.repositorio = mock(RepositorioTemperatura.class);
    this.servicio = new ServicioTemperaturaImpl(this.repositorio);
  }

  @Test
  public void cuandoIngresoCeroGradosCellsiusSeClasificaCongelante() {
    Integer temperaturaCongelante = 0;
    when(repositorio.guardar(anyInt(), anyString())).thenReturn(true);
    String clasificacionObtenida = servicio.clasificarTemperatura(temperaturaCongelante);
    String clasificacionEsperada = ClasificacionTemperatura.CONGELANTE.name();
    assertThat(clasificacionEsperada, is(clasificacionObtenida));
  }

  @Test
  public void cuandoIngresoUnGradoCellsiusSeClasificaFria() {
    Integer temperaturaFria = 1;
    when(repositorio.guardar(anyInt(), anyString())).thenReturn(true);
    String clasificacionObtenida = servicio.clasificarTemperatura(temperaturaFria);
    String clasificacionEsperada = ClasificacionTemperatura.FRIA.name();
    assertThat(clasificacionEsperada, is(clasificacionObtenida));
  }

  @Test
  public void cuandoIngresoDieciseisGradosCellsiusSeClasificaTEMPLADA() {
    Integer temperaturaTemplada = 16;
    when(repositorio.guardar(anyInt(), anyString())).thenReturn(true);
    String clasificacionObtenida = servicio.clasificarTemperatura(temperaturaTemplada);
    String clasificacionEsperada = ClasificacionTemperatura.TEMPLADA.name();
    assertThat(clasificacionEsperada, is(clasificacionObtenida));
  }

  @Test
  public void cuandoIngresoVeintiseisGradosCellsiusSeClasificaCALUROSA() {
    Integer temperaturaCalurosa = 26;
    when(repositorio.guardar(anyInt(), anyString())).thenReturn(true);
    String clasificacionObtenida = servicio.clasificarTemperatura(temperaturaCalurosa);
    String clasificacionEsperada = ClasificacionTemperatura.CALUROSA.name();
    assertThat(clasificacionEsperada, is(clasificacionObtenida));
  }

  @Test
  public void cuandoIngresoVeintiseisGradosCellsiusSeClasificaPELIGROSA() {
    Integer temperaturaPeligrosa = 36;
    when(repositorio.guardar(anyInt(), anyString())).thenReturn(true);
    String clasificacionObtenida = servicio.clasificarTemperatura(temperaturaPeligrosa);
    String clasificacionEsperada = ClasificacionTemperatura.PELIGROSA.name();
    assertThat(clasificacionEsperada, is(clasificacionObtenida));
  }

  @Test
  public void cuandoIngresoSetentaYOchoComaOchoGradosFahrenheitSeClasificaCALUROSA() {
    Double temperaturaCalurosa = 78.8;
    when(repositorio.guardar(anyInt(), anyString())).thenReturn(true);
    String clasificacionEsperada = ClasificacionTemperatura.CALUROSA.name();
    String clasificacionObtenida = servicio.clasificarTemperaturaFahrenheit(temperaturaCalurosa);
    assertThat(clasificacionEsperada, is(clasificacionObtenida));
  }

  @Test
  public void cuandoIngresoMenosUnoYLaLetraEfeSeClasificaCongelante() {
    String temperaturaCongelante = "-1";
    when(repositorio.guardar(anyInt(), anyString())).thenReturn(true);
    String clasificacionObtenida = servicio.clasificarTemperaturaEnString(temperaturaCongelante);
    String clasificacionEsperada = ClasificacionTemperatura.CONGELANTE.name();
    assertThat(clasificacionEsperada, is(clasificacionObtenida));
  }
}
