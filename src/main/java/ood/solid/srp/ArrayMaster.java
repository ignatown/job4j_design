package ood.solid.srp;

// 3 Пример
// Следовало бы создать 2 отдельных интерфейса для сортировки и вывода массива.
public interface ArrayMaster {
    public int[] sort(int[] array);
    public void soutArray(int[] array);
}
