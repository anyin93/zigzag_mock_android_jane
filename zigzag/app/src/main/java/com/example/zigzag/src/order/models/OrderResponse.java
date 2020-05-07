package com.example.zigzag.src.order.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrderResponse {


    public class OrderResult {

        @SerializedName("date")
        private String date;
        @SerializedName("order_id")
        private int orderId;
        @SerializedName("")
        private ArrayList<OrderItem> orderItems;

        public String getDate() {
            return date;
        }

        public int getOrderId() {
            return orderId;
        }

        public ArrayList<OrderItem> getOrderItems() {
            return orderItems;
        }
    }
    @SerializedName("result")
    private OrderResult ordersResult;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("is_success")
    private boolean is_success;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public OrderResult getOrdersResult() {
        return ordersResult;
    }

    public boolean isIs_success() {
        return is_success;
    }


}
