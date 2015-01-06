package no.nith.pg6100;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class TransactionConfigBean {

    @Resource
    private TransactionSynchronizationRegistry transaction;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public TransactionStatus required() {
        return new TransactionStatus(transaction.getTransactionStatus());
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public TransactionStatus requiresNew() {
        return new TransactionStatus(transaction.getTransactionStatus());
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public TransactionStatus supports() {
        return new TransactionStatus(transaction.getTransactionStatus());
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public TransactionStatus mandatory() {
        return new TransactionStatus(transaction.getTransactionStatus());
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public TransactionStatus notSupported() {
        return new TransactionStatus(transaction.getTransactionStatus());
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public TransactionStatus never() {
        return new TransactionStatus(transaction.getTransactionStatus());
    }


}
