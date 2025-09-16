package com.example;
import java.util.List;

public class Lion implements FelineInterface{
    boolean hasMane;
    private FelineInterface feline;
    public Lion(String sex) throws Exception {
        this.feline = new FelineImpl();
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public Lion(FelineInterface feline) {
        this.feline = feline;
    }

    @Override
    public List<String> getFood(String type) {
        return List.of("Животные", "Птицы", "Рыба");
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
