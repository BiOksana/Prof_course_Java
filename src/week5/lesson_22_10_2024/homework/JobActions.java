package week5.lesson_22_10_2024.homework;

public interface JobActions {
    void doTask(Task task);
    void haveRest();
     class Task {
        private String name;
        private String description;

         public Task(String name, String description) {
             this.name = name;
             this.description = description;
         }
         @Override
         public String toString() {
             return "Task{" +
                     "name='" + name + '\'' +
                     ", description='" + description + '\'' +
                     '}';
         }
         public String getName() {
             return name;
         }
         public String getDescription() {
             return description;
         }

     }

}
