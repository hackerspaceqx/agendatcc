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

import br.ufc.qxd.agtcc.model.entities.Aluno;
import br.ufc.qxd.agtcc.model.enums.FormaTratamento;
import br.ufc.qxd.agtcc.model.enums.Genero;
import br.ufc.qxd.agtcc.model.enums.Nacionalidade;
import br.ufc.qxd.agtcc.service.interfaces.IAlunoService;
import br.ufc.qxd.agtcc.service.interfaces.ICursoService;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioPapelService;

@Controller
@RequestMapping(path="/aluno/")
public class AlunoController {
	
	@Autowired
	IAlunoService alunoService;
	
	@Autowired
	IUsuarioPapelService usuarioPapelService;
	
	@Autowired
	ICursoService cursoService;
	
	@RequestMapping(path="/")
	public String index(){
		return "redirect:/aluno/listar";
	}
	
	
	//Chamanda da page
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public 	String cadastrar(Model model){
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		model.addAttribute("papeis", usuarioPapelService.findAll());
		model.addAttribute("cursos", cursoService.findAll());
		model.addAttribute("generos", Genero.values());
		model.addAttribute("nacionalidades", Nacionalidade.values());
		model.addAttribute("formasDeTratamento", FormaTratamento.values());
		
		return "/tabs/aluno/cadastrarAluno";
	}

	//Chamanda do botao cadastrar
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrar_post(Aluno aluno, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/aluno/cadastrar";
		}
		
//		Matricula novaMatricula = matriculaService.save(matricula);
//		aluno.setMatricula(novaMatricula);

		alunoService.save(aluno);
		
		attributes.addFlashAttribute("mensagemSucesso", "Aluno cadastrado com sucesso!");
		return "redirect:/aluno/";
	}
	
	
	//PAGE
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public 	String editar(@PathVariable("id") Long id, Model model){
		model.addAttribute("currentAluno", alunoService.findOne(id));
		model.addAttribute("cursos", cursoService.findAll());
		model.addAttribute("papeis", usuarioPapelService.findAll());
		model.addAttribute("generos", Genero.values());
		model.addAttribute("nacionalidades", Nacionalidade.values());
		model.addAttribute("formasDeTratamento", FormaTratamento.values());

		return "/tabs/aluno/editarAluno";
	}
	
	//Metodo do botao
	@RequestMapping(path={"/editar/{id}"}, method=RequestMethod.POST)
	public String editar_post(@PathVariable("id") Long id, Aluno aluno, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/aluno/editar/"+(aluno.getId());
		}
		alunoService.save(aluno);
		attributes.addFlashAttribute("mensagemSucesso", "Aluno editado com sucesso!");
		return "redirect:/aluno/";
	}
		
	//Metodo do botao	
	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Long id, RedirectAttributes attributes){
		alunoService.delete(id);
		if(alunoService.findOne(id) == null){
			attributes.addFlashAttribute("mensagemSucesso", "Aluno removido com sucesso!");
		}
		return "redirect:/aluno/";
	}
		
	//PAGE
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("tabs/aluno/listarAluno");
		model.addObject("alunos", alunoService.findAll());
		return model;
	}
	
}
