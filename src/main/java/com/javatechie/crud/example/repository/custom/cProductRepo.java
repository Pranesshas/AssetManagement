package com.javatechie.crud.example.repository.custom;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.model.ProductDTO;
import com.javatechie.crud.example.response.OperationResponse;
import com.javatechie.crud.example.response.SearchResponse;

@Repository
public class cProductRepo {

    @PersistenceContext
	private EntityManager em;


    public SearchResponse getAllUsersPagination(ProductDTO productDTO,Integer startPosition){
        
        StringBuilder queryStr=new StringBuilder("select p.id,p.cd_rom,p.hdd,p.os,p.processor,p.ram,p.date,p.is_available,p.is_declared,p.laptop_number,p.make,p.model_no,p.is_old,a.asset_name as product_name,p.product_number,p.is_active,p.note from product p" 
        +" JOIN asset a ON a.id= p.product_type   where p.is_active=1 ");
        StringBuilder countQueryStr= new StringBuilder("select count(p.id) from product p" 
        +" JOIN asset a ON a.id= p.product_type   where p.is_active=1 ");
        //     // boolean value = productDTO.checkNull();
        //     // System.out.println(value);
        // } catch (IllegalAccessException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } 
            if(productDTO.getProduct_id()!=null && !productDTO.getProduct_id().equals(0L)){
                queryStr.append(" and p.id= :asset_id ");
                countQueryStr.append(" and p.id= :asset_id ");
            }
        

        if(productDTO.getProcessor()!=null && !productDTO.getProcessor().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.processor) Like :processor ");
            countQueryStr.append(" and lower(p.processor) Like :processor ");
        }

