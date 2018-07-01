package collections.parenthesis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesisCheckerTest {

    @Test
    @DisplayName("Check for null")
    void checkForNull() {
        System.out.print("\nCheck for null: ");
        ParenthesisChecker pc = new ParenthesisChecker(null);
        assertFalse(pc.checkParenthesis(), "true!");
        System.out.println("false");
    }

    @Test
    @DisplayName("Check for empty string")
    void checkForEmptyString() {
        System.out.print("\nCheck for empty string: ");
        ParenthesisChecker pc = new ParenthesisChecker(null);
        assertFalse(pc.checkParenthesis(), "false!");
        System.out.println("true");
    }

    @ParameterizedTest
    @DisplayName("Check fo different kind of strings: 'false' cases (parameterized test)")
    @CsvSource(value = {"(asd", "{asd", "[asd", ")asd", "}asd", "]asd", "(asd])", "(sad[]asd))", "ad{{sad}asd", "sdf[sdf{sdf]", "sdf] fs[", "sdf)sdf(", "{}(]{SF}[P}"})
    void checkParenthesisFalseCases(String checkingString) {
        assertFalse(new ParenthesisChecker(checkingString).checkParenthesis());
    }

    @ParameterizedTest
    @DisplayName("Check fo different kind of strings: 'true' cases (parameterized test)")
    @CsvSource(value = {"()", "{}", "[]", "a", "aaaa", "(asd)", "{asd}", "[ada]", "(asd[asd]Asd)", "[aad]adasd{asd}asda(asd)", "[aad]adasd[{asd}asda(asd)]", "(gh{j[aad]adasd{asd}a}sda(asd)hgj)ghj" })
    void checkParenthesisTrueCases(String checkingString) {
        assertTrue(new ParenthesisChecker(checkingString).checkParenthesis());
    }
}