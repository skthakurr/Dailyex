package com.Dailyex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dailyex.model.Stores;
import com.Dailyex.service.StoreService;

@RestController
@RequestMapping("/storeservice")
public class StoreServiceController {
	
		StoreService storeService;
		
		public StoreServiceController(StoreService storeService) {
			this.storeService = storeService;
		}
	
	   //read specific store from DB
		@GetMapping("/{storeId}")
	    public Stores getStoreInfo(@PathVariable String storeId) {
			int sId = Integer.parseInt(storeId);
	        return storeService.getStores(sId);
	    }


		//read all the stores from db
		@GetMapping
	    public List<Stores> getAllStoreInfo() {
	        return storeService.listAllStores();
	    }
	    
	    
		//create store
	    @PostMapping
	    public int createStore(@RequestBody Stores store) {
	    	return storeService.createStore(store);
	    }
	    
	  //update store details
	    @PutMapping
	    public int updateStore(@RequestBody Stores store) {
	    	return storeService.updateStore(store);
	    }
	    
	    
	  //delete store
	    @DeleteMapping("/{storeId}")
	    public void updateStore(@PathVariable String storeId) {
	    	int sId = Integer.parseInt(storeId);
	    	storeService.deleteStores(sId);
	    }



	    

}