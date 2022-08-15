package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(6, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isNumberOfVerticesFour() {
        Box box = new Box(4, 8);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(4);
    }

    @Test
    void isNumberOfVerticesMinusOne() {
        Box box = new Box(2, 6);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(-1);
    }

    @Test
    void isArea() {
        Box box = new Box(6, 2);
        double rsl = box.getArea();
        assertThat(rsl).isEqualTo(24);
    }

    @Test
    void isAreaDefault() {
        Box box = new Box(10, 2);
        double rsl = box.getArea();
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(6, 1);
        boolean rsl = box.isExist();
        assertThat(rsl).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(6, 0);
        boolean rsl = box.isExist();
        assertThat(rsl).isFalse();
    }
}