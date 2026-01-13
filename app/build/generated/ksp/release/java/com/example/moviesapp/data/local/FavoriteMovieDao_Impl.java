package com.example.moviesapp.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.moviesapp.data.model.FavoriteMovie;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteMovieDao_Impl implements FavoriteMovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavoriteMovie> __insertionAdapterOfFavoriteMovie;

  private final EntityDeletionOrUpdateAdapter<FavoriteMovie> __deletionAdapterOfFavoriteMovie;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFavoriteById;

  public FavoriteMovieDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavoriteMovie = new EntityInsertionAdapter<FavoriteMovie>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favorite_movies` (`id`,`title`,`originalTitle`,`image`,`description`,`releaseDate`,`director`,`producer`,`runningTime`,`rtScore`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteMovie entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getOriginalTitle());
        statement.bindString(4, entity.getImage());
        statement.bindString(5, entity.getDescription());
        statement.bindString(6, entity.getReleaseDate());
        statement.bindString(7, entity.getDirector());
        statement.bindString(8, entity.getProducer());
        statement.bindString(9, entity.getRunningTime());
        statement.bindString(10, entity.getRtScore());
      }
    };
    this.__deletionAdapterOfFavoriteMovie = new EntityDeletionOrUpdateAdapter<FavoriteMovie>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `favorite_movies` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteMovie entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteFavoriteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM favorite_movies WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertFavorite(final FavoriteMovie movie,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavoriteMovie.insert(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFavorite(final FavoriteMovie movie,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavoriteMovie.handle(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFavoriteById(final String movieId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFavoriteById.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, movieId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteFavoriteById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FavoriteMovie>> getAllFavorites() {
    final String _sql = "SELECT * FROM favorite_movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"favorite_movies"}, new Callable<List<FavoriteMovie>>() {
      @Override
      @NonNull
      public List<FavoriteMovie> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "originalTitle");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfDirector = CursorUtil.getColumnIndexOrThrow(_cursor, "director");
          final int _cursorIndexOfProducer = CursorUtil.getColumnIndexOrThrow(_cursor, "producer");
          final int _cursorIndexOfRunningTime = CursorUtil.getColumnIndexOrThrow(_cursor, "runningTime");
          final int _cursorIndexOfRtScore = CursorUtil.getColumnIndexOrThrow(_cursor, "rtScore");
          final List<FavoriteMovie> _result = new ArrayList<FavoriteMovie>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FavoriteMovie _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpDirector;
            _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
            final String _tmpProducer;
            _tmpProducer = _cursor.getString(_cursorIndexOfProducer);
            final String _tmpRunningTime;
            _tmpRunningTime = _cursor.getString(_cursorIndexOfRunningTime);
            final String _tmpRtScore;
            _tmpRtScore = _cursor.getString(_cursorIndexOfRtScore);
            _item = new FavoriteMovie(_tmpId,_tmpTitle,_tmpOriginalTitle,_tmpImage,_tmpDescription,_tmpReleaseDate,_tmpDirector,_tmpProducer,_tmpRunningTime,_tmpRtScore);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getFavoriteById(final String movieId,
      final Continuation<? super FavoriteMovie> $completion) {
    final String _sql = "SELECT * FROM favorite_movies WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, movieId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FavoriteMovie>() {
      @Override
      @Nullable
      public FavoriteMovie call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "originalTitle");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfDirector = CursorUtil.getColumnIndexOrThrow(_cursor, "director");
          final int _cursorIndexOfProducer = CursorUtil.getColumnIndexOrThrow(_cursor, "producer");
          final int _cursorIndexOfRunningTime = CursorUtil.getColumnIndexOrThrow(_cursor, "runningTime");
          final int _cursorIndexOfRtScore = CursorUtil.getColumnIndexOrThrow(_cursor, "rtScore");
          final FavoriteMovie _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpDirector;
            _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
            final String _tmpProducer;
            _tmpProducer = _cursor.getString(_cursorIndexOfProducer);
            final String _tmpRunningTime;
            _tmpRunningTime = _cursor.getString(_cursorIndexOfRunningTime);
            final String _tmpRtScore;
            _tmpRtScore = _cursor.getString(_cursorIndexOfRtScore);
            _result = new FavoriteMovie(_tmpId,_tmpTitle,_tmpOriginalTitle,_tmpImage,_tmpDescription,_tmpReleaseDate,_tmpDirector,_tmpProducer,_tmpRunningTime,_tmpRtScore);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object isFavorite(final String movieId, final Continuation<? super Boolean> $completion) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM favorite_movies WHERE id = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, movieId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Boolean>() {
      @Override
      @NonNull
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp != 0;
          } else {
            _result = false;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
