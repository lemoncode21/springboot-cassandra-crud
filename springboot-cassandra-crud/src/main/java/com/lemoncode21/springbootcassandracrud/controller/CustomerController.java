package com.lemoncode21.springbootcassandracrud.controller;


import com.lemoncode21.springbootcassandracrud.model.Customer;
import com.lemoncode21.springbootcassandracrud.response.ResponseHandler;
import com.lemoncode21.springbootcassandracrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // save
    @PostMapping("/save")
    public ResponseHandler save(@RequestBody Customer customer){
        try{
            this.customerService.save(customer);
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success saved data!");
        }catch (Exception e ){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(), e.getMessage());
        }
    }

    // get all
    @GetMapping
    public ResponseHandler getAll(){
        try{
            List<Customer> customerList = this.customerService.getAll();
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success get all data!",customerList);
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(), e.getMessage());
        }
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseHandler getById(@PathVariable Long id){
        try{
            Optional<Customer> customer = this.customerService.getById(id);
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success get by id data!",customer);
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(), e.getMessage());
        }
    }

    // update
    @PutMapping("/{id}")
    public ResponseHandler update(@PathVariable Long id,@RequestBody Customer customer){
        try{
            this.customerService.update(id,customer);
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success update data!");
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(), e.getMessage());
        }
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseHandler delete(@PathVariable Long id){
        try{
            this.customerService.delete(id);
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success delete data!");
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(), e.getMessage());
        }
    }

}
