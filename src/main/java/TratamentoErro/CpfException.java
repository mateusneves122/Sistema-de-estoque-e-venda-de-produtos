/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
