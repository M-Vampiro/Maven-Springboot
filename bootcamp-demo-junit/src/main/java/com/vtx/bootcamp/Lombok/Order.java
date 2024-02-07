package com.vtx.bootcamp.Lombok;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {

  private boolean isPaid;

  private boolean isOrdered;

  private boolean isInventoryLocked;

  public boolean order() {
    isOrdered = true;
    return true;
  }

  public boolean payment() {
    if (isOrdered) {
      isPaid = true;
      return true;
    }
    return false;
  }

  public boolean lockInventory() {
    if (isPaid) {
      isInventoryLocked = true;
      return true;
    }
    return false;
  }

  public boolean placeOrder(List<String> items) {
    int count = 0;
    for (String item : items) {
      count++;
    }
    return true;
  }

}