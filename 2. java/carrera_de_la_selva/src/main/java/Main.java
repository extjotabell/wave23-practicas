import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Categories
        ArrayList<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category("Circuito chico", "2 km por selva y arroyos", true, 1300, 1500));
        categoryList.add(new Category("Circuito medio", "5 km por selva, arroyos y barro", true, 2000, 2300));
        categoryList.add(new Category("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", false, 0, 2800));

        // Enrollments
        ArrayList<Enrollment> enrollmentList = new ArrayList<>();

        enrollmentList.add(new Enrollment(123456789, "Juan", "Pérez", 25, 123456789, 987654321, "O+"));
        enrollmentList.add(new Enrollment(987654321, "María", "Gómez", 30, 987654321, 123456789, "A-"));
        enrollmentList.add(new Enrollment(555555555, "Luisa", "Martínez", 16, 555555555, 111111111, "B+"));
        enrollmentList.add(new Enrollment(777777777, "Roberto", "Fernández", 18, 777777777, 333333333, "AB-"));
        enrollmentList.add(new Enrollment(999999999, "Eva", "García", 35, 999999999, 444444444, "A+"));
        enrollmentList.add(new Enrollment(111111111, "Miguel", "Sánchez", 14, 111111111, 555555555, "O-"));
        enrollmentList.add(new Enrollment(222222222, "Sofía", "Rodríguez", 24, 222222222, 666666666, "B-"));
        enrollmentList.add(new Enrollment(333333333, "Daniel", "López", 29, 333333333, 777777777, "AB+"));
        enrollmentList.add(new Enrollment(444444444, "Olivia", "Fernández", 32, 444444444, 888888888, "A-"));
        enrollmentList.add(new Enrollment(666666666, "Jaime", "Gutiérrez", 17, 666666666, 999999999, "O+"));

        System.out.println("------------------------------\n");

        // Enrollments into categories (Random)
        for(int i = 0; i < 10; i++) {
            int random = new Random().nextInt(3);

            Category selectedCategory = categoryList.get(random);
            Enrollment currentEnrollment = enrollmentList.get(i);

            selectedCategory.enroll(currentEnrollment);
        }

        System.out.println("\n------------------------------\n");

        // Print participants in categories

        for(Category category : categoryList) {
            System.out.println(category.name + ": " + category.enrolled.size() + " inscritos: " + category.enrolled);
        }

        System.out.println("\n------------------------------\n");

        // Random unroll someone

        int randomCategory = new Random().nextInt(3);
        Category selectedCategory = categoryList.get(randomCategory);

        int randomEnrollment = new Random().nextInt(selectedCategory.enrolled.size());
        selectedCategory.unroll(randomEnrollment);

        System.out.println("\n------------------------------\n");

        // Print participants in categories again

        for(Category category : categoryList) {
            System.out.println(category.name + ": " + category.enrolled.size() + " inscritos: " + category.enrolled);
        }

        System.out.println("\n------------------------------\n");

        // Print summary
        for(Category category : categoryList) {
            System.out.println(category.name + " recaudó: $" + category.collected);
        }

        System.out.println("Recaudo total: $" + Category.totalCollected);

        System.out.println("\n------------------------------");
    }
}
