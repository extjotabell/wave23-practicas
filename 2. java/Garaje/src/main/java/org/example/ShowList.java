package org.example;

import java.util.List;

public class ShowList {

    public static void listDetailed(List<?> list) {

        list.stream().forEach((Object count) -> {
            System.out.println(count);
        });
    }
}
