package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Payment;
import com.S2t.ConsommiTounsi.entities.TypePai;

import java.util.List;
import java.util.Map;

public interface PaymentService {
    public Payment Save(Payment paiement);

    public Payment getPayment(long id);

    public List<Payment> getPayment();

    public Map<String, Boolean> deletePayment(long id);

    public Payment updatePaiement(long id, Payment paiement);

    public List<Payment> searchByTypePai(TypePai typePai);
}
