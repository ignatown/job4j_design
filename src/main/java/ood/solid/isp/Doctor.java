package ood.solid.isp;

public interface Doctor {
    String prescribeTreatment();
    void examineThePatient();
    void prescribeAPrescriptionDrug();
    // Пример 2
    // Не все доктора могут назначать лечение или выписывать рецептурные лекарства.
}
