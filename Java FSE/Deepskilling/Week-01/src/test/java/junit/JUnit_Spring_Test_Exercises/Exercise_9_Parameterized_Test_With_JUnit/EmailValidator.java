package junit.JUnit_Spring_Test_Exercises.Exercise_9_Parameterized_Test_With_JUnit;

class EmailValidator {

    public boolean isValid(String email) {
        return email != null
                && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
