package com.pruebas.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pruebas.model.MarcaTarjeta;
import com.pruebas.model.Persona;
import com.pruebas.model.TarjetaCredito;

public class TarjetareditoTest {

	public static double GASTOS_VALIDOS = 1000;
	
	public static void main(String[] args) throws ParseException {
		
//	
		/*----------metodo que devulve toda la informacion de una Tarjeta----------------*/
		
				TarjetaCredito tarjeta = new TarjetaCredito();
				TarjetaCredito tarjeta1 =  finTarjetaById(tarjeta);
				System.out.println("DETALLE DE LA TARJETA: "+tarjeta1.toString());
		
		/*---------- informar si una operacion es valida----------------*/
	
		              isValidaOperacion(tarjeta);
		        	  
		/*----------valida si una tarjeta es valida ----------------*/
		           
		              isValidaTarjeta(tarjeta);
		        	  
		  /*---------- diferencia distintas tarjeta----------------*/
		              
		              identificadorTarjeta(tarjeta);
		              
		  /*----------metodo que obtiene tasa y informa la marca de la tarjeta----------------*/
		           try {
		              //double importeTotal = calcularTasaPoServicio(tarjeta) * tarjeta.getImporte();
		        	   double importeTotal  = calcularImportePorTasa(tarjeta);
		        	     System.out.println("MARCA DE LA TARJETA ES: "+tarjeta.getMarca() + ","+" IMPORTE: "+importeTotal);
		        	    } catch (Exception e) {
		        	    	
		        	      System.err.println("ERROR"+e.getMessage());
		        	    }
      }
	
	private static TarjetaCredito finTarjetaById(TarjetaCredito tarjeta) throws ParseException{
		String fechaVencida = "2024-01-01";
    	String fechaActual = "2023-08-14";

    	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    	Date fecha1 = formato.parse(fechaVencida);
    	Date fecha2 = formato.parse(fechaActual);
		
		
		//seteamos los datos la TarjetaCredito
		tarjeta.setId_tarjeta_credito(1);
		tarjeta.setNumeroTarjeta(1222333);
		tarjeta.setImporte(900);
		tarjeta.setMarca(MarcaTarjeta.NARA);
		tarjeta.setFechaVencimiento(fecha1); 
		tarjeta.setFechaActual(fecha2);
		
		//seteamos los datos la persona
		Persona persona = new Persona ();
		persona.setNombre("Eldars");
		persona.setApellido("Soluciones");
		tarjeta.setPersona(persona);
		
		return tarjeta;
	}
	
	//validar operacion
	private static boolean  isValidaOperacion(TarjetaCredito tarjeta) {
		
    	if(tarjeta != null) {
			if(tarjeta.getImporte() < GASTOS_VALIDOS) {	
				System.out.println("LA OPERACION ES VALIDA :"+tarjeta.getImporte());
				return true;
			}
    	}
    	
		return false;
	}
    
    //validar tarjeta
    private static boolean isValidaTarjeta(TarjetaCredito tarjeta) throws ParseException {
    	
    	String fechaVencida = "2024-01-01";
    	String fechaAct = "2023-08-14";

    	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    	Date fechaVencimiento = formato.parse(fechaVencida);
    	Date fechaActual = formato.parse(fechaAct);
    			
		if(tarjeta != null) {	
			
			if(fechaVencimiento.after(fechaActual)) {
				 System.out.println("LA TARJETA ES VALIDA ");
				 
			return	true;
		}
		}
		return false;
	}

     //validar la tasa
    private static double calcularTasaPorServicio(TarjetaCredito tarjeta) {
		
		double tasa = 0;
		
		if (tarjeta.getMarca().equals(MarcaTarjeta.AMEX)) {
			tasa = tarjeta.getFechaVencimiento().getMonth()* 0.1; //mes *0.1
		} else { 
				if (tarjeta.getMarca().equals(MarcaTarjeta.NARA)) { // dia * 0.5
					tasa = tarjeta.getFechaVencimiento().getDay() * 0.5;
			} else {					
				if (tarjeta.getMarca().equals(MarcaTarjeta.VISA)) { //año/mes
					
					tasa = tarjeta.getFechaVencimiento().getYear()/tarjeta.getFechaVencimiento().getMonth();	
				}
			}
		}
		
		return tasa;
		
	}
    
	private static double calcularImportePorTasa(TarjetaCredito tarjeta) {

		double importeTotal = calcularTasaPorServicio(tarjeta) * tarjeta.getImporte();

		return importeTotal;
    }
    
	private static String identificadorTarjeta(TarjetaCredito tarjeta){
		 
		 if (tarjeta.getMarca().equals(MarcaTarjeta.AMEX)) {
			 System.out.println("LA TARJETA ES: "+MarcaTarjeta.AMEX);
			} else { 
					if (tarjeta.getMarca().equals(MarcaTarjeta.NARA)) { 
						System.out.println("LA TARJETA ES: "+MarcaTarjeta.NARA);
				} else {					
					if (tarjeta.getMarca().equals(MarcaTarjeta.VISA)) { 
						System.out.println("LA TARJETA ES: "+MarcaTarjeta.VISA);
					}
				}
			}
		return null;
	 }
    
}


