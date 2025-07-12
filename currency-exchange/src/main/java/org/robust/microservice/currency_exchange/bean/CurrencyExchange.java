package org.robust.microservice.currency_exchange.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {
 @Id
 @GeneratedValue
 private Long id;
 @Column(name = "currency_from")
 private String from;
 public Long getId() {
	return id;
}
 public void setId(Long id) {
	this.id = id;
 }
 public String getFrom() {
	return from;
 }
 public void setFrom(String from) {
	this.from = from;
 }
 public String getTo() {
	return to;
 }
 public void setTo(String to) {
	this.to = to;
 }
 public BigDecimal getConversionMultiple() {
	return conversionMultiple;
 }
 public void setConversionMultiple(BigDecimal conversionMultiple) {
	this.conversionMultiple = conversionMultiple;
 }
 public String getEnvironment() {
	return environment;
 }
 public void setEnvironment(String environment) {
	this.environment = environment;
 }
 @Column(name = "currency_to")
 private String to;
 private BigDecimal conversionMultiple;
 private String environment;


}
