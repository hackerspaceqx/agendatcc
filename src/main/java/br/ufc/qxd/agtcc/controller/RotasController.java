package br.ufc.qxd.agtcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class RotasController {

	
	
	@RequestMapping(value={"/aluno"})
	public String aluno(ModelAndView model){
		return "tabs/index";
	}
	

}
