package ru.project.examtest.arrays;

import ru.project.examtest.data.models.RoomBasicFormula;

public class BasicFormulasArrays {
    public static RoomBasicFormula[] array = {
            new RoomBasicFormula(
                    "=СУММ(число1; число2; ...)\n=СУММ(число1; число n)",
                    "Суммирует все числа в интервале ячеек"
            ),
            new RoomBasicFormula(
                    "=ABS(число)",
                    "Возвращает абсолютное значениие числа"
            ),
            new RoomBasicFormula(
                    "=ФАКТР(число)",
                    "Возвращает факториал числа"
            ),
            new RoomBasicFormula(
                    "=НОК(число1; число2; ...)\n=НОК(число1; число n)",
                    "Возвращает наименьшее общее кратное целых чисел"
            ),
            new RoomBasicFormula(
                    "=НОД(число1; число2; ...)\n=НОД(число1; число n)",
                    "Возвращает наибольший общий делитель двух или более целых чисел"
            ),
            new RoomBasicFormula(
                    "=КОРЕНЬ(число)",
                    "Возвращает положиельное значение квадратного корня"
            ),
            new RoomBasicFormula(
                    "=СТЕПЕНЬ(числа)",
                    "Возвращает возведение числа в степень"
            ),
            new RoomBasicFormula(
                    "=СУММЕСЛИ(диапазон, критерий, [диапазон суммирования])",
                    "Возвращает значение диапазона, соответствующие указаным условиям"
            ),
            new RoomBasicFormula(
                    "=СРЕДНЕЕ(число1, [число2], ...)",
                    "Возвращает среднее арифметическое аргументов"
            )
    };
}
