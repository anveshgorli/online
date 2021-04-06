package com.cg.drycleaning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.Payment;

/************************************************************************************************
 *          @author         G. Anvesh
 *          Description     IPaymentRepository is an interface which extends JPA repository.
 *          				This class belongs to DAO layer. It is used to perform CRUD operations
 *          				with our entities by defining JPA repositories for automatic 
 *          				and intelligent implementations.                     					  
 *         	Version         1.0
 *         	Created Date    23-MARCH-2021
 **************************************************************************************************/
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}
