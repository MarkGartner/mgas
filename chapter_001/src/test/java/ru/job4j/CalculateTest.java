package ru.job4j;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author MGasimov
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
/**
* @Test echo.
*/
@Test /** another javadoc comment on test. */
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Mgas";
    String expect = "Echo, echo, echo : Mgas";
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}

}