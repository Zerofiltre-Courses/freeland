package tech.zerofiltre.freeland.billing.domain.bill;


import tech.zerofiltre.freeland.billing.domain.bill.model.*;

public interface BillProvider {

    Bill billOfId(String billId);

    Bill registerBill(Bill bill);

}
