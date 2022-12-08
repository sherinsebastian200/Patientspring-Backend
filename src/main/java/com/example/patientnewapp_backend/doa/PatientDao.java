package com.example.patientnewapp_backend.doa;

import com.example.patientnewapp_backend.model.Patients;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patients,Integer> {
    @Query(value = "SELECT `id`, `address`, `contact`, `dname`, `doa`, `image`, `name`, `pid` FROM `patient` WHERE `pid` =:pid",nativeQuery = true)


    List<Patients> searchPatients(@Param("pid")Integer pid);

    @Modifying
    @Transactional

    @Query(value = "DELETE FROM `patient` WHERE `id`= :id",nativeQuery = true)
    void deletePatients(@Param("id")Integer id);





}
