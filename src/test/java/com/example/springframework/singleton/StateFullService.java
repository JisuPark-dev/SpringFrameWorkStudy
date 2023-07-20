package com.example.springframework.singleton;

public class StateFullService {

    private int price;//상태를 유지하는 필

    public void order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
