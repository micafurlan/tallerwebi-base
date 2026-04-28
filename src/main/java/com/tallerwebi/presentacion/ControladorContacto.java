package com.tallerwebi.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorContacto {

  @RequestMapping("/contacto")
  public ModelAndView irAContacto() {
    ModelMap modelo = new ModelMap();
    modelo.put("contacto", new Contacto());
    return new ModelAndView("contacto", modelo);
  }

  @RequestMapping(path = "/confirmacion", method = RequestMethod.POST)
  public ModelAndView irAConfirmacion(Contacto contacto) {
    ModelMap modelo = new ModelMap();
    modelo.put("contacto", contacto);
    return new ModelAndView("confirmacion", modelo);
  }
}
