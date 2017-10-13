package br.ufc.qxd.agtcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {


	@GetMapping("/")
	public String index() {
		return "/home";
	}

	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

	@GetMapping("/user")
	public String user() {
		return "/user";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/teste")
	public String register() {
		return "/testeNewLayout/conteudo";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}


//ROTAS
	@GetMapping("/aluno")
	public String aluno(){
		return "redirect:/aluno/";
	}
	
	@GetMapping("/professor")
	public String professor(){
		return "redirect:/professor/";
	}
	
	@GetMapping("/curso")
	public String curso(){
		return "redirect:/curso/";
	}

	@GetMapping("/tcc")
	public String tcc(){
		return "redirect:/tcc/";
	}

	@GetMapping("/defesa")
	public String defesa(){
		return "redirect:/defesa/";
	}
	
	@GetMapping("/usuario")
	public String usuario(){
		return "redirect:/usuario/";
	}
	
	
}
