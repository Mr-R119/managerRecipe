package com.controller.impl;

import com.controller.AbstractController;
import com.model.entity.impl.Prescription;
import com.model.enums.TypeEntity;
import com.service.impl.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/prescriptions")
public class PrescriptionController extends AbstractController<Prescription, PrescriptionService> {

    protected PrescriptionController(PrescriptionService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<Prescription>> getAll(){
        List<Prescription> prescriptionList = service.findAll(TypeEntity.PRESCRIPTION.id);
        return ResponseEntity.ok(service.findAll(TypeEntity.PRESCRIPTION.id));
    }

}
