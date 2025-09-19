package com.example;

import java.util.List;

public interface FelineInterface extends Predator {
    List<String> getFood(String type) throws Exception;
    int getKittens();
}
