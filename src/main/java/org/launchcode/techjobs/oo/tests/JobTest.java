package org.launchcode.techjobs.oo.tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

public class JobTest {

	Job job1 = new Job();
	Job job2 = new Job();
	Job fullJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
	Job fullJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
	Job missingDataJob = new Job("", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency(""));
	Job missingAllDataJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
	char beforeBlankLine = fullJob1.toString().charAt(0);
	char afterBlankLine = fullJob1.toString().charAt(fullJob1.toString().length() - 1);
	String testToStringWithData = "\n" +
			"ID: " + fullJob1.getId() + "\n" +
			"Name: " + fullJob1.getName() + "\n" +
			"Employer: " + fullJob1.getEmployer() + "\n" +
			"Location: " + fullJob1.getLocation() + "\n" +
			"Position Type: " + fullJob1.getPositionType() + "\n" +
			"Core Competency: " + fullJob1.getCoreCompetency() + "\n";
	String testToStringMissingData = "\n" +
			"ID: " + missingDataJob.getId() + "\n" +
			"Name: " + "Data not available" + "\n" +
			"Employer: " + "Data not available" + "\n" +
			"Location: " +  missingDataJob.getLocation() + "\n" +
			"Position Type: " + "Data not available" + "\n" +
			"Core Competency: " + "Data not available" + "\n";
	String testToStringMissingAllData = "OOPS! This job does not seem to exist.";

	@Test
	public void testSettingJobId() {
		assertFalse(job1.equals(job2));
		assertTrue(job1.getId() < job2.getId());
	}

	@Test
	public void testJobConstructorSetsAllFields() {
		assertTrue(fullJob1.getName().equals("Product tester"));
		assertTrue(fullJob1.getEmployer().getValue().equals("ACME"));
		assertTrue(fullJob1.getLocation().getValue().equals("Desert"));
		assertTrue(fullJob1.getPositionType().getValue().equals("Quality control"));
		assertTrue(fullJob1.getCoreCompetency().getValue().equals("Persistence"));
	}

	@Test
	public void testJobsForEquality() {
		assertFalse(fullJob1.equals(fullJob2));
	}

	@Test
	public void testToStringBlankLineBeforeAndAfter() {
		assertTrue(beforeBlankLine == afterBlankLine);
	}

	@Test
	public void testToStringLabelAndData() {
		assertTrue(testToStringWithData.equals(fullJob1.toString()));
	}

	@Test
	public void testToStringMissingSomeData() {
		assertTrue(testToStringMissingData.equals(missingDataJob.toString()));
	}

	@Test
	public void testToStringMissingAllData() {
		assertTrue(testToStringMissingAllData.equals(missingAllDataJob.toString()));
	}


}
