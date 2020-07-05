package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        int lastIndex = products.length - 1;
        if (index == lastIndex) {
            products[index] = null;
            return products;
        }
        for (int i = index; i < lastIndex; i++) {
            products[i] = products[i + 1];
        }
        products[lastIndex] = null;
        return products;
    }
}
