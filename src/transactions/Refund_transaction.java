package transactions;

import refunds.Request;
import user.User;

public class Refund_transaction extends transaction{
    private final Request request;
    public Refund_transaction(User user, Request request){
        super(user);
        this.request=request;
    }
    public Request getRefundRequestTransaction(){return request;}
}
