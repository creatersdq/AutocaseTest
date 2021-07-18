package com.course.model;


import lombok.Data;

@Data
public class BncMsgEntity {
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


