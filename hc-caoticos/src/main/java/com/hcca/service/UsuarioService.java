package com.hcca.service;

import javax.servlet.http.HttpSession;

import com.hcca.bean.PersonaBean;
import com.hcca.model.Usuario;

public interface UsuarioService {

	boolean login(Usuario usu, HttpSession session);
	boolean registro(PersonaBean repb);
}
