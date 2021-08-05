package ood.solid.srp.reports;

import java.util.List;
import java.util.function.Predicate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONReport implements Report{

    private Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().create();
        List<Employee> employeeList = store.findBy(filter);
        return gson.toJson(employeeList);
    }
}
