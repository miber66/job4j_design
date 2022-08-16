package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("Car", "Boat", "Plane");
        assertThat(list).hasSize(3)
                .doesNotContain("Vehicle")
                .containsOnlyOnce("Car");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("Programmer", "Driver", "Teacher", "Doctor", "Doctor");
        assertThat(set).hasSize(4)
                .isNotNull()
                .allMatch(e -> e.length() > 1)
                .contains("Programmer");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("January", "February", "March");
        assertThat(map).hasSize(3)
                .containsKeys("January", "February", "March")
                .containsValues(0, 1, 2);
    }
}