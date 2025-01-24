package com.example.b_daygetter.Main;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.PrivetData.PrivetDataAndUsers;

public class AddingTempUsers {
    private final MainActivity mainActivity;
    private final PrivetDataAndUsers privetDataAndUsers = new PrivetDataAndUsers();

    public AddingTempUsers(MainActivity mainActivity) { this.mainActivity = mainActivity; }

    public void MainActivityAddingTempUser() {

        mainActivity.setUserDao(MainDataBase.getInstance(mainActivity.getApplicationContext()).userDao());

        if (
                mainActivity.getUserDao().getAllUsers().isEmpty()
        ) {
            privetDataAndUsers.PrivetDataAndUsersAsData(MainDataBase.getInstance(getMainActivity().getApplicationContext()).userDao());
        }
    }


    public MainActivity getMainActivity() {
        return mainActivity;
    }

}