import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {
    Product item1 = new Product(5, "хлеб", 40);
    Product item2 = new Product(17, "картошка", 30);
    Product item3 = new Product(2, "булка", 20);
    Product item4 = new Product(1, "молоко", 45);

    @Test
    public void ShouldRemoveOneProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.remove(5);

        Assertions.assertEquals(2, repo.findAll().length);
    }

    @Test
    public void ShouldThrowException() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-100);
        });
    }

    @Test
    public void ShouldAddOneProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);

        Assertions.assertEquals(2, repo.findAll().length);
    }

    @Test
    public void ShouldThrowAlreadyExistsException() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item2);
        });
    }
}
