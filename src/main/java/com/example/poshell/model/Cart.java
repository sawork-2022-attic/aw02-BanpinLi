package com.example.poshell.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean changeItem(Item item) {
        for(Item i : items) {
            if(i.getProduct().equals(item.getProduct())) {
                i.setAmount(item.getAmount());
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(Item item) {
        int target = -1;
        for(int i = 0;i < items.size();i++) {
            Item it = items.get(i);
            if(it.getProduct().getId().equals(item.getProduct().getId())) {
                it.getProduct().setId(item.getProduct().getId());
                target = i;
            }
        }
        if(target != -1) {
            items.remove(target);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getAmount() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}
