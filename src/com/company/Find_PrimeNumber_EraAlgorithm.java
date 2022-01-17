package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Find_PrimeNumber_EraAlgorithm {

    int NumberofPrimeNumbers (int getNumber)
    {
        boolean [] list = new boolean[getNumber+1];
        Arrays.fill(list, true);
        int primenumbers = -2;
        int forlength = (int )Math.sqrt(list.length) +1;

        for (int i = 2; i< forlength; i++)
        {
            if (list[i] == true) {
                for (int j = 2; i * j < list.length; j++) {
                    list[i * j] = false;
                }
            }
        }

        for (boolean b: list)
        {
            if(b)
            {
                primenumbers++;
            }
        }

        return primenumbers;

    }

}
