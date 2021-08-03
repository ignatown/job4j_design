package ood.solid.srp.reports;

import java.util.function.Predicate;

public class BookerReport implements Report{

    private Store store;

    public BookerReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * 0.014).append(";") // Salary RUB -> USD
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
