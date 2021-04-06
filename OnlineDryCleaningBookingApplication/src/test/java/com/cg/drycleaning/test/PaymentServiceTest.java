package com.cg.drycleaning.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.drycleaning.beans.Card;
import com.cg.drycleaning.beans.Payment;
import com.cg.drycleaning.service.IPaymentService;

/************************************************************************************
* @author         G. Anvesh
* Description     It is a test class that provides the TestCases to test the
*                 Payment Service class
* Version         1.0
* Created Date    22-MARCH-2021
************************************************************************************/
@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	private IPaymentService iPaymentService;
	
	/************************************************************************************
	* @author         G. Anvesh
	* Description     Test case for addPayment
	* Version         1.0
	* Created Date    22-MARCH-2021
	************************************************************************************/
	@Test
	public void addPaymentTest() {
		Payment payment = new Payment(1, "Online", "Pending", null);
		Card card = new Card(1, "GORLI ANVESH", "65465445", LocalDate.of(2022, 12, 8), "SBI");
		payment.setCard(card);
		assertEquals("Pending", iPaymentService.addPayment(payment).getStatus());
	}
	
	/************************************************************************************
	* @author         G. Anvesh
	* Description     Test case for removePayment
	* Version         1.0
	* Created Date    22-MARCH-2021
	************************************************************************************/
	@Test
	public void removePaymentTest() {
		Payment payment = new Payment(1, "Online", "Pending", null);
		Card card = new Card(1, "GORLI ANVESH", "65465445", LocalDate.of(2022, 12, 8), "SBI");
		payment.setCard(card);
		iPaymentService.addPayment(payment);
		assertEquals("Online", iPaymentService.removePayment(1).getType());
	}
	
	/************************************************************************************
	* @author         G. Anvesh
	* Description     Test case for updatePayment
	* Version         1.0
	* Created Date    22-MARCH-2021
	************************************************************************************/
	@Test
	public void updatePaymentTest() {
		Payment payment = new Payment(2, "Offline", "Success", null);
		Card card = new Card(2, "A RAM BABU", "456531465", LocalDate.of(2022, 12, 9), "AXIS");
		payment.setCard(card);
		iPaymentService.addPayment(payment);
		payment.setPaymentId(2);
		assertEquals(2, iPaymentService.updatePayment(2, payment).getPaymentId());
	}
	
	/************************************************************************************
	* @author         G. Anvesh
	* Description     Test case for getPaymentDetails
	* Version         1.0
	* Created Date    22-MARCH-2021
	************************************************************************************/
	@Test
	public void getPaymentDetailsTest() {
		Payment payment = new Payment(2, "Offline", "Success", null);
		Card card = new Card(2, "GORLI ANVESH", "456531465", LocalDate.of(2022, 12, 9), "AXIS");
		payment.setCard(card);
		iPaymentService.addPayment(payment);
		assertEquals("456531465", iPaymentService.getPaymentDetails(2).getCard().getCardNumber());
	}
	
	/************************************************************************************
	* @author         G. Anvesh
	* Description     Test case for getAllPaymentDetails
	* Version         1.0
	* Created Date    22-MARCH-2021
	************************************************************************************/
	@Test
	public void getAllPaymentDetailsTest() {
		Payment payment = new Payment(1, "Online", "Pending", null);
		Card card = new Card(1, "GORLI ANVESH", "65465445", LocalDate.of(2022, 12, 8), "SBI");
		payment.setCard(card);
		iPaymentService.addPayment(payment);
		assertEquals(2, iPaymentService.getAllPaymentDetails().size());
	}

}