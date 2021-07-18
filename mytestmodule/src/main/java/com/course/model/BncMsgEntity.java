package com.course.model;

import java.io.Serializable;

public class BncMsgEntity  implements Serializable {

    private int id ;
    private  String  nps_id;
    private  String  waybill_no;
    private  String  send_org_code;
    private  String  send_org_name;
    private  String  send_user_code;
    private  String  send_user_name;
    private  String  receive_org_code;
    private  String  receive_org_name;
    private  String  receive_user_code;
    private  String  receive_user_name;
    private  String  content;
    private  String  accept_status;
    private  String  sender;



    public BncMsgEntity(String  nps_id,
                   String  waybill_no,
                   String  send_org_code,
                   String  send_org_name,
                   String  send_user_code,
                   String  send_user_name,
                   String  receive_org_code,
                   String  receive_org_name,
                   String  receive_user_code,
                   String  receive_user_name,
                   String  content,
                   String  accept_status,
                   String  sender){

        this.nps_id=nps_id;
        this.waybill_no=waybill_no;
        this.send_org_code=send_org_code;
        this.send_org_name=send_org_name;
        this.send_user_code=send_user_code;
        this.send_user_name=send_user_name;
        this.receive_org_code=receive_org_code;
        this.receive_org_name=receive_org_name;
        this.receive_user_code=receive_user_code;
        this.receive_user_name=receive_user_name;
        this.content=content;
        this.accept_status=accept_status;
        this.sender=sender;
    }
















}
