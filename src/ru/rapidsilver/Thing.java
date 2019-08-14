package ru.rapidsilver;

import java.util.ArrayList;

public class Thing {
    private Integer number;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private Integer minNumber = Integer.MAX_VALUE;
    private Integer maxNumber = Integer.MIN_VALUE;
    private Double
            averageNumber;

    public Thing() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
        if (numbers.size()==0) {
            maxNumber = number;
            minNumber = number;
        }else {
            if (number>maxNumber) maxNumber = number;
            if (number<minNumber) minNumber = number;
        }
        numbers.add(number);
        Integer sum = 0;
        for (Integer num: numbers) {
            sum = sum + num;
        }
        averageNumber = (double)sum/numbers.size();
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public Double getAverageNumber() {
        return averageNumber;
    }
}