        if(productDTO.getMake()!=null && !productDTO.getMake().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.make) Like :make ");
            countQueryStr.append(" and lower(p.make) Like :make ");
        }

        if(productDTO.getModel_no()!=null && !productDTO.getModel_no().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.model_no) Like :model_no ");
            countQueryStr.append(" and lower(p.model_no) Like :model_no ");
        }

        if(productDTO.getProduct_number()!=null && !productDTO.getProduct_number().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.product_number) Like :product_number ");
            countQueryStr.append(" and lower(p.product_number) Like :product_number ");
        }

        if(productDTO.getOs()!=null && !productDTO.getOs().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.os) Like :os ");
            countQueryStr.append(" and lower(p.os) Like :os ");
        }

        if(productDTO.getProduct_type()!=null && !productDTO.getProduct_type().equals(0L)){
            queryStr.append(" and p.product_type =:product_type ");
            countQueryStr.append(" and p.product_type =:product_type ");
        }

        if(productDTO.getRam()!=null && !productDTO.getRam().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.ram) Like :ram ");
            countQueryStr.append(" and lower(p.ram) Like :ram ");
        }

        if(productDTO.getHdd()!=null && !productDTO.getHdd().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.hdd) Like :hdd ");
            countQueryStr.append(" and lower(p.hdd) Like :hdd ");
        }

        if(productDTO.getCd_rom()!=null && !productDTO.getCd_rom().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.cd_rom) Like :cd_rom ");
            countQueryStr.append(" and lower(p.cd_rom) Like :cd_rom ");
        }

        if(productDTO.getLaptop_number()!=null && !productDTO.getLaptop_number().equalsIgnoreCase("")){
            queryStr.append(" and lower(p.laptop_number) Like :laptop_number ");
            countQueryStr.append(" and lower(p.laptop_number) Like :laptop_number ");
        }

        if(productDTO.getIs_available()!=null){
            if(productDTO.getIs_available()==true){

            queryStr.append(" and p.is_available =1 ");
				countQueryStr.append(" and p.is_available =1 ");
			} else {
				queryStr.append(" and p.is_available = 0 ");
				countQueryStr.append(" and p.is_available = 0 ");
			}

        }

        if(productDTO.getIs_declared()!=null){
            if(productDTO.getIs_declared()==true){

            queryStr.append(" and p.is_declared = 1 ");
				countQueryStr.append(" and p.is_declared = 1 ");
			} else {
				queryStr.append(" and p.is_declared = 0 ");
				countQueryStr.append(" and p.is_declared = 0 ");
			}

        }
        queryStr.append(" ORDER BY p.id desc ");
		countQueryStr.append(" ORDER BY p.id desc ");
        
        Query query = em.createNativeQuery(queryStr.toString(),"ProductMapping");

		Query countQuery = em.createNativeQuery(countQueryStr.toString());

        if(productDTO.getProduct_id()!=null && !productDTO.getProduct_id().equals(0L)){
            query.setParameter("asset_id", productDTO.getProduct_id());
            countQuery.setParameter("asset_id", productDTO.getProduct_id());

        }


        if(productDTO.getMake()!=null && !productDTO.getMake().equalsIgnoreCase("")){
           query.setParameter("make", "%" + productDTO.getMake().trim() +"%");
           countQuery.setParameter("make", "%" + productDTO.getMake().trim() +"%");
        }

        if(productDTO.getProduct_type()!=null && !productDTO.getProduct_type().equals(0L)){
            query.setParameter("product_type",productDTO.getProduct_type());
            countQuery.setParameter("product_type", productDTO.getProduct_type());
        }
        
        if(productDTO.getModel_no()!=null && !productDTO.getModel_no().equalsIgnoreCase("")){
            query.setParameter("model_no","%" + productDTO.getModel_no().trim() +"%");
            countQuery.setParameter("model_no","%" + productDTO.getModel_no().trim() +"%");
        }

        if(productDTO.getProcessor()!=null && !productDTO.getProcessor().equalsIgnoreCase("")){
            query.setParameter("processor","%" + productDTO.getProcessor().trim() +"%");
            countQuery.setParameter("processor","%" + productDTO.getProcessor().trim() +"%");
        }

        if(productDTO.getProduct_number()!=null && !productDTO.getProduct_number().equalsIgnoreCase("")){
            query.setParameter("product_number","%" + productDTO.getProduct_number().trim() +"%");
            countQuery.setParameter("product_number","%" + productDTO.getProduct_number().trim() +"%");
        }

        if(productDTO.getOs()!=null && !productDTO.getOs().equalsIgnoreCase("")){
            query.setParameter("os","%" + productDTO.getOs().trim() +"%");
            countQuery.setParameter("os","%" + productDTO.getOs().trim() +"%");
        }

        if(productDTO.getRam()!=null && !productDTO.getRam().equalsIgnoreCase("")){
            query.setParameter("ram","%" + productDTO.getRam().trim() +"%");
            countQuery.setParameter("ram","%" + productDTO.getRam().trim() +"%");
        }

        if(productDTO.getHdd()!=null && !productDTO.getHdd().equalsIgnoreCase("")){
            query.setParameter("hdd","%" + productDTO.getHdd().trim() +"%");
            countQuery.setParameter("hdd","%" + productDTO.getHdd().trim() +"%");
        }

        if(productDTO.getCd_rom()!=null && !productDTO.getCd_rom().equalsIgnoreCase("")){
            query.setParameter("cd_rom","%" + productDTO.getCd_rom().trim() +"%");
            countQuery.setParameter("cd_rom","%" + productDTO.getCd_rom().trim() +"%");
        }

        if(productDTO.getLaptop_number()!=null && !productDTO.getLaptop_number().equalsIgnoreCase("")){
            query.setParameter("laptop_number","%" + productDTO.getLaptop_number().trim() +"%");
            countQuery.setParameter("laptop_number","%" + productDTO.getLaptop_number().trim() +"%");
        }

        query.setFirstResult(startPosition);
        query.setMaxResults(10);
        List<ProductDTO> AssetList= query.getResultList();
        BigInteger countResults = (BigInteger) countQuery.getSingleResult();

        SearchResponse resp=new SearchResponse();
        resp.setAssetList(AssetList);
        resp.setAssetCount(countResults);
        return resp;
    }
    
}
