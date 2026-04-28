package com.tallerwebi.presentacion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

public class ContactoControllerTest {

  private ControladorContacto controladorContacto;

  @BeforeEach
  public void init() {
    controladorContacto = new ControladorContacto(); //adentro del constructor iria el servicio en este caso mock
  }

  @Test
  public void cuandoEntroAContactoElControladorMeRedirigeALaVistaDeFormularioDeContacto() {
    ModelAndView modelAndView = controladorContacto.irAContacto();
    assertThat(modelAndView.getViewName(), equalToIgnoringCase("contacto"));
  }

  @Test
  public void cuandoLlenoElFormularioYSeleccionoEnviarMeRedirigeALaVistaDeConfirmacion() {
    //deberia enviar datos mockeados "llenando el formulario" y eso enviarlo pero no se como hacerlo, que metodos llamar del controlador
    Contacto contacto = new Contacto();
    contacto.setNombre("Carlos Menem");
    contacto.setEmail("carlitosmenem@yahoo.com.ar");
    contacto.setMensaje("Hola me llamo Menem");
    ModelAndView modelAndView = controladorContacto.irAConfirmacion(contacto);
    assertThat(modelAndView.getViewName(), equalToIgnoringCase("confirmacion"));
  }
}
