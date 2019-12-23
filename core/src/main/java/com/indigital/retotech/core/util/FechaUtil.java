package com.indigital.retotech.core.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.ThreadLocalRandom;

public class FechaUtil {
	
	private static final int EDAD_MAXIMA = 122;
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	
	public static String convertirLocalDateAstring(LocalDate fecha) {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATO_FECHA);
		return fecha.format(formato);
	}
	
	public static LocalDate convertirStringAlocalDate(String fechaString) throws Exception {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATO_FECHA);
		
		LocalDate fecha;
		
		try {
			fecha = LocalDate.parse(fechaString, formato);
			
		} catch (DateTimeParseException e) {
			throw new Exception(String.format("Debe ingresar la fecha en el formato %s", FORMATO_FECHA));
		}
		
		return fecha;
	}
		
	public static String obtenerFechaProbableMuerte(LocalDate fechaNacimientoParam) {
		    
        LocalDate maximaFechaProbableMuerte = obtenerMaximaFechaProbableMuerte(fechaNacimientoParam, EDAD_MAXIMA);
        
        long randomDay = ThreadLocalRandom.current().nextLong(LocalDate.now().toEpochDay(), maximaFechaProbableMuerte.toEpochDay());
        
        LocalDate fechaProbableMuerte = LocalDate.ofEpochDay(randomDay);
        
        return convertirLocalDateAstring(fechaProbableMuerte);
    }
	

	public static LocalDate obtenerMaximaFechaProbableMuerte(LocalDate fecha, int anios) {
		
		return fecha.withYear(fecha.getYear() + anios);
	}
	
	public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if ((fechaNacimiento != null) && (fechaActual != null)) {
            return Period.between(fechaNacimiento, fechaActual).getYears();
        } else {
            return 0;
        }
    }

}
