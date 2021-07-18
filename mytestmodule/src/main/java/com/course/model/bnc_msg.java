package com.course.model;

import lombok.Data;

//查询在线通知接口model
@Data
public class bnc_msg {


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
    private  String  context;
    private  String  accept_status;
    private  String  sender;


/*
    //构造方法
    public bnc_msg(String  nps_id,
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
    }*/




// 覆写toString方法，确定返回字段格式及顺序
   @Override
    public  String toString(){
       return(
                       "nps_id:"+nps_id+","+
                       "waybill_no:"+waybill_no+","+
                       "send_org_code:"+send_org_code+","+
                       "send_org_name:"+send_org_name+","+
                       "send_user_code:"+send_user_code+","+
                       "send_user_name:"+send_user_name+","+
                       "receive_org_code:"+receive_org_code+","+
                       "receive_user_code:"+receive_user_code+","+
                       "Receive_user_name:"+receive_user_name+","+
                       "content:"+context+","+
                       "accept_status:"+accept_status+","+
                       "sender:"+sender
               );
   }

}
