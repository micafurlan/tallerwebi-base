package com.tallerwebi.dominio;

public class ServicioContraseniaImpl implements ServicioContrasenia {

  private RepositorioContrasenia repositorioContrasenia;

  public ServicioContraseniaImpl(RepositorioContrasenia repositorioContrasenia) {
    this.repositorioContrasenia = repositorioContrasenia;
  }

  @Override
  public String validarFortaleza(String contrasenia) {
    if (contrasenia == null || contrasenia.isEmpty()) {
      return FortalezaContrasenia.INVALIDA.name();
    }
    String resultado = calcularFortaleza(contrasenia);
    this.repositorioContrasenia.guardar(contrasenia, resultado);
    return resultado;
  }

  private boolean esEspecial(int caracter) {
    return "-_%$?!@".indexOf(caracter) != -1;
  }

  private String calcularFortaleza(String contrasenia) {
    long letras = contrasenia.chars().filter(Character::isLetter).count();
    long numeros = contrasenia.chars().filter(Character::isDigit).count();
    long caracteresEspeciales = contrasenia.chars().filter(this::esEspecial).count();

    if (contrasenia.length() >= 8 && letras >= 4 && numeros >= 2 && caracteresEspeciales >= 2) {
      return FortalezaContrasenia.FUERTE.name();
    }
    if (contrasenia.length() >= 8 && numeros >= 1 && caracteresEspeciales >= 1) {
      return FortalezaContrasenia.MEDIANA.name();
    }
    return FortalezaContrasenia.DEBIL.name();
  }
}
