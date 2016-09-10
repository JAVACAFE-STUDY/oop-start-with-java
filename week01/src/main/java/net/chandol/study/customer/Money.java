package net.chandol.study.customer;

import java.math.BigDecimal;

public class Money {
  private BigDecimal amount;

  public Money(BigDecimal amount) {
    this.amount = amount;
  }
 
  public Money(long amount) {
    this(new BigDecimal(amount));
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
            
    if (!(object instanceof Money)) {
      return false;
    }           
            
    return amount.equals(((Money)object).amount);
  }

  public int hashCode() {
    return amount.hashCode();
  }

  public Money add(Money added) {
    this.amount = this.amount.add(added.amount);
    return this;
  }

  public String toString() {
    return amount.toString();
  }
}