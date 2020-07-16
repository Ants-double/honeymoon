package com.ants.six;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2020/7/15
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("six Z 字形变换");
        // 2020-07-15 重刷
        System.out.println(convert("PAYPALISHIRING", 1));

    }

    public static String convert(String s, int numRows) {

        if (s == null || s.length() < 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        } ;
        StringBuilder[] array = new StringBuilder[numRows];
        for (int init = 0; init < array.length; init++) {
            array[init] = new StringBuilder();
        }
        int step = numRows + (numRows - 2);
        for (int i = 0; i < s.length(); i += step) {

            for (int j = 0; j < step && (i + j) < s.length(); j++) {
                if (j >= numRows) {
                    array[numRows - ((j - numRows) % numRows) - 2].append(s.charAt(i + j));
                } else {
                    array[j % numRows].append(s.charAt(i + j));
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : array) {
            ret.append(row);
        }

        return ret.toString();
    }

    public static String convertCopy(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;

        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

}
