package com.tallerwebi.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tallerwebi.dominio.excepcion.NumeroRomanoInvalidoException;

public class ConversorRomanoAEnteroTest {
    ConversorRomanoAEntero conversor;
    @BeforeEach
    public void init(){
    this.conversor = new ConversorRomanoAEntero();
    }
    
    @Test
public void cuandoIngresoUnSoloCharEnNumeroRomanoValidoObtengoSuEntero(){
String numeroRomano = "V";
Integer numeroEnteroEsperado = 5;
Integer numeroEnteroObtenido = conversor.romanoAEntero(numeroRomano);
assertEquals(numeroEnteroEsperado, numeroEnteroObtenido);
}
@Test
public void cuandoIngresoMasDeUnCharEnNumeroRomanoValidoObtengoSuEntero(){
String numeroRomano = "VII";
Integer numeroEnteroEsperado = 7;
Integer numeroEnteroObtenido = conversor.romanoAEntero(numeroRomano);
assertEquals(numeroEnteroEsperado, numeroEnteroObtenido);
}
@Test
public void cuandoIngresoMasDeUnCharEnNumeroRomanoInvalidoObtengoUnaException(){
String numeroRomanoInvalido = "VIIII";
assertThrows(NumeroRomanoInvalidoException.class, ()-> conversor.romanoAEntero(numeroRomanoInvalido));
}
}
