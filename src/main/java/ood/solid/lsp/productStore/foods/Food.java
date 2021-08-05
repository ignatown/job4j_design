package ood.solid.lsp.productStore.foods;

import java.util.Calendar;

public class Food {

    private String name;
    private Calendar createDate;
    private Calendar expiredDate;
    private int price;
    private double discount;

    public Food(String name, Calendar createDate, Calendar expiredDate, int price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiredDate = expiredDate;
        this.price = price;
        this.discount = discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public Calendar getExpiredDate() {
        return expiredDate;
    }

    public double getDiscount() {
        return discount;
    }
}
