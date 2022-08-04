package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserAndRoleStoreTest {
    @Test
    void whenAddAndFindThenUserNameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        User result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.add(new User("1", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenReplaceThenUsernameIsMaxim() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.replace("1", new User("1", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Maxim");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.replace("10", new User("10", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.delete("1");
        User result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.delete("10");
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenAddAndFindThenUserNameIsDancer() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Dancer"));
        Role result = store.findById("3");
        assertThat(result.getRolename()).isEqualTo("Dancer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Dancer"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dancer"));
        store.add(new Role("1", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Dancer");
    }

    @Test
    void whenReplaceThenUsernameIsDriver() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dancer"));
        store.replace("1", new Role("1", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Driver");
    }

    @Test
    void whenNoReplaceUserThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dancer"));
        store.replace("10", new Role("10", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Dancer");
    }

    @Test
    void whenDeleteUserThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dancer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsDancer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dancer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Dancer");
    }
}