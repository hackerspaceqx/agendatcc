package br.ufc.qxd.agtcc.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.qxd.agtcc.model.entities.Professor;
import br.ufc.qxd.agtcc.model.enums.FormaTratamento;
import br.ufc.qxd.agtcc.model.enums.Genero;
import br.ufc.qxd.agtcc.model.enums.Nacionalidade;
import br.ufc.qxd.agtcc.model.enums.TitulacaoAcademica;
import br.ufc.qxd.agtcc.service.interfaces.IProfessorService;

@Controller
@RequestMapping(path="/professor/")
public class ProfessorController {
	
	@Autowired
	IProfessorService professorService;
		
	
	@RequestMapping(path="/")
	public String index(){
		return "redirect:/professor/listar";
	}
	
	
	//Chamanda da page
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public 	String cadastrar(Model model){
		Professor professor = new Professor();
		model.addAttribute("professor", professor);

		model.addAttribute("titulacoesAcademina", TitulacaoAcademica.values());
		model.addAttribute("generos", Genero.values());
		model.addAttribute("nacionalidades", Nacionalidade.values());
		model.addAttribute("formasDeTratamento", FormaTratamento.values());
		
		return "/tabs/professor/cadastrarProfessor";
	}

	//Chamanda do botao cadastrar
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrar_post(Professor professor, BindingResult result, RedirectAttributes attributes) throws ParseException{
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/professor/cadastrar";
		}
		
		professorService.save(professor);
		
		attributes.addFlashAttribute("mensagemSucesso", "Professor cadastrado com sucesso!");
		return "redirect:/professor/";
	}
	
	
	//PAGE
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public 	String editar(@PathVariable("id") Long id, Model model){
		model.addAttribute("currentProfessor", professorService.findOne(id));
		model.addAttribute("generos", Genero.values());
		model.addAttribute("nacionalidades", Nacionalidade.values());
		model.addAttribute("titulacoesAcademina", TitulacaoAcademica.values());
		model.addAttribute("formasDeTratamento", FormaTratamento.values());

		return "/tabs/professor/editarProfessor";
	}
	
	//Metodo do botao
	@RequestMapping(path={"/editar/{id}"}, method=RequestMethod.POST)
	public String editar_post(@PathVariable("id") Long id, Professor professor,BindingResult result, RedirectAttributes attributes) throws ParseException{
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/professor/editar/"+(professor.getId());
		}

		
		professorService.save(professor);
		attributes.addFlashAttribute("mensagemSucesso", "Professor editado com sucesso!");
		return "redirect:/professor/";
	}
		
	//Metodo do botao	
	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Long id, RedirectAttributes attributes){
		professorService.delete(id);
		if(professorService.findOne(id) == null){
			attributes.addFlashAttribute("mensagemSucesso", "Professor removido com sucesso!");
		}
		return "redirect:/professor/";
	}
		
	//PAGE
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("tabs/professor/listarProfessor");
		model.addObject("professores", professorService.findAll());
		return model;
	}
	
}
