
package org.robust.microservice.currency_conversion.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {

 private Long id;
 private String from;
 private String to;
 private BigDecimal conversionMultiple;
 private BigDecimal quantity;
 private BigDecimal totalCalculatedAmount;
 private String environment;
 
}
