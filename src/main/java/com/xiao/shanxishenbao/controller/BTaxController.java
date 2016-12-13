package com.xiao.shanxishenbao.controller;

import com.xiao.common.DBHelper;
import com.xiao.common.TaxpayerCodeInfo;
import com.xiao.shanxishenbao.model.FormWrapper;
import com.xiao.shanxishenbao.model.Inventory;
import com.xiao.shanxishenbao.model.MyResponseResult;
import com.xiao.shanxishenbao.model.ZB;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by knight on 16/12/12.
 */
@Controller
@RequestMapping("/v2/Tax")
public class BTaxController {

    @RequestMapping(value = "/wssb_get_ysbqc")
    @ResponseBody
    public MyResponseResult getInventoryList(@RequestParam(value = "nsrsbh",required = true) String taxPayerCode, @RequestParam(value = "user_id",required = false) String userId){


        System.out.println("nsrsbh is " + taxPayerCode);
        System.out.println("user_id is " + userId);
        List<Inventory> list = new ArrayList<Inventory>();
        Inventory inventoryB = new Inventory();
        inventoryB.setSbzt(0);
        inventoryB.setYzpzzlDm("BDA0610764");
        inventoryB.setYzpzzlMc("企业所得税B类季报");
        list.add(inventoryB);

        Inventory inventoryXgm = new Inventory();
        inventoryXgm.setSbzt(0);
        inventoryXgm.setYzpzzlDm("BDA0610611");
        inventoryXgm.setYzpzzlMc("增值税纳税申报（小规模纳税人）-营改增");
        list.add(inventoryXgm);
        return  new  MyResponseResult(0,"操作成功",list);
    }


    @RequestMapping(value = "/qysdsb_init_sbform")
    @ResponseBody
    public MyResponseResult getInitBInfo(String nsrsbh,String user_id,String skssqq,String skssqz){
        FormWrapper wrapper = new FormWrapper();
        wrapper.setNsrxx(TaxpayerCodeInfo.getInstance());


        ZB zb = new ZB();
        //第一种情况
        String sql1="Select * From ZB where ID=1";
        //第一步：查询
        ResultSet rs1 = DBHelper.executeQuery(sql1);
        //第二步：输出
        try {
            while(rs1.next()){
                zb.setId(rs1.getInt("ID"));
                zb.setSbid(rs1.getInt("RECORD_ID"));
                zb.setR1(rs1.getFloat("R1"));
                zb.setR2(rs1.getFloat("R2"));
                zb.setR3(rs1.getFloat("R3"));
                zb.setR4(rs1.getFloat("R4"));
                zb.setR5(rs1.getFloat("R5"));
                zb.setR6(rs1.getFloat("R6"));
                zb.setR7(rs1.getFloat("R7"));
                zb.setR8(rs1.getFloat("R8"));
                zb.setR9(rs1.getFloat("R9"));
                zb.setR10(rs1.getFloat("R10"));
                zb.setR11(rs1.getFloat("R11"));
                zb.setR12(rs1.getFloat("R12"));
                zb.setR13(rs1.getFloat("R13"));
                zb.setR14(rs1.getFloat("R14"));
                zb.setR15(rs1.getFloat("R15"));
                zb.setR16(rs1.getFloat("R16"));
                zb.setR17(rs1.getFloat("R17"));
                zb.setR18(rs1.getFloat("R18"));
                zb.setR19(rs1.getFloat("R19"));
                zb.setR20(rs1.getFloat("R20"));
                zb.setR21(rs1.getFloat("R21"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //第三步：关闭
        DBHelper.free(rs1);

        wrapper.setZb(zb);
        return  new  MyResponseResult(0,"操作成功",wrapper);
    }





    @Test
    public  void myTest(){
        for(int i=1;i<=21;i++){
            System.out.println(String.format(" zb.setR%s(rs1.getFloat(\"R%s\"));",i,i));
        }
    }


}
