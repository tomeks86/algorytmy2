package com.company;

public class Math {

    public static int pow(int base, int exp) {
        if (exp < 0) {
            return -1;
        }
        int res = 1, r;
        while (exp > 0) {
            r = exp % 2;
            exp /= 2;
            if (r > 0) {
                res *= base;
                //res %= 1000;    //return only last 3 digits...
            }
            base *= base;
        }
        //System.out.println("tu jestem");
        return res;
    }

    public static int convertTo10(String number, int base) {
        int res = 0, actBase = 1;
        int[] num = stringToIntTable(number);
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= base) {
                System.out.println("Illegal input number to convertTo10 method!!!");
                return -1;
            }
        }
        for (int i = num.length - 1; i > -1; i--) {
            res += actBase * num[i];
            actBase *= base;
        }

        return res;
    }

    public static int[] stringToIntTable(String number) {
        int n = number.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Integer.parseInt(number.substring(i,i+1));
        }
        return res;
    }

    public static String convertFrom10(int number, int base) {
        StringBuffer res = new StringBuffer();
        Integer r;
        if (base == 16) {
            while (number > 0) {
                r = number % base;
                number /= base;
                switch (r) {
                    case 10:
                        res.append("A");
                        break;
                    case 11:
                        res.append("B");
                        break;
                    case 12:
                        res.append("C");
                        break;
                    case 13:
                        res.append("D");
                        break;
                    case 14:
                        res.append("E");
                        break;
                    case 15:
                        res.append("F");
                        break;
                    default: res.append(r.toString());
                }
            }
        } else if (base < 10 && base > 1) {
            while (number > 0) {
                r = number % base;
                number /= base;
                res.append(r.toString());
            }
        }
        return res.reverse().toString();
    }

    public static String convert(String number, int numBase, int resBase) {
        int base10Number = convertTo10(number, numBase);
        if (base10Number < 0) {
            return "";
        }
        return convertFrom10(base10Number,resBase);
    }

    public static void main(String[] args) {

        String number = "100101010011111";

        //System.out.println(pow(5,2));
        System.out.println(convertTo10(number,2));
        int num = convertTo10(number,2);

        System.out.println(convertFrom10(num,16));

        System.out.println(convert(number,2,16));

        System.out.println(pow(2,24));

    }
}
