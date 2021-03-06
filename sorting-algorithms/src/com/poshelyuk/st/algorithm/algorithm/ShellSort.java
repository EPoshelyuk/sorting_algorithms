package com.poshelyuk.st.algorithm.algorithm;

import static com.poshelyuk.st.algorithm.algorithm.AlgorithmsNameConstant.SHELL_SORT;

public class ShellSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        int inner;
        int outer;
        int temp;
        int h = 1;
        // ищем начальное значение h
        while (h <= array.length / 3) {
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        }

        while (h > 0) {
            //сдвигаемся на 1 шаг, для h-сортировки следующей группы элементов
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
                //сортируем массив с шагом h
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            //на каждом шаге уменьшаем h
            h = (h - 1) / 3;
        }
        return array;
    }

    @Override
    public String getName() {
        return SHELL_SORT;
    }

}
