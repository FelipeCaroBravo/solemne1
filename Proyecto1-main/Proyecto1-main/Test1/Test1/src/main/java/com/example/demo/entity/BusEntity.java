package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="bus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String patente;
	
	@NonNull
	private String marca;
	
	@NonNull
	private Double km;
	
	private int anio;
	
	private char combustible;
	
	private boolean revisionAlDia;
	
}
