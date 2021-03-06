package com.kote.rentacar.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kote.rentacar.models.*;
import com.kote.rentacar.services.*;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping
public class ApplicationController {
	private final AutomovilService autoService;
	private final MantencionService mantService;
	private final VehiculoService vehiService;
		
	public ApplicationController(AutomovilService autoService, MantencionService mantService, VehiculoService vehiService) {
		this.autoService = autoService;
		this.vehiService = vehiService;
		this.mantService = mantService;
	}
	
	@PostMapping(value="/automovil", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public Automovil addAutomovil(@RequestBody Automovil auto) {
		return autoService.createAuto(auto);
	}
	
	@GetMapping(value="/automovil")
	public List<Automovil> getAllAutomoviles(){
		return autoService.allAutomoviles();
	}
	
	@GetMapping(path="/automovil/{id}")
	public Automovil getAutomovil(@PathVariable("id") Integer id){
		return autoService.unAutomovil(id);
	}
	
	@PutMapping(path="/automovil/{id}")
	public Automovil updateAutomovil(@PathVariable("id") Integer id, @RequestBody Automovil auto) throws BadHttpRequest {
		if (autoService.unAutomovil(id)!=null) {
			auto.setId(id);
			return autoService.createAuto(auto);
		}
		else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path="automovil/{id}")
	public void deleteAuto(@PathVariable("id") Integer id) throws BadHttpRequest {
		Automovil auto = autoService.unAutomovil(id);
		autoService.deleteAuto(auto);
	}
	
	@PostMapping(value="/mantencion", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public Mantencion addMantencion(@RequestBody Mantencion mant) throws BadHttpRequest {
		String patenteVehi = mant.getVehiculo().getPatente();
		if(!vehiService.allVehiculos().isEmpty()) {
			for(Vehiculo vehi : vehiService.allVehiculos()) {
				if(patenteVehi.equals(vehi.getPatente())){
					mant.setVehiculo(vehi);
				}
			}
		} 
		return mantService.createMantencion(mant);
	}
	
	@GetMapping(value="/mantencion")
	public List<Mantencion> getAllMantenciones(){
		return mantService.allMantenciones();
	}
	
	@GetMapping(path="/mantencion/{id}")
	public Mantencion getMantencion(@PathVariable("id") Integer id){
		return mantService.unaMantencion(id);
	}
	
	@PutMapping(path="/mantencion/{id}")
	public Mantencion updateMantencion(@PathVariable("id") Integer id, @RequestBody Mantencion mant) throws BadHttpRequest {
		if (mantService.unaMantencion(id)!=null) {
			mant.setId(id);
			return mantService.createMantencion(mant);
		}
		else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path="/mantencion/{id}")
	public void deleteMantencion(@PathVariable("id") Integer id) throws BadHttpRequest {
		Mantencion mant = mantService.unaMantencion(id);
		mantService.deleteMantencion(mant);
	}
	
	@PostMapping(value="/vehiculo",consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public Vehiculo addVehiculo(@RequestBody Vehiculo vehi) throws BadHttpRequest {
		if(!autoService.allAutomoviles().isEmpty()) {
			for(Automovil auto : autoService.allAutomoviles()) {
				if(vehi.getAutomovil().getTipo().equals(auto.getTipo())){
					vehi.setAutomovil(auto);
				} 
			}
		} else {
			autoService.createAuto(vehi.getAutomovil());
		}
		return vehiService.createVehiculo(vehi);
	}
	
	@GetMapping(value="/vehiculo")
	public List<Vehiculo> getAllVehiculos() throws BadHttpRequest {
		return vehiService.allVehiculos();
	}
	
	@GetMapping(path="/vehiculo/{id}")
	public Vehiculo getVehiculo(@PathVariable("id") Integer id){
		return vehiService.unVehiculo(id);
	}
	
	@PutMapping(path="/vehiculo/{id}")
	public Vehiculo updateVehiculo(@PathVariable("id") Integer id, @RequestBody Vehiculo vehi) throws BadHttpRequest {
		if (vehiService.unVehiculo(id)!=null) {
			vehi.setId(id);
			return vehiService.createVehiculo(vehi);
		}
		else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path="/vehiculo/{id}")
	public void deleteVehiculo(@PathVariable("id") Integer id) throws BadHttpRequest {
		Vehiculo vehi = vehiService.unVehiculo(id);
		vehiService.deleteVehiculo(vehi);
	}
}
