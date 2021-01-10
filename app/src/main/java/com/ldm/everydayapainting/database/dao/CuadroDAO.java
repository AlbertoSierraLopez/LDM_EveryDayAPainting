package com.ldm.everydayapainting.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ldm.everydayapainting.database.entity.Cuadro;

import java.util.List;

@Dao
public interface CuadroDAO {

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

    @Query("SELECT * FROM cuadros WHERE id LIKE :id")
    Cuadro findCuadroById(int id);

}
