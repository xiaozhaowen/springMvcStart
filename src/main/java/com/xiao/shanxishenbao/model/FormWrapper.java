package com.xiao.shanxishenbao.model;

import com.xiao.common.TaxpayerCodeInfo;

import java.util.Map;

/**
 * Created by knight on 16/12/12.
 */
public class FormWrapper {
    public FormWrapper() {
    }

    private TaxpayerCodeInfo nsrxx;
    private ZB zb;

    public TaxpayerCodeInfo getNsrxx() {
        return nsrxx;
    }

    public void setNsrxx(TaxpayerCodeInfo nsrxx) {
        this.nsrxx = nsrxx;
    }


    public ZB getZb() {
        return zb;
    }

    public void setZb(ZB zb) {
        this.zb = zb;
    }
}
