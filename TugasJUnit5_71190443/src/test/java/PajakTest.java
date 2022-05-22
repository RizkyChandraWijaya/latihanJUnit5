import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PajakTest {

    static Pajak pajakTest;

    @BeforeAll
    static void init(){
        pajakTest = new Pajak();
    }

    @AfterAll
    static void destroy(){ pajakTest = null;}

    //method untuk menguji equivalence Class
    public static Stream<Arguments> vEC(){
        return Stream.of(
                Arguments.of(0,2000000),
                Arguments.of(10,10000000),
                Arguments.of(22,20000000),
                Arguments.of(40f,70000000),
                Arguments.of(-1,-2000000),
                Arguments.of(-1,9999999999999f)
        );
    }

    // untuk menjalanakn Equivalence Class
    @ParameterizedTest
    @MethodSource("vEC")
    void parameterizedTestvEC(double expected, double gaji){
        Assertions.assertEquals(expected, pajakTest.getPajak(gaji));
    }

    //BVA vEC1 dan vEC2
    public static Stream<Arguments> bva1(){
        return Stream.of(
                Arguments.of(true, 3999999),
                Arguments.of(true, 4000000),
                Arguments.of(false, 4000001)
        );
    }

    @ParameterizedTest
    @MethodSource("bva1")
    void parameterizedTestBVA1(boolean expected, double gaji){
        assertNotNull(pajakTest);
        //BVA vEC1 dan vEC2
        Assertions.assertEquals(expected, pajakTest.getPajak(gaji)==0);
    }

    //BVA vEC2 dan vEC3
    public static Stream<Arguments> bva2(){
        return Stream.of(
                Arguments.of(true, 14999999),
                Arguments.of(true, 15000000),
                Arguments.of(false, 15000001)
        );
    }

    @ParameterizedTest
    @MethodSource("bva2")
    void parameterizedTestBVA2(boolean expected, double gaji){
        assertNotNull(pajakTest);
        //BVA vEC2 dan vEC3
        Assertions.assertEquals(expected, pajakTest.getPajak(gaji)==10);
    }

    //BVA vEC3 dan vEC4
    public static Stream<Arguments> bva3(){
        return Stream.of(
                Arguments.of(true, 39999999),
                Arguments.of(true, 40000000),
                Arguments.of(false, 40000001)
        );
    }

    @ParameterizedTest
    @MethodSource("bva3")
    void parameterizedTestBVA3(boolean expected, double gaji){
        assertNotNull(pajakTest);
        //BVA vEC2 dan vEC3
        Assertions.assertEquals(expected, pajakTest.getPajak(gaji)==22);
    }

    //BVA vEC4
    public static Stream<Arguments> bva4(){
        return Stream.of(
                Arguments.of(true, 999999999998f),
                Arguments.of(true, 999999999999f),
                Arguments.of(false, 1000000000000d)
        );
    }

    @ParameterizedTest
    @MethodSource("bva4")
    void parameterizedTestBVA4(boolean expected, double gaji){
        assertNotNull(pajakTest);
        //BVA vEC4
        Assertions.assertEquals(expected, pajakTest.getPajak(gaji)==40f);
    }

}
