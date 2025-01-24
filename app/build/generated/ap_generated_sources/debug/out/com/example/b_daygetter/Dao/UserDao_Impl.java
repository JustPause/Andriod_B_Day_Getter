package com.example.b_daygetter.Dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllUsers;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`id`,`name`,`sureName`,`b_day_year`,`b_day_month`,`b_day_day`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSureName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSureName());
        }
        if (value.getDateYear() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getDateYear());
        }
        if (value.getDateMonth() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getDateMonth());
        }
        if (value.getDateDay() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getDateDay());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `users` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllUsers = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM users";
        return _query;
      }
    };
  }

  @Override
  public void insert(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllUsers() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllUsers.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllUsers.release(_stmt);
    }
  }

  @Override
  public List<User> getAllUsers() {
    final String _sql = "SELECT * FROM users ORDER BY b_day_month, b_day_day";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfSureName = CursorUtil.getColumnIndexOrThrow(_cursor, "sureName");
      final int _cursorIndexOfDateYear = CursorUtil.getColumnIndexOrThrow(_cursor, "b_day_year");
      final int _cursorIndexOfDateMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "b_day_month");
      final int _cursorIndexOfDateDay = CursorUtil.getColumnIndexOrThrow(_cursor, "b_day_day");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpSureName;
        if (_cursor.isNull(_cursorIndexOfSureName)) {
          _tmpSureName = null;
        } else {
          _tmpSureName = _cursor.getString(_cursorIndexOfSureName);
        }
        final Integer _tmpDateYear;
        if (_cursor.isNull(_cursorIndexOfDateYear)) {
          _tmpDateYear = null;
        } else {
          _tmpDateYear = _cursor.getInt(_cursorIndexOfDateYear);
        }
        final Integer _tmpDateMonth;
        if (_cursor.isNull(_cursorIndexOfDateMonth)) {
          _tmpDateMonth = null;
        } else {
          _tmpDateMonth = _cursor.getInt(_cursorIndexOfDateMonth);
        }
        final Integer _tmpDateDay;
        if (_cursor.isNull(_cursorIndexOfDateDay)) {
          _tmpDateDay = null;
        } else {
          _tmpDateDay = _cursor.getInt(_cursorIndexOfDateDay);
        }
        _item = new User(_tmpName,_tmpSureName,_tmpDateYear,_tmpDateMonth,_tmpDateDay);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUser(final int id) {
    final String _sql = "SELECT * FROM users WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfSureName = CursorUtil.getColumnIndexOrThrow(_cursor, "sureName");
      final int _cursorIndexOfDateYear = CursorUtil.getColumnIndexOrThrow(_cursor, "b_day_year");
      final int _cursorIndexOfDateMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "b_day_month");
      final int _cursorIndexOfDateDay = CursorUtil.getColumnIndexOrThrow(_cursor, "b_day_day");
      final User _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpSureName;
        if (_cursor.isNull(_cursorIndexOfSureName)) {
          _tmpSureName = null;
        } else {
          _tmpSureName = _cursor.getString(_cursorIndexOfSureName);
        }
        final Integer _tmpDateYear;
        if (_cursor.isNull(_cursorIndexOfDateYear)) {
          _tmpDateYear = null;
        } else {
          _tmpDateYear = _cursor.getInt(_cursorIndexOfDateYear);
        }
        final Integer _tmpDateMonth;
        if (_cursor.isNull(_cursorIndexOfDateMonth)) {
          _tmpDateMonth = null;
        } else {
          _tmpDateMonth = _cursor.getInt(_cursorIndexOfDateMonth);
        }
        final Integer _tmpDateDay;
        if (_cursor.isNull(_cursorIndexOfDateDay)) {
          _tmpDateDay = null;
        } else {
          _tmpDateDay = _cursor.getInt(_cursorIndexOfDateDay);
        }
        _result = new User(_tmpName,_tmpSureName,_tmpDateYear,_tmpDateMonth,_tmpDateDay);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
