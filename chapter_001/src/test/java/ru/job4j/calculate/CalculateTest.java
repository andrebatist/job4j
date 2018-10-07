package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Plaksin Arseniy (arsp93@mail.ru)
* @version 0.1
* @since 7.10.2018
*/
public class CalculateTest {
	
	/**
	* Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Arseniy Plaksin";
		String expect = "Echo, echo, echo : Arseniy Plaksin";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}