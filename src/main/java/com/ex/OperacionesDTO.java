package com.ex;

import java.io.Serializable;

public class OperacionesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 938288404798060608L;
	private double nro1;
	private double nro2;
	private String operacion;

	public double getNro1() {
		return nro1;
	}

	public void setNro1(double nro1) {
		this.nro1 = nro1;
	}

	public double getNro2() {
		return nro2;
	}

	public void setNro2(double nro2) {
		this.nro2 = nro2;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}
