package com.maryna.photographer.db.dao;

import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.maryna.photographer.model.PhotoPackage;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PhotoPackageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPhotoPackages(List<PhotoPackage> photoPackages);

    @Query("SELECT * FROM PhotoPackage")
    Single<List<PhotoPackage>> getAllPhotoPackages();
}
