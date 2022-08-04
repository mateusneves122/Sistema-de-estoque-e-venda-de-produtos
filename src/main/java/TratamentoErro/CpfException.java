//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package TratamentoErro;

/**
 *
 * @author yanfo
 */
public class CpfException extends RuntimeException {

    public CpfException(String message) {
        super(message);
    }

    public CpfException(Throwable cause) {
        super(cause);
    }
}
