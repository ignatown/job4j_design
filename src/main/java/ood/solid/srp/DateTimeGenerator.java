package ood.solid.srp;

// 1 Пример
// Следовало бы создать 2 отдельных интерфейса DateGenerator и TimeGenerator
public interface DateTimeGenerator {
    public String dateGenerate(String year, String month, String day);
    public String timeGenerate(String hour, String min);
}
