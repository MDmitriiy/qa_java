package com.example;

import java.util.List;

public class FelineImpl implements FelineInterface {
    @Override
    public int getKittens() {
        return 1;
    }

    @Override
    public List<String> getFood(String type) throws Exception {
        if ("Хищник".equals(type)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else {
            throw new Exception("Неизвестный тип животного");
        }
    }
}
