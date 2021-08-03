package ood.solid.srp.reports;

import java.util.function.Predicate;

public class ProgrammerReport implements Report{

    private Store store;

    public ProgrammerReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<h>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary").append(System.lineSeparator())
                .append("</h>").append(System.lineSeparator())
                .append("<p>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>").append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator())
                    .append("<p>").append(System.lineSeparator());
        }
        text.append("</p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");
        return text.toString();
    }
}
