package com.javatechie.crud.example.model;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {


    private Long product_id;
    private String make;
    private String model_no;
    private String processor;
    private String product_number;
    private String os;
    private String product_name;
    private String ram;
    private String hdd;
    private String cd_rom;
     private Date date;
    private String laptop_number;
    private Boolean is_active;
    private Boolean is_available;
    private Boolean is_declared;
    private Boolean is_old;
    private Long product_type;
    private String note;
    private String asset_number;




    // public boolean checkNull() throws IllegalAccessException {
    //     for (Field f : getClass().getDeclaredFields())
    //         if (f.get(this) != null)
    //             return false;
    //     return true;            
    // }
    public ProductDTO() {}
    public ProductDTO( String model_no,boolean is_old,String product_name,String product_number){
        super();
        this.is_old=is_old;
    }

    public ProductDTO(Long id,String cd_rom,String hdd,String os,String processor,
    String ram,Date date,boolean is_available,boolean is_declared,String laptop_number,String make,
    String model_no,boolean is_old,String product_name,String product_number,boolean is_active,String note){
        super();
        this.setProduct_id(id);
        this.setMake(make);
        this.setModel_no(model_no);
        this.setProcessor(processor);
        this.setProduct_name(product_name);
        this.setOs(os);
        this.setProduct_number(product_number);
        this.setNote(note);
        this.setRam(ram);
        this.setHdd(hdd);
        this.setCd_rom(cd_rom);
        this.setLaptop_number(laptop_number);
        this.setIs_available(is_available);
        this.setIs_declared(is_declared);
        this.setIs_old(is_old);
    
        
    }

    public ProductDTO(Long id,String os,String processor,
    String laptop_number,Date date,boolean is_available,boolean is_declared,String make,
    String model_no,boolean is_old,String product_name,String product_number){
        super();
       
    
        
    }





    
}
