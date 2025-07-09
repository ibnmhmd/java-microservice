package org.robust.microservice.currency_exchange.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {
 @Id
 @GeneratedValue
 private Long id;
 @Column(name = "currency_from")
 private String from;
 @Column(name = "currency_to")
 private String to;
 private BigDecimal conversionMultiple;
 private String environment;
 
}
