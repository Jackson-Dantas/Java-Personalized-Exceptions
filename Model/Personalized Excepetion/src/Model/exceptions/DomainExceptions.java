package Model.exceptions;

//A personalized Exception can extend Exception Class or RunTimeException Class
//RuntimeException class don't need to be implemented in our program, because will be tested in execution time
public class DomainExceptions extends Exception {
    public DomainExceptions(String message){
        super(message);
    }
}
