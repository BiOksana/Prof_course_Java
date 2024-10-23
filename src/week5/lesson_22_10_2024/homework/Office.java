package week5.lesson_22_10_2024.homework;

public class Office {
    // Реализовать модель действий работников в офисе:
//Создать интерфейс JobActions
//public interface JobActions {
//void doTask(Task task);
//void haveRest();
//}
//
//В интерфейс JobActions поместить класс Task с описанием задач
//class Task {
//private String name;
//private String description;
//}
//В классе Office в main() методе
//
//создать несколько задач Task
//
//через анонимные классы имплементирующие JobActions создать несколько работников:
//manager - сообщает название заданий, пьет кофе по время отдыха
//worker - делает задания, курит по время отдыха
//lazyWorker - все время бездействует
//передать задачи работникам и проверить работу методов классов
    public static void main(String[] args) {
        JobActions.Task task1 = new JobActions.Task("Task1", "description task1");
        JobActions.Task task2 = new JobActions.Task("Task2", "description task2");
        JobActions manager = new JobActions() {
            @Override
            public void doTask(Task task) {
                System.out.println("Workers must execute the " + task);
            }

            @Override
            public void haveRest() {
                System.out.println("I drink coffee during the break");
            }
        };
        JobActions worker = new JobActions() {
            @Override
            public void doTask(Task task) {
                System.out.println("I execute " + task);
            }

            @Override
            public void haveRest() {
                System.out.println("I smoke during the break");
            }
        };
        JobActions lazyWorker = new JobActions() {
            @Override
            public void doTask(Task task) {
                System.out.println("I pretend to execute the " + task);
                haveRest();
            }

            @Override
            public void haveRest() {
                System.out.println("I need to rest");
            }
        };
        manager.doTask(task2);
        worker.doTask(task2);
        manager.doTask(task1);
        manager.haveRest();
        lazyWorker.doTask(task1);
        worker.haveRest();
        lazyWorker.haveRest();
    }
}
