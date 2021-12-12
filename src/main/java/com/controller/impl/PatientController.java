package com.controller.impl;

import com.controller.AbstractController;
import com.model.entity.impl.Patient;
import com.model.enums.TypeEntity;
import com.service.impl.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/patients")
public class PatientController extends AbstractController<Patient, PatientService> {

    protected PatientController(PatientService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<Patient>> getAll(){
        return ResponseEntity.ok(service.findAll(TypeEntity.PATIENT.id));
    }
}
