package com.idat.EC2LeninAlbinoBodega.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	private String nombre;
	private String direccion;
	private String dni;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "cliente_producto", 
	joinColumns = @JoinColumn(name="id_producto", 
	nullable = false,
	unique = true, 
	foreignKey = @ForeignKey(
	foreignKeyDefinition = "foreign key (id_producto)reference productos(id_producto)")),
	inverseJoinColumns = 
	@JoinColumn(name="id_cliente",
				nullable = false,
				unique = true,
				foreignKey = @ForeignKey(foreignKeyDefinition = "reference clientes(id_cliente)"))
			)
	private List<Producto>producto= new ArrayList<>();
	
}
