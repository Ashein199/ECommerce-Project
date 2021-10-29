package com.code2.adminportal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table(name="orders")
	public class Order {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private Long id;
		
		@ManyToOne
		@JoinColumn(name="user_id")
		private AppUser user;
		
		@Column(name="address")
		private String address;
		
		@Column(name="total")
		private Double total;
		
		@Column(name="delivered")
		private boolean delivered;

		@OneToMany(mappedBy="order")
		private List<OrderItem> orderItems;
		public Order() {
		}
		
		public Order(Long id, AppUser user, String address, Double total, boolean delivered) {
			this.id = id;
			this.user = user;
			this.address = address;
			this.total = total;
			this.delivered = delivered;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public AppUser getUser() {
			return user;
		}

		public void setUser(AppUser user) {
			this.user = user;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}

		public boolean isDelivered() {
			return delivered;
		}

		public void setDelivered(boolean delivered) {
			this.delivered = delivered;
		}

		public List<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}
		
}
