package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
-Добавленным считается такой пользователь,что ранее его не было в множестве previous,но в множестве current он есть
-Изменённым считается объект, в котором изменилось имя, а id осталось прежним.
-Удаленным считается такой пользователь, что ранее он был в множестве previous, но теперь в множестве current его нет.*/

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<Integer, String> prev = new HashMap<>();
        Map<Integer, String> cur = new HashMap<>();
        for (User pr: previous) {
            prev.put(pr.getId(), pr.getName());
        }
        for (User cu: current) {
            cur.put(cu.getId(), cu.getName());
        }

        for (Integer key: cur.keySet()) {
            if (!prev.containsKey(key)) {
                added++;
            }
        }
        for (Integer key: prev.keySet()) {
            if (!cur.containsKey(key)) {
                deleted++;
            } else if (!prev.get(key).equals(cur.get(key))) {
                changed++;
            }
        }
        return new Info(added, changed, deleted);
    }
}
