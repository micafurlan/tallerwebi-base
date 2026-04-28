package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.NumeroRomanoInvalidoException;

public class ServicioRomanoAEnteroImpl implements ServicioRomanoAEntero {

  private RepositorioRomanoAEntero repositorio;

  public ServicioRomanoAEnteroImpl(RepositorioRomanoAEntero repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public Integer romanoAEntero(String romano) {
    if (
      verificarCaracteres(romano) == false ||
      verificarQueNoSeRepitaLaMismaLetraTresVeces(romano) == false
    ) {
      throw new NumeroRomanoInvalidoException("Combinacion Romana Invalida");
    }
    Integer resultado = 0;
    for (int i = 0; i < romano.length(); i++) {
      char letraActual = romano.charAt(i);
      Integer enteroActual = pasarUnCharNumeroRomanoAUnNumeroDecimal(letraActual);
      if (i + 1 < romano.length()) { // ojo: < no > (esto también era un bug)
        Integer siguienteEntero = pasarUnCharNumeroRomanoAUnNumeroDecimal(romano.charAt(i + 1));
        if (enteroActual >= siguienteEntero) {
          resultado += enteroActual; // += en lugar de =
        } else if (enteroActual < siguienteEntero) {
          resultado += siguienteEntero - enteroActual; // += en lugar de =
        }
      } else {
        resultado += enteroActual;
      }
    }
    this.repositorio.guardar(romano, resultado);
    return resultado;
  }

  public Integer pasarUnCharNumeroRomanoAUnNumeroDecimal(char romano) {
    Integer entero;
    switch (romano) {
      case 'I':
        entero = 1;
        break;
      case 'V':
        entero = 5;
        break;
      case 'X':
        entero = 10;
        break;
      case 'L':
        entero = 50;
        break;
      case 'C':
        entero = 100;
        break;
      default:
        entero = 0;
        break;
    }
    return entero;
  }

  @Override
  public Boolean verificarCaracteres(String romano) {
    for (char c : romano.toCharArray()) {
      if (c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C') {
        return false;
      }
    }
    return true;
  }

  @Override
  public Boolean verificarQueNoSeRepitaLaMismaLetraTresVeces(String romano) {
    for (int i = 0; i <= romano.length() - 4; i++) {
      if (
        romano.charAt(i) == romano.charAt(i + 1) &&
        romano.charAt(i) == romano.charAt(i + 2) &&
        romano.charAt(i) == romano.charAt(i + 3)
      ) {
        return false;
      }
    }
    return true;
  }
}
