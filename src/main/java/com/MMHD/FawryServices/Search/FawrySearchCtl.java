package com.MMHD.FawryServices.Search;


import com.MMHD.FawryServices.Services.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Objects;

@RestController
public class FawrySearchCtl {
    @RequestMapping(value = "/Search/{nameService}",method = RequestMethod.GET)
    public ResponseEntity<LinkedList<String>> Search_About_Service(@PathVariable("nameService") String nameService) {

        if (Objects.equals(nameService, null)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        SearchingList searchingList = new SearchingList();
        LinkedList<Service> matchServices = searchingList.Search(nameService);
        LinkedList<String> allNameServices = new LinkedList<>();
        for (Service matchService : matchServices) {
            allNameServices.add(matchService.getName());
        }
        return ResponseEntity.ok(allNameServices);
    }
}
