package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Miembro;
import com.example.demo.models.MiembroTabla;
import com.example.demo.models.Pago;
import com.example.demo.service.RestFulService;

@Controller
public class ApiController {

	@Autowired
	RestFulService rest;

	@GetMapping("/")
	public String get(ModelMap model, @CookieValue(value = "empleado", required = false) String cookie) {
	
		return "redirect:/1";
	}

	@GetMapping("/{idSucursal}")
	public String gett(ModelMap model, @CookieValue(value = "empleado", required = false) String cookie,
			@PathVariable int idSucursal) {
	
		return render(cookie, model, idSucursal);
	}

	private String render(String cookie, ModelMap model, int idSucursal) {
		java.sql.Date fecha = new java.sql.Date(new java.util.Date().getTime()-(1000*60*60*60*24*30));
		
		if (cookie == null) {
			return "index";
		} else {
			List<MiembroTabla> lista = new ArrayList<MiembroTabla>();
			for (Miembro m : rest.getMiembros(idSucursal)) {
				Pago ultimo = rest.ultimoPago(m.getId());
				lista.add(new MiembroTabla( (fecha.after(ultimo.getFecha()))?"Atrasado":"Al día" , 
						ultimo.getFecha(), m.getId(), m.getNombre(),
						m.isMasculino(), m.isActivo(), m.getSucursal_id(), m.getFechaingreso()));
			}
			model.addAttribute("empleado", rest.getEmpleado(Integer.parseInt(cookie)));
			model.addAttribute("sucursales", rest.getSucursals());
			model.addAttribute("miembros", lista);
			return "miembros";
		}
	}
}