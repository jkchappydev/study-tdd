package sample.cafekiosk.unit.beverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AmericanoTest {

    @Test
    void getName() {
        Americano americano = new Americano();

        // JUnit 의 API
        // assertEquals("아메리카노", americano.getName());

        // AssertJ 의 API (보통 AssertJ 사용한다.)
        // JUnit 에 비해 더 명시적, 메서드 체이닝을 통한 더 풍부한 검증
        assertThat(americano.getName()).isEqualTo("아메리카노");
    }

    @Test
    void getPrice() {
        Americano americano = new Americano();

        assertThat(americano.getPrice()).isEqualTo(4000);
    }

}