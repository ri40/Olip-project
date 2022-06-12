package com.example.olip.service;

import com.example.olip.model.Cart;
import com.example.olip.model.Payment;
import com.example.olip.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
//    public List<Payment> getPayment() {
//        return paymentRepository.findAll();
//    }

    public Payment getPaymentId(Integer id) {
        return paymentRepository.findById(id).get();
    }

//    public void addPayment(Payment payment) {
//        paymentRepository.save(payment);
//    }
//
//    public boolean updatePayment(Integer index, Payment payment) {
//        Optional<Payment> newPayment = paymentRepository.findById(payment.getId());
//        if (!newPayment.isPresent()){
//            return false;
//        }
//        newPayment.get().setId(payment.getId());
//        paymentRepository.save(payment);
//        return true;
//    }
//
//    public boolean deletePayment(Integer index) {
//        return ;
//    }
}
