package com.controller.impl;

import com.controller.AbstractController;
import com.model.entity.impl.Doctor;
import com.model.enums.TypeEntity;
import com.service.impl.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/doctors")
public class DoctorController extends AbstractController<Doctor, DoctorService> {

    protected DoctorController(DoctorService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<Doctor>> getAll(){
        return ResponseEntity.ok(service.findAll(TypeEntity.DOCTOR.id));
    }
}


