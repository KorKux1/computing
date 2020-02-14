package co.edu.icesi.parcial.nombre.logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.icesi.parcial.nombre.model.Bill;
import co.edu.icesi.parcial.nombre.repository.BillRepository;

@Scope("singleton")
public class BillLogic {

	private BillRepository repository;
	

	public void addBill(Bill student) {
		repository.addBills(student);
	}

	public Bill getBill(String id) {
		return repository.readBill(id);
	}

	public void deleteBill(Bill student) {
		repository.deleteBills(student);
	}
}
