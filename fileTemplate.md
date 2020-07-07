``` java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
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