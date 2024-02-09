import com.yourcompany.expenseapp.application.ports.output.ExpensePersistencePort;
import com.yourcompany.expenseapp.domain.model.Expense;
import com.yourcompany.expenseapp.domain.repository.ExpenseRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RunCucumberTest {

    private final ExpensePersistencePort expensePersistencePort;
    private ExpenseRepository expenseRepository;
    private Expense expense;
    private List<Expense> expenseList;


    public RunCucumberTest() {
        expensePersistencePort = Mockito.mock(ExpensePersistencePort.class);
        expenseRepository = new ExpenseRepository(expensePersistencePort);
    }

    @Given("there are three expenses in the database")
    public void thereAreThreeExpensesInTheDatabase() {
        expense = new Expense("achat",-15);
        Mockito.when(expensePersistencePort.save(expense)).thenReturn(null);

        expenseRepository.create("achat", Double.valueOf(-15));
        expenseRepository.create("achat", Double.valueOf(-20));
        expenseRepository.create("achat", (double) -15);

    }





    @When("I want to consult all the expenses")
    public void iWantToConsultAllTheExpenses() {
    }

    @Then("list with {int} expenses should be returned")
    public void listWithExpensesShouldBeReturned(int arg0) {
    }

    @When("I create a new expense with title {string} and amount {int}")
    public void iCreateANewExpenseWithTitleAndAmount(String arg0, int arg1) {
    }
}
