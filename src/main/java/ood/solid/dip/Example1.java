package ood.solid.dip;

import java.util.Objects;

public class Example1 {
    class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void toDoTheJob() {
            System.out.println( name + "is working...");
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    class Office{
        Employee employee = new Employee(1, "Bob");
        //Пример 1.
        //У класса Employee имеется поведение, которое может измениться.
    }
}
