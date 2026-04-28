package com.tallerwebi.dominio.excepcion;

public class NumeroRomanoInvalidoException extends RuntimeException {

  private static final long serialVersionUID = 1L; // agregá esta línea

  public NumeroRomanoInvalidoException(String descripcion) {
    super(descripcion); // también corregí esto — ver error 4
  }
}
