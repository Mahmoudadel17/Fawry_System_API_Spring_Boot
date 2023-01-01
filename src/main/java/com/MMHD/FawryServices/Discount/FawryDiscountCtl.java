package com.MMHD.FawryServices.Discount;


import com.MMHD.FawryServices.user.All_Users;
import com.MMHD.FawryServices.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.MMHD.FawryServices.user.FawryLoginCtl.currentUserId;

@RestController
public class FawryDiscountCtl {
    All_Users allUsers = new All_Users();
    @GetMapping(value = "/Discount/CheckDiscount")
    public ResponseEntity<long[]> CheckDiscount(){

        long[] arr={0,0,0,0};
        if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "mobile recharge")){
            arr[0]=SpecificDiscount.getDiscount();
        }else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "internet payment")){
            arr[1]=SpecificDiscount.getDiscount();

        }else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "landline")){
            arr[2]=SpecificDiscount.getDiscount();

        }else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "donations")){
            arr[3]=SpecificDiscount.getDiscount();

        }
        User user = allUsers.Search_About_UserID(currentUserId);
        if (user != null){
            if ( user.getAllServicesPay().size() == 0){
                for (int i=0; i<4;i++){
                    arr[i]+= OverallDiscounts.getDiscount();
                }
            }
            return ResponseEntity.ok( arr);
        }
        return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();
    }

    @PostMapping(value = "/Discount/AddOverallDiscount/{discount}")
    public ResponseEntity<String> AddOverallDiscount(@PathVariable("discount") int discountValue){
        if (discountValue<0 || discountValue>100){
            return ResponseEntity.badRequest().body("invalid data");
        }
        OverallDiscounts.setDiscount(discountValue);
        return ResponseEntity.ok("Discount Added successful");
    }
    @PostMapping(value = "/Discount/AddSpecificDiscount/{discount}/{select}")
    public ResponseEntity<String> AddSpecificDiscount(@PathVariable("discount")int discountValue,@PathVariable("select") int selectServices){
        if (discountValue<0 || discountValue>100 || selectServices <1 || selectServices>4){
            return ResponseEntity.badRequest().body("invalid data");
        }
        SpecificDiscount.setDiscount(discountValue);
        if (selectServices==1){
            SpecificDiscount.setServicesNameDiscount("mobile recharge");
        }else if (selectServices==2){
            SpecificDiscount.setServicesNameDiscount("internet payment");
        }else if (selectServices==3){
            SpecificDiscount.setServicesNameDiscount("landline");
        }else {
            SpecificDiscount.setServicesNameDiscount("donations");
        }
        return ResponseEntity.ok("Discount Added successful");
    }



}
