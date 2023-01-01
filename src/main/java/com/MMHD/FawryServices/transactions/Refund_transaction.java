package com.MMHD.FawryServices.transactions;

import com.MMHD.FawryServices.refunds.Request;



public class Refund_transaction extends transaction{
    private final Request request;
    public Refund_transaction(Request request){
        this.request=request;
    }
    public Request getRefundRequestTransaction(){return request;}
}
