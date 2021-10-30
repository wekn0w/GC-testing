Программа, демонстрирующую работу GC с целью оценить два разных коллектора G1 и Parallel GC по критериям: общая скорость и среднее время работы.

Класс G1 отвечает за G1 gc, на рисунке 2 изображена его работа в visualvm.
Класс ParallelGC - за Parallel gc. На рисунке 4 изображена его работа в visualvm.

По критерию время работы ParallelGc больше G1Gc, 6.15 против 5.42 (больше лучше).

По притерию скорость смотрим на использование CPU(меньше - лучше, gc выполняет свою работу тратя меньше ресурсов -> программа работает быстрее). У ParallelGc 5.4% против 6.8% у G1.

По тестовым результатам для программы больше подходит ParallelGc. (Хотя в среднем тестовые результаты будут получаться разные и средние значения критериев почти одинаковые)