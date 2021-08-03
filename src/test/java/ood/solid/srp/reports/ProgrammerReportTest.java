package ood.solid.srp.reports;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProgrammerReportTest {
    @Test
    public void whenProgrammerReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Timur", now, now, 100000);
        store.add(worker);
        Report engine = new ProgrammerReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<h>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary").append(System.lineSeparator())
                .append("</h>").append(System.lineSeparator())
                .append("<p>").append(System.lineSeparator())
                .append("<p>").append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("<p>").append(System.lineSeparator())
                .append("</p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}