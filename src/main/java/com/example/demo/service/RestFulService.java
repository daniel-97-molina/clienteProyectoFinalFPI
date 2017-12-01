package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Empleado;
import com.example.demo.models.Miembro;
import com.example.demo.models.Sucursal;

@Service
public class RestFulService {

	private RestTemplate restService;
	
	@Value("${restUrl}")
	private String apiUrl;
	
	private RestFulService() {
		restService = new RestTemplate();
	}

	public ArrayList<Sucursal> getSucursals() {
		return new ArrayList<Sucursal>(Arrays.asList(restService.getForObject(apiUrl+"sucursals",Sucursal[].class)));
	}
	public Empleado getEmpleado(int idEmpleado) {
		return restService.getForObject(apiUrl+"empleados/"+idEmpleado,Empleado.class);
	}
	public ArrayList<Miembro> getMiembros(int idSucursal) {
		return new ArrayList<Miembro>(Arrays.asList(restService.getForObject(apiUrl+"sucursals/"+idSucursal+"/miembros/",Miembro[].class)));
	}
	public  getEmpleado(int idEmpleado) {
		return restService.getForObject(apiUrl+"empleados/"+idEmpleado,Empleado.class);
	}
}
