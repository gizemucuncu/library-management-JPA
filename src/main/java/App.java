import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("TEST");
    }
}
