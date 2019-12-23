package com.indigital.retotech.cliente.dto;

import java.math.BigDecimal;

public class KpiCliente {
	
	private BigDecimal promedioEdades;
	
	private BigDecimal desviacionEstandarEdades;

	public BigDecimal getPromedioEdades() {
		return promedioEdades;
	}

	public void setPromedioEdades(BigDecimal promedioEdades) {
		this.promedioEdades = promedioEdades;
	}

	public BigDecimal getDesviacionEstandarEdades() {
		return desviacionEstandarEdades;
	}

	public void setDesviacionEstandarEdades(BigDecimal desviacionEstandarEdades) {
		this.desviacionEstandarEdades = desviacionEstandarEdades;
	}

	@Override
	public String toString() {
		return "KpiCliente [promedioEdades=" + promedioEdades
				+ ", desviacionEstandarEdades=" + desviacionEstandarEdades
				+ "]";
	}
}
