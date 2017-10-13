package br.ufc.qxd.agtcc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.qxd.agtcc.model.entities.Aluno;
import br.ufc.qxd.agtcc.model.entities.Usuario;
import br.ufc.qxd.agtcc.model.enums.UsuarioPapel;
import br.ufc.qxd.agtcc.service.interfaces.IAlunoService;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioService;


@Controller
@RequestMapping(path="/usuario/")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IAlunoService alunoService;

	
//	Ainda iram ser realizadas auterações nos metodos desse controller
	
	@RequestMapping(path="/")
	public String index(){
		return "redirect:/usuario/listar";
	}
	
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView model = new ModelAndView("tabs/usuario/listarUsuario");
		model.addObject("usuarios", usuarioService.findAll());
		
		return model;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public 	ModelAndView cadastrar_get(Model model){
		Usuario user = new Usuario();
		model.addAttribute("usuario", user);
		model.addAttribute("cpf", new String("cpf"));
		return new ModelAndView("tabs/usuario/cadastrarUsuario");
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public ModelAndView cadastrar_post(@ModelAttribute("cpf") String cpf,Model model, Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro",result.getAllErrors().get(0));
			return new ModelAndView("redirect:/usuario/cadastrar");
		}
		
		Aluno aluno = alunoService.findByCpf(cpf);
		if(aluno != null && aluno.getUsuario() == null) {
			usuario.setPapel(UsuarioPapel.ALUNO);
			usuarioService.save(usuario);
			aluno.setUsuario(usuario);
			alunoService.update(aluno);
			attributes.addFlashAttribute("mensagemSucesso", "Usuário cadastrado com sucesso!");
		} else {
			attributes.addAttribute("erro",result.getAllErrors().get(0));
			return new ModelAndView("redirect:/usuario/cadastrar");	
		}
		
		return new ModelAndView("redirect:/usuario/");
	}

	@RequestMapping(path="/remover/{id}")
	public String removerConta(@PathVariable("id") Long id, RedirectAttributes attributes){
		usuarioService.delete(id);
		if(usuarioService.findOne(id) == null){
			attributes.addFlashAttribute("mensagemSucesso", "Usuário removido com sucesso!");
		}
		return "redirect:/usuario/";
	}
	
	
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public 	String editar(@PathVariable("id") Long id, Model model){
		model.addAttribute("currentUsuario", usuarioService.findOne(id));
		return "tabs/usuario/editarUsuario";
	}
	
	@RequestMapping(path={"/editar/{id}"}, method=RequestMethod.POST)
	public String editar_post(@PathVariable("id") Long id, Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro",result.getAllErrors().get(0));
			return "redirect:/usuario/editar/"+(usuario.getId());
		}
		usuarioService.update(usuario);
		attributes.addFlashAttribute("mensagemSucesso", "Usuário cadastrado com sucesso!");
		return "redirect:/usuario/";
	}
	

//	@RequestMapping(path="/pesquisarNome", method=RequestMethod.POST)
//	public ModelAndView pesquisarNome(String nome){
//		ModelAndView model = new ModelAndView("listarUsuarios");
//		model.addObject("usuarios", service.findAll());// service.findByNome(nome));
//		return model;
//	}

//	@RequestMapping(value = "/idetificar")
//  public ModelAndView getUserByRequestParamInTheUrl(@RequestParam(value="cpf", required=true) String cpf, HttpServletRequest request,
//          HttpServletResponse response) {     
//      //.. codigo .. //
//      System.out.println("Parametro de entrada: " + cpf);
//       
//      ModelAndView modelAndView = new ModelAndView("userinfo");
//       
//      //Adicionando o userId na página userinfo 
//      modelAndView.addObject("userId", cpf);
//       
//      return modelAndView;
//  }
		

	
	
}
