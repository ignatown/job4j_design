package ood.solid.srp.reports;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report{

    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        Comparator comparatorBySalaryDESC = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() == o2.getSalary()) {
                    return 0;
                }
                return o2.getSalary() > o1.getSalary() ? 1 : -1;
            }

        };
        List<Employee> list = store.findBy(filter);
        list.sort(comparatorBySalaryDESC);
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
