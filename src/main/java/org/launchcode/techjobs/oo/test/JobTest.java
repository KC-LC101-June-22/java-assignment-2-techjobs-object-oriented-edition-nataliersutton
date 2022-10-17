package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //start with empty test

    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    //testing each get assigned unique ids
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    //testing if the classes are assigned/working correctly and the params/args match
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job3.getName(), "Product Tester");
        assertEquals(job3.getEmployer().getValue(),"ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(),"Quality control");
        assertEquals(job3.getCoreCompetency().getValue(),"Persistence");

        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    //checking to make sure new ids are assigned even if exact same info
    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job4.equals(job5));
    }

    //testing for newline/blank line at the start and end of all the job info when printed
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testString = job6.toString();
        assertEquals(job6.toString().charAt(0), '\n');
        assertEquals(job6.toString().charAt(job6.toString().length()-1), '\n');
    }

    //testing to make sure it prints out as expected when using the toString Method in the job class
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job7.toString(),
            "\n" + "ID: 3" +
                "\n" + "Name: Product Tester" +
                "\n" + "Employer: ACME" +
                "\n" + "Location: Desert" +
                "\n" + "Position Type: Quality control" +
                "\n" + "Core Competency: Persistence" +
                "\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("Product Tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals(job8.toString(),
            "\n" + "ID: 1" +
                "\n" + "Name: Product Tester" +
                "\n" + "Employer: ACME" +
                "\n" + "Location: Data not available" +
                "\n" + "Position Type: Quality control" +
                "\n" + "Core Competency: Data not available" +
                "\n");
    }
}
