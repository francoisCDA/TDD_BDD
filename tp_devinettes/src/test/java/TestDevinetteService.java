import com.mysql.cj.jdbc.ha.BestResponseTimeBalanceStrategy;
import org.cda.tp_devinettes.entity.Devinette;
import org.cda.tp_devinettes.entity.Reponse;
import org.cda.tp_devinettes.exception.DataBaseException;
import org.cda.tp_devinettes.exception.IncompleteDataException;
import org.cda.tp_devinettes.repository.DevinetteRepository;
import org.cda.tp_devinettes.repository.ReponseRepository;
import org.cda.tp_devinettes.repository.Repository;
import org.cda.tp_devinettes.service.DevinetteService;
import org.cda.tp_devinettes.util.HibernateSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestDevinetteService {


    @Mock
    private DevinetteRepository devinetteRepository;

    @Mock
    private ReponseRepository reponseRepository;

    private DevinetteService devinetteService;

    @BeforeEach
    void setUp(){
        devinetteService = new DevinetteService(HibernateSession.getHibernateSession(), new ReponseRepository(), new DevinetteRepository() );
    }

    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfRiddleArgumentIsNull() throws IncompleteDataException, DataBaseException {
        Devinette riddle = new Devinette().builder().answer("012345678901234566789").build();
        Assertions.assertThrowsExactly(IncompleteDataException.class, () -> devinetteService.newRiddle(riddle) );
    }

    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfRiddleArgumentSizeIsLT15() throws IncompleteDataException, DataBaseException {
        Devinette riddle = new Devinette().builder().riddle("12345678901234").answer("test").build();
        Assertions.assertThrowsExactly(IncompleteDataException.class, () -> devinetteService.newRiddle(riddle) );
    }

    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfRiddleArgumentSizeIsEmpty() throws IncompleteDataException, DataBaseException {
        Devinette riddle = new Devinette().builder().riddle("                                                                                                    ").answer("test").build();
        Assertions.assertThrowsExactly(IncompleteDataException.class, () -> devinetteService.newRiddle(riddle) );
    }

    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfAnswerArgumentIsNull() throws IncompleteDataException, DataBaseException {
        Devinette riddle = new Devinette().builder().riddle("Valide riddle format").build();
        Assertions.assertThrowsExactly(IncompleteDataException.class, () -> devinetteService.newRiddle(riddle) );
    }

    @Test
    void newRiddleShouldThrowDataBaseExceptionIfNoArgumentMissingWhenDevinetteRepositoryFail() throws DataBaseException {
        Devinette riddle = new Devinette().builder().riddle("Valide riddle format").answer("notNull").build();
        Mockito.when(devinetteRepository.create(riddle)).thenThrow(DataBaseException.class);
        DevinetteService devServ = new DevinetteService(HibernateSession.getHibernateSession(), new ReponseRepository(), devinetteRepository );

        Assertions.assertThrowsExactly(DataBaseException.class, () -> devServ.newRiddle(riddle) );
    }

    @Test
    void newRiddleTestShouldBeTrueWhenNoArgumentMissingAndDevinetteRepositorySuccces() throws DataBaseException, IncompleteDataException {
        Devinette riddle = new Devinette().builder().riddle("valide riddle format").answer("not null").build();
        Mockito.when(devinetteRepository.create(riddle)).thenReturn(true);
        DevinetteService devServ = new DevinetteService(HibernateSession.getHibernateSession(), new ReponseRepository(), devinetteRepository );

        Assertions.assertEquals(true,devServ.newRiddle(riddle));
    }

    @Test
    void getResultShouldReturnTrueWhenUserGuessAnswer(){
        Devinette riddle = new Devinette().builder().id(2).riddle("quelle est la bonne réponse").answer("la bonne réponse").build();
        Reponse userAnswer = new Reponse().builder().devinette(riddle).userAnswer("la bonne réponse").build();

        Assertions.assertEquals(true, devinetteService.userTry(userAnswer));

    }

    @Test
    void getResultShouldReturnFalseWhenUserDoenstGuessAnswer(){
        Devinette riddle = new Devinette().builder().id(2).riddle("quelle est la bonne réponse").answer("la bonne réponse").build();
        Reponse userAnswer = new Reponse().builder().devinette(riddle).userAnswer("autre réponse").build();

        Assertions.assertEquals(false, devinetteService.userTry(userAnswer));

    }

    @Test
    void getResultShouldReturnTrueWhenUserGuessAnswerCaseIgnored(){
        Devinette riddle = new Devinette().builder().id(2).riddle("quelle est la bonne réponse").answer("la bonne reponse").build();
        Reponse userAnswer = new Reponse().builder().devinette(riddle).userAnswer("LA BONNE REPONSE").build();

        Assertions.assertEquals(true, devinetteService.userTry(userAnswer));
    }


    @Test
    void getAnswersByRiddleIdCantReturnNull() {
        int riddleId = 2;
        Mockito.when(reponseRepository.getAnswersByRiddleId(riddleId)).thenReturn(null);
        devinetteRepository = new DevinetteRepository();

        DevinetteService devServ = new DevinetteService(HibernateSession.getHibernateSession(),reponseRepository, devinetteRepository );

        Assertions.assertNotEquals(null,devServ.getAnswersByRiddleId(2));

    }




}
