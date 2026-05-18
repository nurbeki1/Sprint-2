package service;

import model.Discountable;
import model.Food;

public class ShoppingCart {
    private Food[] items;

    public ShoppingCart(Food[] items) {
        this.items = items;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Food item : items) {
            total += item.getAmount() * item.getPrice();
        }
        return total;
    }

    public double getTotalPriceWithDiscount() {
        double total = 0;
        for (Food item : items) {
            double itemTotal = item.getAmount() * item.getPrice();
            if (item instanceof Discountable) {
                double discount = ((Discountable) item).getDiscount();
                itemTotal -= itemTotal * discount / 100;
            }
            total += itemTotal;
        }
        return total;
    }

    public double getTotalVegetarianPrice() {
        double total = 0;
        for (Food item : items) {
            if (item.isVegetarian()) {
                total += item.getAmount() * item.getPrice();
            }
        }
        return total;
    }
}