package tech.zerofiltre.freeland.billing.infra.providers.dummy;

import org.springframework.stereotype.*;
import tech.zerofiltre.freeland.billing.domain.payment.*;
import tech.zerofiltre.freeland.billing.domain.payment.model.*;

import java.util.*;

@Component
public class DummyPaymentProvider implements PaymentProvider {
    @Override
    public Optional<Payment> paymentOfId(String paymentId) {
        return Optional.of(Payment.builder().paymentId(Integer.parseInt(paymentId)).build());
    }

    @Override
    public Payment registerPayment(Payment payment) {
        return payment;
    }
}
