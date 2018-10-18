import LicenseGenerators.RandomGenerator;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class NumberPlateTest {


    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        RandomGenerator generator = new RandomGenerator();
        String numberPlate = generator.getRandomLicensePlate();
        //"1-AAA-999"

        int firstPart = Integer.parseInt(numberPlate.substring(0, 1));

        String secondPart = numberPlate.substring(2, 1);
        String thirdPart = numberPlate.substring(3, 1);
        String fourthPart =numberPlate.substring(4, 1);

        int fifthParth = Integer.parseInt(numberPlate.substring(6, 1));
        int sixthPart = Integer.parseInt(numberPlate.substring(7, 1));
        int seventhPart = Integer.parseInt(numberPlate.substring(8, 1));


        assertEquals("Length is 9",9,numberPlate.length());

    }
}
