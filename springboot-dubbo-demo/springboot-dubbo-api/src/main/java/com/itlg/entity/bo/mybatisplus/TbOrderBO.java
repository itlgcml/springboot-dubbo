package com.itlg.entity.bo.mybatisplus;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TbOrderBO implements Serializable {
    private Long orderId;

    private Long totalPay;

    private Long actualPay;

    private String promotionIds;

    private Byte paymentType;

    private Long postFee;

    private Date createTime;

    private String shippingName;

    private String shippingCode;

    private String userId;

    private String buyerMessage;

    private String buyerNick;

    private Boolean buyerRate;

    private String receiverState;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverMobile;

    private String receiverZip;

    private String receiver;

    private Integer invoiceType;

    private Integer sourceType;
}
