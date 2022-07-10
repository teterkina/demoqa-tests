package guru.qa.tests;

import org.junit.jupiter.api.*;

@DisplayName("Это наш первый простой тест")
public class FirstSimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll method!");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    @BeforeEach method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll method!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    @AfterEach method!");
    }

    @DisplayName("Простенький тест на Equals")
    @Test
    void firstTest(){
        System.out.println("        Простенький тест на Equals");
        Assertions.assertEquals(1, 1);
    }

    @DisplayName("Простенький тест на assertTrue")
    @Test
    void secondTest(){
        System.out.println("        Простенький тест на assertTrue");
        Assertions.assertTrue(7 > 6);
    }
}
