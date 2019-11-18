package com.github.PiotrDuma.DrugsWebDB;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarcodeRequest {

	@RequestMapping("/DrugsWebDB/{barcode}")
	public String getValue(@PathVariable long barcode) {
		Drug drug = Database.getDrugByBarcode(barcode);
		String response = (drug==null)?"Nothing found.":drug.toJSON().toString();
		return response;
	}
	
}
