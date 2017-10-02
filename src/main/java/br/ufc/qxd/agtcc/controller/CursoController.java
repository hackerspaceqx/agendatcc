package br.ufc.qxd.agtcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.qxd.agtcc.model.entities.Curso;
import br.ufc.qxd.agtcc.service.interfaces.ICursoService;

@Controller
@RequestMapping(path="/curso/")
public class CursoController {
	
	@Autowired
	ICursoService cursoService;
	
	
	@RequestMapping(path="/")
	public String index(){
		return "redirect:/curso/listar";
	}
	
	
	//Chamanda da page
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public 	String cadastrar(Model model){
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		return "/tabs/curso/cadastrarCurso";
	}

	//Chamanda do botao cadastrar
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrar_post(Curso curso, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/curso/cadastrar";
		}
		cursoService.save(curso);
		attributes.addFlashAttribute("mensagemSucesso", "Curso cadastrado com sucesso!");
		return "redirect:/curso/";
	}
	
	
	//PAGE
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public 	String editar(@PathVariable("id") Long id, Model model){
		model.addAttribute("currentCurso", cursoService.findOne(id));
		return "/tabs/curso/editarCurso";
	}
	
	//Metodo do botao
	@RequestMapping(path={"/editar/{id}"}, method=RequestMethod.POST)
	public String editar_post(@PathVariable("id") Long id, Curso curso, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/curso/editar/"+(curso.getId());
		}
		cursoService.save(curso);
		attributes.addFlashAttribute("mensagemSucesso", "Curso editado com sucesso!");
		return "redirect:/curso/";
	}
		
	//Metodo do botao	
	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Long id, RedirectAttributes attributes){
		cursoService.delete(id);
		if(cursoService.findOne(id) == null){
			attributes.addFlashAttribute("mensagemSucesso", "Curso removido com sucesso!");
		}
		return "redirect:/curso/";
	}
		
	//PAGE
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("tabs/curso/listarCurso");
		model.addObject("cursos", cursoService.findAll());
		return model;
	}
	
}
