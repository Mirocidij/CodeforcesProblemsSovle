package main.java.solutions.c;

/*
LINK: http://codeforces.com/problemset/problem/1374/C

Вам задана скобочная последовательность s длины n, где n четное (без остатка делится на 2).
Строка s состоит из n2 открывающих скобок '(' и n2 закрывающих скобок ')'.

За один ход вы можете выбрать ровно одну скобку и передвинуть ее в начало или в конец строки
(т.е. вы можете выбрать некоторый индекс i, удалить i-й символ из s и вставить его перед или
после всех остальных символов в s).

Ваша задача — найти минимальное количество ходов, необходимое, чтобы получить правильную скобочную
последовательность из s. Можно доказать, что ответ всегда существует при данных ограничениях.

Напомним, что такое правильная скобочная последовательность:

«()» — правильная скобочная последовательность;
если s — правильная скобочная последовательность, то «(» + s + «)» — правильная скобочная последовательность;
если s и t — правильные скобочные последовательности, то s + t — правильная скобочная последовательность.
Например, «()()», «(())()», «(())» и «()» являются правильными скобочными последовательностями, а «)(», «()(» и «)))» — нет.

Вам нужно ответить на t независимых наборов тестовых данных.

Входные данные
Первая строка теста содержит одно целое число t (1≤t≤2000) — количество наборов тестовых данных.
Затем следуют t наборов тестовых данных.

Первая строка набора тестовых данных содержит одно целое число n (2≤n≤50) — длину s.
Гарантируется, что n четное. Вторая строка набора тестовых данных содержит строку s,
состоящую из n2 открывающих и n2 закрывающих скобок.

Выходные данные
Для каждого набора тестовых данных выведите ответ на него — минимальное количество ходов,
необходимое, чтобы получить правильную скобочную последовательность из s.
Можно доказать, что ответ всегда существует при данных ограничениях.

INPUT:
4
2
)(
4
()()
8
())()()(
10
)))((((())

OUTPUT:
1
0
1
3
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class C_1374 {
    public static void main(String[] args) {
        try {
            new C_1374().run();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> braces = new Stack<>();
        int count = Integer.parseInt(in.readLine());

        for (int i = 0; i < count; i++) {
            int stringLength = Integer.parseInt(in.readLine());
            String str = in.readLine();
            int failBrace = 0;

            for (char c : str.toCharArray()) {
                if (c == '(') {
                    braces.push(c);
                } else if (c == ')') {
                    if (braces.size() == 0) {
                        failBrace++;
                    } else {
                        braces.pop();
                    }
                }
            }

            System.out.println(failBrace);
            braces.clear();
        }
    }
}
