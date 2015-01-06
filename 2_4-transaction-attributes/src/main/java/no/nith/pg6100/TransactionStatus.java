package no.nith.pg6100;

import javax.transaction.Status;

public class TransactionStatus {
    private final int statusCode;
    private String type;
    private String text;

    public TransactionStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatusCode() {
        switch (statusCode) {
            case Status.STATUS_ACTIVE:
                return "ACTIVE";
            case Status.STATUS_COMMITTED:
                return "COMMITTED";
            case Status.STATUS_COMMITTING:
                return "COMMITTING";
            case Status.STATUS_MARKED_ROLLBACK:
                return "MARKED ROLLBACK";
            case Status.STATUS_NO_TRANSACTION:
                return "NO TRANSACTION";
            case Status.STATUS_PREPARED:
                return "PREPARED";
            case Status.STATUS_PREPARING:
                return "PREPARING";
            case Status.STATUS_ROLLEDBACK:
                return "ROLLED BACK";
            case Status.STATUS_ROLLING_BACK:
                return "ROLLING BACK";
            default:
                return "UNKNOWN";
        }
    }
}
