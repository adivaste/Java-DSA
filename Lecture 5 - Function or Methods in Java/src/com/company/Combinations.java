//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.Scanner;

public class Combinations {
    public Combinations() {
    }

    public static void main(String[] var0) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int r = input.nextInt();
        int var4 = 1;

        int var5;
        for(var5 = 1; var5 <= var2; ++var5) {
            var4 *= var5;
        }

        var5 = 1;

        int var6;
        for(var6 = 1; var6 <= var3; ++var6) {
            var5 *= var6;
        }

        var6 = 1;

        int var7;
        for(var7 = 1; var7 <= var2 - var3; ++var7) {
            var6 *= var7;
        }

        var7 = var4 / (var5 * var6);
        System.out.println(var7);
    }
}
