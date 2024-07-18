//package com.example.nagoyamesi.entity;
//
//import java.sql.Timestamp;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Entity
//@Table(name = "admins")
//@Data
//public class Admin {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//	
//	
//	@Column(name = "email")
//	private String email;
//	
//	
//	@Column(name = "password")
//	private String password;
//	
//	
//	@Column(name = "created_at", insertable = false, updatable = false)
//	private Timestamp createdAt;
//	
//	
//	@Column(name = "updated_at", insertable = false, updatable = false)
//	private Timestamp updatedAt;
//	
//
//}
