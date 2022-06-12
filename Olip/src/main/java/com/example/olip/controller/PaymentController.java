package com.example.olip.controller;

import com.example.olip.model.Payment;
import com.example.olip.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;
    Logger logger = LoggerFactory.getLogger(PaymentController.class);

//    @GetMapping
//    public ResponseEntity<List<Payment>> getPayment(){
//        logger.info("Get All Payment");
//        return ResponseEntity.status(200).body(paymentService.getPayment());
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentId(@PathVariable @Valid Integer id){
        logger.info("Get Payment");
        return ResponseEntity.status(200).body(paymentService.getPaymentId(id));
    }
//    @PostMapping("/add")
//    public ResponseEntity<Api> addPayment(@RequestBody @Valid Payment payment){
//        logger.info("Add Payment");
//        paymentService.addPayment(payment);
//        return ResponseEntity.status(201).body(new Api("Payment added!",201));
//    }
//    @PutMapping("{index}")
//    public ResponseEntity<Api> updatePayment(@RequestBody @Valid Payment payment,@PathVariable Integer index) {
//        logger.info("Update Item");
//        paymentService.updatePayment(index,payment);
//        return ResponseEntity.status(201).body(new Api("Payment updated!", 201));
//    }
//    @DeleteMapping("{index}")
//    public ResponseEntity<Api> deleteItem(@PathVariable Integer index) {
//        logger.info("Delete Payment");
//        paymentService.deletePayment(index);
//        return ResponseEntity.status(201).body(new Api("Payment delete", 201));
//    }

}
