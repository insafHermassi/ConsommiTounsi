package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.Payment;
import com.S2t.ConsommiTounsi.entities.TypePai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

        public List<Payment> findBytypePai(TypePai typePai);
}
