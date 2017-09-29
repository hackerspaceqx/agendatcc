package br.ufc.qxd.agtcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.ufc.qxd.agtcc.service.interfaces.IUsuarioPapelService;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IUsuarioPapelService usuarioPapelService;
	
}
