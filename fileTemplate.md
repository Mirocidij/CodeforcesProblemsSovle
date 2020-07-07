### Чтобы установить этот шаблон - вам нужна среда разработки Intellij IDEA

* Нажмите `ctrl + alt + s`
* Перейдите в раздел `Editor -> File and Code Templates`
* Выберите в списке Class
* Нажмите на плюсик
* Вставьте в текстовое поле код, который находится ниже

Теперь, при создании нового Java-файла вы сможете, среди прочего, выбрать свой шаблон

``` java
#parse("File Header.java")

/*
LINK: 

PROBLEM TASK:


INPUT:


OUTPUT:

*/

import java.io.IOException;

public class ${NAME} {
    public static void main(String[] args) {
        try {
            new ${NAME}().run();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    void run() throws IOException {
        
    }
}
```
