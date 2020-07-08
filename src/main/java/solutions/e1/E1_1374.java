package main.java.solutions.e1;/*
LINK: http://codeforces.com/problemset/problem/1374/E1

PROBLEM TASK:
Простая и сложная версии на самом деле являются разными задачами,
поэтому прочитайте условия обеих задач полностью и внимательно.

Летние каникулы начались, поэтому Алиса и Боб хотят играть и веселиться, но...
Их мама не согласна с этим. Она говорит, что они должны прочитать какое-то количество
книг перед всеми развлечениями. Алиса и Боб прочитают каждую книгу вместе,
чтобы быстрее закончить это задание.

В семейной библиотеке есть n книг. i-я книга характеризуется тремя целыми
числами: ti — количество времени, которое Алиса и Боб должны потратить,
чтобы прочитать ее, ai (равное 1, если Алисе нравится i-я книга, и 0, если не нравится),
и bi (равное 1, если Бобу нравится i-я книга, и 0, если не нравится).

Поэтому им нужно выбрать какие-то книги из имеющихся n книг таким образом, что:

Алисе нравятся не менее k книг из выбранного множества и Бобу нравятся не менее k книг из выбранного множества;
общее время, затраченное на прочтение этих книг минимизировано (ведь они дети и хотят начать играть и веселиться как можно скорее).
Множество, которое они выбирают, одинаковое и для Алисы и для Боба (они читают одни и те же книги),
и они читают все книги вместе, таким образом, суммарное время чтения равно сумме ti по всем книгам,
которые находятся в выбранном множестве.

Ваша задача — помочь им и найти любое подходящее множество книг или определить, что такое множество найти невозможно.

Входные данные
Первая строка теста содержит два целых числа n и k (1≤k≤n≤2⋅105).

Следующие n строк содержат описания книг, по одному описанию в строке: i-я строка содержит
три целых числа ti, ai и bi (1≤ti≤104, 0≤ai,bi≤1), где:

ti — количество времени, необходимое для прочтения i-й книги;
ai, равное 1, если Алисе нравится i-я книга, и 0 в обратном случае;
bi, равное 1, если Бобу нравится i-я книга, и 0 в обратном случае.
Выходные данные
Если подходящего решения не существует, выведите число -1. Иначе выведите
целое число T — минимальное суммарное время, необходимое для прочтения подходящего множества книг.

INPUT:
1)

8 4
7 1 1
2 1 1
4 0 1
8 1 1
1 0 1
1 1 1
1 0 1
3 0 0

2)

5 2
6 0 0
9 0 0
1 0 1
2 1 1
5 1 0

3)

5 3
3 0 0
2 1 0
3 1 0
5 0 1
3 0 1

OUTPUT:
1) 18
2) 8
3) -1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class E1_1374 {
    public static void main(String[] args) {
        try {
            new E1_1374().run();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        ArrayList<Book> aliceBooks = new ArrayList<>(n);
        ArrayList<Book> bobBooks = new ArrayList<>(n);
        ArrayList<Book> bothBooks = new ArrayList<>(n);
        int aliceLikeCount = 0;
        int bobLikeCount = 0;
        int times = 0;

        for (int i = 0; i < n; i++) {
            String[] bookInfo = in.readLine().split(" ");
            int time = Integer.parseInt(bookInfo[0]);
            int alice = Integer.parseInt(bookInfo[1]);
            int bob = Integer.parseInt(bookInfo[2]);
            Book book = new Book(time, alice, bob);

            if (alice == 1 && bob == 1) {
                bothBooks.add(book);
            } else if (alice == 1 && bob == 0) {
                aliceBooks.add(book);
            } else if (bob == 1 && alice == 0) {
                bobBooks.add(book);
            }

            aliceLikeCount += alice;
            bobLikeCount += bob;
        }

        if (aliceLikeCount >= k && bobLikeCount >= k) {
            aliceBooks.sort(Comparator.comparing(book -> book.time));
            bobBooks.sort(Comparator.comparing(book -> book.time));
            int minSize = Math.min(aliceBooks.size(), bobBooks.size());
            for (int i = 0; i < minSize; i++) {
                int time = aliceBooks.get(i).time + bobBooks.get(i).time;
                int alice = aliceBooks.get(i).alice + bobBooks.get(i).alice;
                int bob = aliceBooks.get(i).bob + bobBooks.get(i).bob;

                Book book = new Book(time, alice, bob);
                bothBooks.add(book);
            }
            bothBooks.sort(Comparator.comparingInt(o -> o.time));

            for (int i = 0; i < k; i++) {
                times += bothBooks.get(i).time;
            }
        } else times = -1;

        System.out.println(times);
        System.out.flush();
        System.out.close();
        in.close();
    }

    private static class Book {
        private final int time;
        private final int alice;
        private final int bob;

        public Book(int time, int alice, int bob) {
            this.time = time;
            this.alice = alice;
            this.bob = bob;
        }
    }
}