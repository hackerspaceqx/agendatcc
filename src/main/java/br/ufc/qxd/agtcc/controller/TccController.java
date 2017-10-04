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

import br.ufc.qxd.agtcc.model.entities.Tcc;
import br.ufc.qxd.agtcc.model.enums.StatusTcc;
import br.ufc.qxd.agtcc.service.interfaces.IAlunoService;
import br.ufc.qxd.agtcc.service.interfaces.IProfessorService;
import br.ufc.qxd.agtcc.service.interfaces.ITccService;

@Controller
@RequestMapping(path="/tcc/")
public class TccController {
	
	@Autowired
	ITccService tccService;

	@Autowired
	IAlunoService alunoService;

	@Autowired
	IProfessorService professorService;
	
	@RequestMapping(path="/")
	public String index(){
		return "redirect:/tcc/listar";
	}
	
	
	//Chamanda da page
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public 	String cadastrar(Model model){
		Tcc tcc = new Tcc();
		model.addAttribute("tcc", tcc);
		model.addAttribute("alunos", alunoService.findAll());
		model.addAttribute("orientadores", professorService.findAll());
		model.addAttribute("statusTcc", StatusTcc.values());
		return "/tabs/tcc/cadastrarTcc";
	}

	//Chamanda do botao cadastrar
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrar_post(Tcc tcc, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/tcc/cadastrar";
		}
		tccService.save(tcc);
		attributes.addFlashAttribute("mensagemSucesso", "Tcc cadastrado com sucesso!");
		return "redirect:/tcc/";
	}
	
	//PAGE
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public 	String editar(@PathVariable("id") Long id, Model model){
		model.addAttribute("currentTcc", tccService.findOne(id));
		model.addAttribute("alunos", alunoService.findAll());
		model.addAttribute("orientadores", professorService.findAll());
		model.addAttribute("statusTcc", StatusTcc.values());

		return "/tabs/tcc/editarTcc";
	}
	
	//Metodo do botao
	@RequestMapping(path={"/editar/{id}"}, method=RequestMethod.POST)
	public String editar_post(@PathVariable("id") Long id, Tcc tcc, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/tcc/editar/"+(tcc.getId());
		}
		tccService.save(tcc);
		attributes.addFlashAttribute("mensagemSucesso", "Tcc editado com sucesso!");
		return "redirect:/tcc/";
	}
		
	//Metodo do botao	
	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Long id, RedirectAttributes attributes){
		tccService.delete(id);
		if(tccService.findOne(id) == null){
			attributes.addFlashAttribute("mensagemSucesso", "Tcc removido com sucesso!");
		}
		return "redirect:/tcc/";
	}
		
	//PAGE
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("tabs/tcc/listarTcc");
		model.addObject("tccs", tccService.findAll());
		return model;
	}
	
}
