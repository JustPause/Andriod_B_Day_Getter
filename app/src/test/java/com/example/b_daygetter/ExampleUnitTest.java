package com.example.b_daygetter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
	@Test
	public void addition_isCorrect() {
		assertEquals(4, 2 + 2);
	}

//	@Test
//	public void AddUser() {
//		UserDao userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
//
//		String userName = "Justinas";
//		String userSureName = "Stankunas";
//		LocalDate bLocalDate = LocalDate.parse("2003-06-06");
//
//
//		User user = new User(userName, userSureName, bLocalDate.getYear(), bLocalDate.getMonthValue(),
//				bLocalDate.getDayOfMonth()
//		);
//
//		userDao.insert(user);
//	}

}