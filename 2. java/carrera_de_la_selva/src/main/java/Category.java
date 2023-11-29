import java.util.ArrayList;
import java.util.List;

public class Category {
    // Class attributes
    static int idCounter; // Auto increment id
    static int totalCollected;

    // Instance attributes
    public int id;
    public String name;
    public String description;
    public boolean minorsAllowed;
    public int minorsPrice;
    public int adultsPrice;
    public int collected;
    public List<Enrollment> enrolled;

    // Constructor
    public Category(String name, String description, boolean minorsAllowed, int minorsPrice, int adultsPrice) {
        this.id = ++idCounter;
        this.name = name;
        this.description = description;
        this.minorsAllowed = minorsAllowed;
        this.minorsPrice = minorsPrice;
        this.adultsPrice = adultsPrice;
        this.collected = 0;
        this.enrolled = new ArrayList<>();
    }

    // Methods
    public void enroll(Enrollment enrollment) {
        String enrollmentName = enrollment.getFullName();

        if(enrollment.age < 18) {
            if (!this.minorsAllowed) {
                System.out.println(enrollmentName + ": No es posible inscribirlo a la categoría " + this.name);
            } else {
                System.out.println(enrollmentName + ": Inscrito a la categoría " + this.name + ". Pagó $" + this.minorsPrice);
                this.collected += this.minorsPrice;
                totalCollected += this.minorsPrice;
                this.enrolled.add(enrollment);
            }
        } else {
            System.out.println(enrollmentName + ": Inscrito a la categoría " + this.name + ". Pagó $" + this.adultsPrice);
            this.collected += this.adultsPrice;
            totalCollected += this.adultsPrice;
            this.enrolled.add(enrollment);
        }
    }

    public void unroll(int index) {
        try {
            Enrollment enrollment = this.enrolled.get(index);

            if (enrollment.age < 18) {
                this.collected -= this.minorsPrice;
                totalCollected -= this.minorsPrice;
            } else {
                this.collected -= this.adultsPrice;
                totalCollected -= this.adultsPrice;
            }

            this.enrolled.remove(index);

            System.out.println(enrollment.getFullName() + " desinscrito de la categoría " + this.name);
        } catch (Exception e) {
            System.out.println("Este participante no está inscrito en esta categoría");
        }
    }
}
