package com.tallerwebi.dominio;

public interface ServicioRomanoAEntero {
  public Integer romanoAEntero(String romano);

  public Boolean verificarCaracteres(String romano);

  public Boolean verificarQueNoSeRepitaLaMismaLetraTresVeces(String romano);
}
