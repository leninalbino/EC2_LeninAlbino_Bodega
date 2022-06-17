package com.idat.EC2LeninAlbinoBodega.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	private String producto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	@OneToMany(mappedBy = "producto")
	private List<Bodega> bodega= new ArrayList<>();
	
	@ManyToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Cliente> cliente= new ArrayList<>();
}
