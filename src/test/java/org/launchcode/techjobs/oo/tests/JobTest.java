package org.launchcode.techjobs.oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

public class JobTest {

	Job job1;
	Job job2;
	Job fullJob1;
	Job fullJob2;

	@Before
	public void createJobObject() {
		job1 = new Job();
		job2 = new Job();
		fullJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
		fullJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
	}

	@Test
	public void testSettingJobId() {
		job1.getId();
		job2.getId();
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

}
