package com.example.jadwal_sholat.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataInputDAO {
    @Insert
    Long insertData(DataInput dataInput);

    @Query("Select * from datainput_db")
    List<DataInput> getData();

    @Delete
    int deletedata(DataInput dataInput);

}
