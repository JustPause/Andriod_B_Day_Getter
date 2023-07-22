package com.example.b_daygetter.Main;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.Message;
import com.example.b_daygetter.Dao.SecondDataBase;
import com.example.b_daygetter.PrivetData.PrivetDataAndUsers;

public class AddingTempUsers {
    private final MainActivity mainActivity;
    private final PrivetDataAndUsers privetDataAndUsers = new PrivetDataAndUsers(this);

    public AddingTempUsers(MainActivity mainActivity) { this.mainActivity = mainActivity; }

    public void MainActivityAddingTempUser() {
        mainActivity.setUserDao(
                MainDataBase.getInstance(
                        mainActivity.getApplicationContext()
                ).userDao()
        );
        if (
                mainActivity.getUserDao().getAllUsers().isEmpty()
        ) {
            privetDataAndUsers.PrivetDataAndUsersAsData();
        }
//		if (SecondDataBase.getInstance(mainActivity.getApplicationContext()).messageDao().getAllMessages().isEmpty()) {
//			SecondDataBase.getInstance(mainActivity.getApplicationContext()).messageDao().insert(
//					new Message(
//							"IamJustStan@hotmail.com",
//							"Happy birthday! Wishing you a day full of love, joy, and all your favorite things."
//					)
//			);
//
//		}
    }


    public MainActivity getMainActivity() {
        return mainActivity;
    }

}