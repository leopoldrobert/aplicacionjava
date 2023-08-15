package com.pruebas.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TarjetaCredito {
	
	private long id_tarjeta_credito;
	private long numeroTarjeta;
	private Persona persona;
	private double importe;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
	private Date fechaVencimiento;
	private Date fechaActual;
	private MarcaTarjeta marca; //VISA, NARA, etc
	private String marcaTarjeta;
	

	
	public long getId_tarjeta_credito() {
		return id_tarjeta_credito;
	}
	public void setId_tarjeta_credito(long id_tarjeta_credito) {
		this.id_tarjeta_credito = id_tarjeta_credito;
	}
	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	
//	public String getMarcaTarjeta() {
//		return marcaTarjeta;
//	}
//	public void setMarcaTarjeta(String marcaTarjeta) {
//		this.marcaTarjeta = marcaTarjeta;
//	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public TarjetaCredito() {
		super();
	}
	public MarcaTarjeta getMarca() {
		return marca;
	}
	public void setMarca(MarcaTarjeta marca) {
		this.marca = marca;
	}
	
	
	public TarjetaCredito(long id_tarjeta_credito, long numeroTarjeta, Persona persona, double importe,
			Date fechaVencimiento, Date fechaActual, MarcaTarjeta marca) {
		super();
		this.id_tarjeta_credito = id_tarjeta_credito;
		this.numeroTarjeta = numeroTarjeta;
		this.persona = persona;
		this.importe = importe;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaActual = fechaActual;
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "TarjetaCredito [numeroTarjeta=" + numeroTarjeta + ", persona=" + persona + ", importe=" + importe
				+ ", fechaVencimiento=" + fechaVencimiento + ", fechaActual=" + fechaActual + ", marca=" + marca + "]";
	}

	
		
}
