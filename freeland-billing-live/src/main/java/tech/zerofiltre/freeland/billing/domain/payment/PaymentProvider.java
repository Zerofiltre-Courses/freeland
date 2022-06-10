package tech.zerofiltre.freeland.billing.domain.payment;


import tech.zerofiltre.freeland.billing.domain.payment.model.*;

import java.util.*;

public interface PaymentProvider {

  Optional<Payment> paymentOfId(String paymentId);

  Payment registerPayment(Payment payment);

}
