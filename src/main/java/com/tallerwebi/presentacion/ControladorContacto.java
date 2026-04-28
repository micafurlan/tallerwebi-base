package com.tallerwebi.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorContacto {

  private static final String VISTA_CONTACTO = "contacto";
  private static final String VISTA_CONFIRMACION = "confirmacion";
  private static final String ATRIBUTO_CONTACTO = "contacto";
  private static final String URL_CONTACTO = "/contacto";

  @GetMapping(URL_CONTACTO)
  public ModelAndView mostrarFormulario() {
    ModelMap modelo = new ModelMap();
    modelo.put(ATRIBUTO_CONTACTO, new Contacto());
    return new ModelAndView(VISTA_CONTACTO, modelo);
  }

  @PostMapping(URL_CONTACTO)
  public ModelAndView procesarFormulario(@ModelAttribute(ATRIBUTO_CONTACTO) Contacto contacto) {
    ModelMap modelo = new ModelMap();
    modelo.put(ATRIBUTO_CONTACTO, contacto);
    return new ModelAndView(VISTA_CONFIRMACION, modelo);
  }
}
