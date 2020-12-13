package com.maryna.photographer.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.maryna.photographer.db.dao.PhotoDao;
import com.maryna.photographer.db.dao.PhotoPackageDao;
import com.maryna.photographer.db.dao.PhotoSessionDao;
import com.maryna.photographer.model.Photo;
import com.maryna.photographer.model.PhotoPackage;
import com.maryna.photographer.model.PhotoSession;

@Database(
        entities = {
                PhotoSession.class,
                PhotoPackage.class,
                Photo.class
        },
        version = 2
)
abstract public class PhotoDatabase extends RoomDatabase {
        abstract public PhotoPackageDao photoPackageDao();
        abstract public PhotoDao photoDao();
        abstract public PhotoSessionDao photoSessionDao();
}
