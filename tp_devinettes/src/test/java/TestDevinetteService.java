import com.mysql.cj.jdbc.ha.BestResponseTimeBalanceStrategy;
import org.cda.tp_devinettes.entity.Devinette;
import org.cda.tp_devinettes.exception.DataBaseException;
import org.cda.tp_devinettes.exception.IncompleteDataException;
import org.cda.tp_devinettes.repository.DevinetteRepository;
import org.cda.tp_devinettes.repository.ReponseRepository;
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



    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfRiddleArgumentIsNull() throws IncompleteDataException, DataBaseException {


        Devinette riddle = new Devinette().builder().answer("012345678901234566789").build();


        Assertions.assertThrowsExactly(IncompleteDataException.class, devinetteService.newRiddle(riddle) );
    }

    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfRiddleArgumentSizeIsLT15() throws IncompleteDataException, DataBaseException {
        Devinette riddle = new Devinette().builder().riddle("12345678901234").answer("test").build();
        Assertions.assertThrowsExactly(IncompleteDataException.class, devinetteService.newRiddle(riddle) );
    }

    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfRiddleArgumentSizeIsEmpty() throws IncompleteDataException, DataBaseException {
        Devinette riddle = new Devinette().builder().riddle("                                                                                                    ").answer("test").build();
        Assertions.assertThrowsExactly(IncompleteDataException.class, devinetteService.newRiddle(riddle) );
    }

    @Test
    void newRiddleShouldThrowIncompleteDataExceptionIfAnswerArgumentIsNull() throws IncompleteDataException, DataBaseException {
        Devinette riddle = new Devinette().builder().riddle("Valide riddle format").build();
        Assertions.assertThrowsExactly(IncompleteDataException.class, devinetteService.newRiddle(riddle) );
    }


//
//    @Test
//    void newRiddleShouldThrowDataBaseExceptionIfNoArgumentMissingWhenDevinetteRepositoryFail() throws DataBaseException {
//        Devinette riddle = new Devinette().builder().riddle("Valide riddle format").answer("notNull").build();
//        Mockito.when(devinetteRepository.create(riddle)).thenThrow(DataBaseException.class);
//        Assertions.assertThrowsExactly(DataBaseException.class, devinetteService.newRiddle(riddle) );
//    }
//
//    @Test
//    void newRiddleTestShouldBeTrueWhenNoArgumentMissingWhenDevinetteRepositoryFail(){
//        Devinette riddle = new Devinette().builder().riddle("valide riddle format").answer("not null").build();
//        Assertions.assertThrowsExactly(IncompleteDataException.class, devinetteService.newRiddle(riddle) );
//    }
//









}
