package com.ldm.everydayapainting.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ldm.everydayapainting.database.entity.Cuadro;

import java.util.Date;
import java.util.List;

@Dao
public interface CuadroDAO {
    int date = new Date(System.currentTimeMillis()).getDate();

    @Insert
    void insertCuadro(Cuadro cuadro);

    @Update
    void updateCuadroById(Cuadro cuadro);

    @Delete
    void deleteCuadroById(Cuadro cuadro);

    @Query("DELETE FROM cuadros")
    void deleteAllCuadro();

    @Query("SELECT * FROM cuadros")
    List<Cuadro> findAllCuadro();

    @Query("SELECT * FROM cuadros WHERE name LIKE :name")
    Cuadro findCuadroByName(String name);

    @Query("SELECT * FROM cuadros WHERE author LIKE :author")
    List<Cuadro> findCuadroByAuthor(String author);

    @Query("SELECT * FROM cuadros WHERE year LIKE :year")
    List<Cuadro> findCuadroByYear(int year);

    @Query("SELECT * FROM cuadros WHERE style LIKE :style")
    List<Cuadro> findCuadroByStyle(String style);


    @Query("SELECT * FROM cuadros ORDER BY RANDOM() LIMIT 1")
    List<Cuadro> findRandomCuadro();

}
