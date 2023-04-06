package com.hotelalura.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotelalura.core.model.Usuario;
import com.hotelalura.core.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
    private UsuarioService usuarioService;
	
	private Usuario usuarioModel;
	
	@GetMapping()
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/login")
    public String processLoginForm(@ModelAttribute("usuario") Usuario usuario, HttpSession session, BindingResult bindingResult) {
		usuarioModel = usuarioService.obtenerUsuarioByEmail(usuario.getEmail());
		
        if (usuarioModel != null && usuarioModel.getPassword().equals(usuario.getPassword())) {
            session.setAttribute("user", usuarioModel);
            usuarioService.liberarHabitaciones();
            return "redirect:/index";
        } else {
            bindingResult.rejectValue("email", "error.user", "Credenciales incorrectas");
            session.removeAttribute("user");
            return "login";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
	
}
