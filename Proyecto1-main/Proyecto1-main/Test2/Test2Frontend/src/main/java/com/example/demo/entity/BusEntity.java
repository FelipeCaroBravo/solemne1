package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusEntity {
	
	private Long id;
	
	private String patente;
	
	private String marca;

	private Double km;
	
	private int anio;
	
	private char combustible;
	
	private boolean revisionAlDia;
	
}
