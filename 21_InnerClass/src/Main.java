public class Main {
    public static void main(String[] args) {
        University uni = new University("MIT");
        University.Department cs = uni.new Department("Computer Science");
    }
}


class University {
    private String name;

    public University(String name) {
        this.name = name;
    }

    class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayInfo() {
            System.out.println(deptName + " department of " + name);
        }
    }
}

