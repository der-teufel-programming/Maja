import org.junit.jupiter.api.Test;
import rocks.palaiologos.maja.Complex;
import rocks.palaiologos.maja.Maja;

import static org.assertj.core.api.Assertions.assertThat;

public class TestGamma {
    private static boolean inRange(double a, double b, double error) {
        if(Math.abs(a - b) < error)
            return true;
        else {
            System.out.println("a = " + a + ", b = " + b);
            return false;
        }
    }

    private static boolean inRange(Complex a, Complex b, double error) {
        if(Maja.abs(Maja.sub(a, b)) < error)
            return true;
        else {
            System.out.println("a = " + a + ", b = " + b);
            return false;
        }
    }

    @Test
    public void testLogGamma() {
        assertThat(inRange(Maja.loggamma(new Complex(2, 3)), new Complex(-2.0928517530927333496, 2.3023965434668676262), 1e-10)).isTrue();
        assertThat(inRange(Maja.loggamma(new Complex(2, -3)), new Complex(-2.0928517530927333496, -2.3023965434668676262), 1e-10)).isTrue();
        assertThat(inRange(Maja.loggamma(new Complex(0.1, -3)), new Complex(-4.232218700260561, 0.3453402012115774), 1e-8)).isTrue();
    }
}