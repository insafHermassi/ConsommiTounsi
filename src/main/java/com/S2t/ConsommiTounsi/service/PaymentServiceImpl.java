package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Payment;
import com.S2t.ConsommiTounsi.entities.TypePai;
import com.S2t.ConsommiTounsi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

    @Service
    public class PaymentServiceImpl implements PaymentService{
        @Autowired
        PaymentRepository paymentRepository;


        @Override
        public Payment Save(Payment paiement) {
            return paymentRepository.save(paiement);
        }

        @Override
        public Payment getPayment(long id) {
            return paymentRepository.findById(id).get();
        }

        @Override
        public List<Payment> getPayment() {
            return paymentRepository.findAll();
        }

        @Override
        public Map<String, Boolean> deletePayment(long id) {
            paymentRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("deleted", Boolean.TRUE);
            return res;
        }

        @Override
        public Payment updatePaiement(long id, Payment paiement) {
            Payment old = getPayment(id);
            old.setTypePai(paiement.getTypePai());

            return paymentRepository.save(old);
        }

        @Override
        public List<Payment> searchByTypePai(TypePai typePai) {
            return paymentRepository.findBytypePai(typePai);
        }

}
