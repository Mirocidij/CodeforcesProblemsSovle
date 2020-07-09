package main.java.solutions.a;

/*
LINK: http://codeforces.com/problemset/problem/1374/A

PROBLEM TASK:


INPUT:


OUTPUT:

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_1374 {
    public static void main(String[] args) {
        try {
            new A_1374().run();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        for (int i = 0; i < count; i++) {
            String[] data = in.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            int n = Integer.parseInt(data[2]);

            System.out.println(n - (n - y) % x);
        }
    }
}


