import entity.LivreDomaine;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.LivreService;
import spi.port.LivreRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookDeleteFeatureAuto {

    private LivreService livreService;

    private LivreDomaine livreUn;
    private LivreDomaine livreDeux;
    private LivreDomaine livreTrois;

    private List<LivreDomaine> livreList;

    private final LivreRepository livreRepository;

    public BookDeleteFeatureAuto() {
        this.livreRepository = Mockito.mock(LivreRepository.class);
        livreService = new LivreService(livreRepository);

        livreUn = new LivreDomaine();
        livreUn.setTitre("toto") ;
        livreUn.setIsbn("5zfzfzef-666-854");

        livreDeux = new LivreDomaine();
        livreDeux.setTitre("taotao") ;
        livreTrois.setIsbn("5zzdffzef-689-854");

        livreTrois = new LivreDomaine();
        livreTrois.setTitre("toumtoum") ;
        livreTrois.setIsbn("Azdzdfzef-666-854");

    }

    @lombok.SneakyThrows
    @Given("there are three books with id {int} {int} {int}")
    public void thereAreThreeBooksWithId(int id0, int id1, int id2) {

        Mockito.doAnswer(invocationOnMock -> {
            LivreDomaine b = invocationOnMock.getArgument(0);
            b.setId(id0);
            return null;
        }).when(livreRepository).create(livreUn);

        livreService.createLivre("toto", "5zfzfzef-666-854");

        Mockito.doAnswer(invocationOnMock -> {
            LivreDomaine b = invocationOnMock.getArgument(0);
            b.setId(id1);
            return null;
        }).when(livreRepository).create(livreUn);

        livreService.createLivre("taotao", "5zzdffzef-689-854");

        Mockito.doAnswer(invocationOnMock -> {
            LivreDomaine b = invocationOnMock.getArgument(0);
            b.setId(id2);
            return null;
        }).when(livreRepository).create(livreUn);

        livreService.createLivre("toumtoum", "Azdzdfzef-666-854");


    }

    @When("I want to remove book with ID {int}")
    public void iWantToRemoveBookWithID(int arg0) {


    }

    @Then("the book list size should be {int}")
    public void theBookListSizeShouldBe(int arg0) {
    }
}
