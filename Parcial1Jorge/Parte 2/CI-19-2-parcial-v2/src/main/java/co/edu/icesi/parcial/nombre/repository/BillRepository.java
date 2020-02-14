package co.edu.icesi.parcial.nombre.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.parcial.nombre.model.Bill;

@Scope("singleton")
public class BillRepository {

	private Map<String,Bill>  bills;
	
	public BillRepository() {
		bills = new HashMap<String,Bill>();
	}
	
	public void addBills(Bill bill) {
		if(!bills.containsKey(bill.getId())) {
			bills.put(bill.getId(), bill);
		}
	}
	
	public void deleteBills(Bill bill) {
		if(bills.containsKey(bill.getId())) {
			bills.remove(bill.getId(), bill);
		}
	}
	
	public Bill readBill(String id){
		return bills.get(id);
	}
}
