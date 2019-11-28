package com.github.PiotrDuma.DrugsWebDB;

import com.github.PiotrDuma.DrugsWebDB.Drug;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

public class DrugTest {

	Drug drug=null;
	
	@Before
	public void init() {
		this.drug = new Drug.Builder()
				.setName("ABAKTAL")
				.setProducent("SANDOZ")
				.setDose("0,4 G")
				.setContents("10 TABL.")
				.build();
	}
	
	@Test
	public void notNullObject() {
		assertNotNull(drug);
	}
	@Test
	public void valuesTest() {
		assertEquals("ABAKTAL", this.drug.getName());
		assertEquals("SANDOZ", this.drug.getProducent());
		assertEquals("0,4 G", this.drug.getDose());
		assertEquals("10 TABL.", this.drug.getContents());
	}
	
	@Test
	public void builderTest() {
		Drug initDrug = new Drug("ABAKTAL","SANDOZ","0,4 G","10 TABL.");		
//		assertThat(initDrug, same);
		assertTrue(new ReflectionEquals( initDrug).matches(this.drug) );
	}
	
	@Test
	public void JsonTest() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "ABAKTAL");
		jsonObject.put("producent", "SANDOZ");
		jsonObject.put("dose","0,4 G");
		jsonObject.put("contents", "10 TABL.");

		assertTrue(new ReflectionEquals(jsonObject).matches(this.drug.toJSON()));
	}
	

	@Test
	public void toStringTest() {
		String test = "name: ABAKTAL, producent: SANDOZ, dose: 0,4 G, contents: 10 TABL.";
		assertEquals(test, this.drug.toString());
//		assertTrue(new ReflectionEquals(test).matches(this.drug.toJSON()));
	}
}