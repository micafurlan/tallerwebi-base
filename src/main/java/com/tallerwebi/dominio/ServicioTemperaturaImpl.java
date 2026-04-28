package com.tallerwebi.dominio;

public class ServicioTemperaturaImpl implements ServicioTemperatura {

  private RepositorioTemperatura repositorio;

  public ServicioTemperaturaImpl(RepositorioTemperatura repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public String clasificarTemperatura(Integer grados) {
    String resultado;
    if (grados <= 0) {
      resultado = ClasificacionTemperatura.CONGELANTE.name();
    } else if (grados > 0 && grados <= 15) {
      resultado = ClasificacionTemperatura.FRIA.name();
    } else if (grados > 15 && grados <= 25) {
      resultado = ClasificacionTemperatura.TEMPLADA.name();
    } else if (grados > 25 && grados <= 35) {
      resultado = ClasificacionTemperatura.CALUROSA.name();
    } else {
      resultado = ClasificacionTemperatura.PELIGROSA.name();
    }
    this.repositorio.guardar(grados, resultado);
    return resultado;
  }

  @Override
  public String clasificarTemperaturaFahrenheit(Double grados) {
    Integer temperaturaEnCelsius = (int) Math.round((grados - 32) / 1.8);
    return clasificarTemperatura(temperaturaEnCelsius);
  }

  @Override
  public String clasificarTemperaturaEnString(String grados) {
    Integer temperaturaEnCelsius = Integer.parseInt(grados);
    return clasificarTemperatura(temperaturaEnCelsius);
  }
}
