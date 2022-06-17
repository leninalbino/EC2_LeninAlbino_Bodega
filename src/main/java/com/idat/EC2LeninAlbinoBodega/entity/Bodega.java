package com.idat.EC2LeninAlbinoBodega.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Entity
@Table(name="bodega")
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdBodega;
	private String nombre;
	private String direccion;
	
	@JoinColumn(name="id_producto", nullable = false, unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references productos"))
	@ManyToOne
	private Producto producto;
}
