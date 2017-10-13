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

import br.ufc.qxd.agtcc.model.entities.Defesa;
import br.ufc.qxd.agtcc.service.interfaces.IDefesaService;

@Controller
@RequestMapping(path="/defesa/")
public class DefesaController {
	
	@Autowired
	IDefesaService defesaService;
		
	@RequestMapping(path="/")
	public String index(){
		return "redirect:/defesa/listar";
	}
	
	//Chamanda da page
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public 	String cadastrar(Model model){
		Defesa defesa = new Defesa();
		model.addAttribute("defesa", defesa);
		return "/tabs/defesa/cadastrarDefesa";
	}

	//Chamanda do botao cadastrar
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrar_post(Defesa defesa, BindingResult result, RedirectAttributes attributes) throws ParseException{
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/defesa/cadastrar";
		}		
		
		defesaService.save(defesa);
		attributes.addFlashAttribute("mensagemSucesso", "Defesa cadastrado com sucesso!");
		return "redirect:/defesa/";
	}
	
	
	//PAGE
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public 	String editar(@PathVariable("id") Long id, Model model){
		model.addAttribute("currentDefesa", defesaService.findOne(id));
		return "/tabs/defesa/editarDefesa";
	}
	
	//Metodo do botao
	@RequestMapping(path={"/editar/{id}"}, method=RequestMethod.POST)
	public String editar_post(@PathVariable("id") Long id, Defesa defesa, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro", result.getAllErrors().get(0));
			return "redirect:/defesa/editar/"+(defesa.getId());
		}
		defesaService.save(defesa);
		attributes.addFlashAttribute("mensagemSucesso", "Defesa editado com sucesso!");
		return "redirect:/defesa/";
	}
		
	//Metodo do botao	
	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Long id, RedirectAttributes attributes){
		defesaService.delete(id);
		if(defesaService.findOne(id) == null){
			attributes.addFlashAttribute("mensagemSucesso", "Defesa removido com sucesso!");
		}
		return "redirect:/defesa/";
	}
		
	//PAGE
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("tabs/defesa/listarDefesa");
		model.addObject("defesas", defesaService.findAll());
		return model;
	}
	
}
