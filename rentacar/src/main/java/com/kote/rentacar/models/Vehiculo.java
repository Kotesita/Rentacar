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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="vehiculo")
public class Vehiculo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotNull(message = "El campo no debe estar vacío")
		private String patente;
		
		@NotNull(message = "El campo no debe estar vacío")
		private String marca;
		
		@NotNull(message = "El campo no debe estar vacío")
		private String modelo;
		
		private Integer anio;
		
		private Float kilometros;
		
		private Float cilindrada;
		
		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="id_automovil")
		@NotNull(message = "El campo no debe estar vacío")
	    private Automovil automovil;
		
		@OneToMany(mappedBy="vehiculo", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	    private List<Mantencion> mantenciones;
		
		@Column(updatable=false)
		private Date createdAt;
		
		private Date updatedAt;

		public Vehiculo() {
		}
		
		public Vehiculo(String patente, String marca, String modelo) {
			this.patente = patente;
			this.marca = marca;
			this.modelo = modelo;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getPatente() {
			return patente;
		}

		public void setPatente(String patente) {
			this.patente = patente;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public Integer getAnio() {
			return anio;
		}

		public void setAnio(Integer anio) {
			this.anio = anio;
		}

		public Float getKilometros() {
			return kilometros;
		}

		public void setKilometros(Float kilometros) {
			this.kilometros = kilometros;
		}

		public Float getCilindrada() {
			return cilindrada;
		}

		public void setCilindrada(Float cilindrada) {
			this.cilindrada = cilindrada;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Automovil getAutomovil() {
			return automovil;
		}

		public void setAutomovil(Automovil automovil) {
			this.automovil = automovil;
		}

		public List<Mantencion> getMantenciones() {
			return mantenciones;
		}

		public void setMantenciones(List<Mantencion> mantenciones) {
			this.mantenciones = mantenciones;
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
