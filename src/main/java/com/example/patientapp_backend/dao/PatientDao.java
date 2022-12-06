package com.example.patientnewapp_backend.doa;

import com.example.patientnewapp_backend.model.Patients;
import org.springframework.data.repository.CrudRepository;

public interface PatientDao extends CrudRepository<Patients,Integer> {
}
