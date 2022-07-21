package com.rik.regsys.data.paymentmethod;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {
    @Autowired
    private final PaymentRepository paymentRepository;

    public List<PaymentEntity> findAll(){return new ArrayList<>(paymentRepository.findAll());}

}
