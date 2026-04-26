package com.tallerwebi.dominio;

public class ValidadorContrasenia {
    public String validarFortaleza(String contrasenia){
        String especiales = "-_%$?!@";
        if(contrasenia == null || contrasenia.isEmpty()){
            return FortalezaContrasenia.INVALIDA.name();
        } else if (contrasenia.length()>=8 
        && contrasenia.chars().filter(Character::isLetter).count()>=4 
        && contrasenia.chars().filter(Character::isDigit).count()>=2 
        && contrasenia.chars().filter(c -> especiales.indexOf(c) != -1).count() >=2){
            return FortalezaContrasenia.FUERTE.name();
        } else if(contrasenia.length()>=8 
        && contrasenia.chars().filter(Character::isDigit).count()>= 1
        && contrasenia.chars().filter(c -> especiales.indexOf(c) != -1).count()>= 1){
            return FortalezaContrasenia.MEDIANA.name();
        }else if(contrasenia.length()<=8){
            return FortalezaContrasenia.DEBIL.name();    
        }
        return null;
    }
}
