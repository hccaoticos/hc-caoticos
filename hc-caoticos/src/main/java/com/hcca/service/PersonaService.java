package com.hcca.service;

import javax.servlet.http.HttpSession;

import com.hcca.bean.PersonaBean;
import com.hcca.model.Persona;

public interface PersonaService {
	public PersonaBean getInformationPerfil(HttpSession request);
	public boolean editInformacionPerfil(PersonaBean perbean,HttpSession session);
}
