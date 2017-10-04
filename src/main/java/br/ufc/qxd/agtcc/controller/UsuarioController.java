package br.ufc.qxd.agtcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.qxd.agtcc.model.entities.Usuario;
import br.ufc.qxd.agtcc.model.enums.UsuarioPapel;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioService;


@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	
//	Ainda iram ser realizadas auterações nos metodos desse controller
	
	
	private void getListUsuario(ModelAndView model, String tipo){
		model.addObject("usuarios", usuarioService.findAll());
	}
	
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ModelAndView todos(@RequestParam String tipo){
		ModelAndView model = new ModelAndView("listarUsuarios");
		getListUsuario(model, tipo);
		return model;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public 	String cadastrar(Model model){
		Usuario user = new Usuario();
		model.addAttribute("usuario", user);
		model.addAttribute("papeis", UsuarioPapel.values());
		return "cadastrarUsuario";
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
		model.addAttribute("currentUser", usuarioService.findOne(id));
		model.addAttribute("papeis", UsuarioPapel.values());
		return "editarUsuario";
	}
	
	@RequestMapping(path={"/editar/{id}"}, method=RequestMethod.POST)
	public String editar_post(@PathVariable("id") Long id, Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro",result.getAllErrors().get(0));
			return "redirect:/usuario/editar/"+(usuario.getId());
		}
		usuarioService.save(usuario);
		attributes.addFlashAttribute("mensagemSucesso", "Usuário cadastrado com sucesso!");
		return "redirect:/usuario/";
	}
	
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrar_post(Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			attributes.addAttribute("erro",result.getAllErrors().get(0));
			return "redirect:/usuario/cadastrar";
		}
		usuarioService.save(usuario);
		attributes.addFlashAttribute("mensagemSucesso", "Usuário cadastrado com sucesso!");
		return "redirect:/usuario/";
	}
	
//	@RequestMapping(path="/pesquisarNome", method=RequestMethod.POST)
//	public ModelAndView pesquisarNome(String nome){
//		ModelAndView model = new ModelAndView("listarUsuarios");
//		model.addObject("usuarios", service.findAll());// service.findByNome(nome));
//		return model;
//	}
	
}
