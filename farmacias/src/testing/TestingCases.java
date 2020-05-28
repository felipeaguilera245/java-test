package testing;

import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import models.Pharma;

public class TestingCases {

	@Test
	public void test1() {

		System.out.println("testing comunas");

		Pharma pharma = new Pharma();

		JSONObject test1 = pharma.getComunes();
		assertTrue(test1 != null);
		assertTrue(test1.toString().contains("SAN MIGUEL"));

	}

	@Test
	public void test2() {

		System.out.println("testing farmacias");

		Pharma pharma = new Pharma();

		JSONObject test2 = pharma.getPharmaNames();

		assertTrue(test2 != null);
		assertTrue(test2.toString().contains("DEL DR. SIMI"));

	}

	@Test
	public void testing() {

		System.out.println("testing RESULTS");

		Pharma pharma = new Pharma();

		JSONObject test3 = pharma.getList("127", "SALCOBRAND");

		assertTrue(test3.toString().contains("SALESIANOS 1334, LOCAL 1"));

	}

}
