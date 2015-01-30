package no.nith.pg6100;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class Controller {
    private static final String NEW_TRANSACTION = "New transaction";
    private static final String CALLER_TRANSACTION = "Caller's transaction";
    private static final String NO_TRANSACTION = "No transaction";

    @Inject
    private TransactionConfigBean transactionConfigBean;
    private TransactionStatus lastStatus = null;

    public TransactionStatus getLastStatus() {
        return lastStatus;
    }

    @Transactional
    public void requiredInTransaction() {
        lastStatus = transactionConfigBean.required();
        lastStatus.setType("'Required' in transaction");
        lastStatus.setText(CALLER_TRANSACTION);
    }

    @Transactional
    public void requiresNewInTransaction() {
        lastStatus = transactionConfigBean.requiresNew();
        lastStatus.setType("'Requires new' in transaction");
        lastStatus.setText(NEW_TRANSACTION);
    }

    @Transactional
    public void supportsInTransaction() {
        lastStatus = transactionConfigBean.supports();
        lastStatus.setType("'Supports' in transaction");
        lastStatus.setText(CALLER_TRANSACTION);
    }

    @Transactional
    public void mandatoryInTransaction() {
        lastStatus = transactionConfigBean.mandatory();
        lastStatus.setType("'Mandatory' in transaction");
        lastStatus.setText(CALLER_TRANSACTION);
    }

    @Transactional
    public void notSupportedInTransaction() {
        lastStatus = transactionConfigBean.notSupported();
        lastStatus.setType("'Not supported' in transaction");
        lastStatus.setText(NO_TRANSACTION);
    }

    @Transactional
    public void neverInTransaction() {
        lastStatus = transactionConfigBean.never();
    }


    public void requiredNotInTransaction() {
        lastStatus = transactionConfigBean.required();
        lastStatus.setType("'Required' not in transaction");
        lastStatus.setText(NEW_TRANSACTION);
    }

    public void requiresNewNotInTransaction() {
        lastStatus = transactionConfigBean.requiresNew();
        lastStatus.setType("'Requires new' not in transaction");
        lastStatus.setText(NEW_TRANSACTION);
    }

    public void supportsNotInTransaction() {
        lastStatus = transactionConfigBean.supports();
        lastStatus.setType("'Supports' not in transaction");
        lastStatus.setText(NO_TRANSACTION);
    }

    public void mandatoryNotInTransaction() {
        lastStatus = transactionConfigBean.mandatory();
    }

    public void notSupportedNotInTransaction() {
        lastStatus = transactionConfigBean.notSupported();
        lastStatus.setType("'Not supported' not in transaction");
        lastStatus.setText(NO_TRANSACTION);
    }

    public void neverNotInTransaction() {
        lastStatus = transactionConfigBean.never();
        lastStatus.setType("'Never' not in transaction");
        lastStatus.setText(NO_TRANSACTION);
    }
}
