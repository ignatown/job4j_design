package ood.solid.srp.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

public class XMLReport implements Report{

    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> employeesList = new ArrayList<>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                for (Employee employee : store.findBy(filter)) {
                    employeesList.add(employee);
                }
                Employees employees = new Employees(employeesList);
                marshaller.marshal(employees, writer);
                text.append(writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    @XmlRootElement(name = "Employees")
    public static class Employees {

        private List<Employee> employees;

        public Employees() {}

        public Employees(List<Employee> employees) {
            this.employees = employees;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setUsers(List<Employee> users) {
            this.employees = employees;
        }
    }
}
