//package com.pau.everis.models;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name = "ordenCompra")
//public class OrdenCompra {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Long id;
//	float total;
//
//	@Column(updatable = false)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date createdAt;
//
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date updatedAt;
//
//	// Muchas a 1 con usuario
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "usuario_id")
//	private Usuario usuario;
//
//	// 1 a M con productos
////	@OneToMany(mappedBy="ordenCompra", fetch = FetchType.LAZY)
////	private List<Producto> productos;
//
//	public OrdenCompra() {
//	}
//
//	public OrdenCompra(Long id, float total) {
//		this.id = id;
//		this.total = total;
//	}
//
//	@PrePersist
//	protected void onCreate() {
//		this.createdAt = new Date();
//	}
//
//	@PreUpdate
//	protected void onUpdate() {
//		this.updatedAt = new Date();
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public float getTotal() {
//		return total;
//	}
//
//	public void setTotal(float total) {
//		this.total = total;
//	}
//
//}
