package com.tallerwebi.dominio;

public class ServicioContraseniaImpl implements ServicioContrasenia {

  private RepositorioContrasenia repositorioContrasenia;

  public ServicioContraseniaImpl(RepositorioContrasenia repositorioContrasenia) {
    this.repositorioContrasenia = repositorioContrasenia;
  }

  @Override
  public String validarFortaleza(String contrasenia) {
    String resultado;
    if (contrasenia == null || contrasenia.isEmpty()) {
      resultado = FortalezaContrasenia.INVALIDA.name();
    } else {
      String especiales = "-_%$?!@"; // acá adentro, donde sí se usa siempre
      if (
        contrasenia.length() >= 8 &&
        contrasenia.chars().filter(Character::isLetter).count() >= 4 &&
        contrasenia.chars().filter(Character::isDigit).count() >= 2 &&
        contrasenia.chars().filter(c -> especiales.indexOf(c) != -1).count() >= 2
      ) {
        resultado = FortalezaContrasenia.FUERTE.name();
      } else if (
        contrasenia.length() >= 8 &&
        contrasenia.chars().filter(Character::isDigit).count() >= 1 &&
        contrasenia.chars().filter(c -> especiales.indexOf(c) != -1).count() >= 1
      ) {
        resultado = FortalezaContrasenia.MEDIANA.name();
      } else {
        resultado = FortalezaContrasenia.DEBIL.name();
      }
    }
    this.repositorioContrasenia.guardar(contrasenia, resultado);
    return resultado;
  }
}
