package com.kote.rentacar.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Automovil")
public class Automovil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer num_puertas;
	
	private Integer cap_pasajeros;
	
	private Float cap_maleta;
	
	private Float cap_toneladas;
	
	private Integer num_ejes;
	
	@OneToMany(mappedBy="automovil", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;
	
	@NotNull(message = "El campo no debe estar vacío")
	private String tipo;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;

	public Automovil() {
	}
	
	public Automovil(String tipo) {
		this.tipo = tipo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum_puertas() {
		return num_puertas;
	}

	public void setNum_puertas(Integer num_puertas) {
		this.num_puertas = num_puertas;
	}

	public Integer getCap_pasajeros() {
		return cap_pasajeros;
	}

	public void setCap_pasajeros(Integer cap_pasajeros) {
		this.cap_pasajeros = cap_pasajeros;
	}

	public Float getCap_maleta() {
		return cap_maleta;
	}

	public void setCap_maleta(Float cap_maleta) {
		this.cap_maleta = cap_maleta;
	}

	public Float getCap_toneladas() {
		return cap_toneladas;
	}

	public void setCap_toneladas(Float cap_toneladas) {
		this.cap_toneladas = cap_toneladas;
	}

	public Integer getNum_ejes() {
		return num_ejes;
	}

	public void setNum_ejes(Integer num_ejes) {
		this.num_ejes = num_ejes;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	 
	@PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	
}
