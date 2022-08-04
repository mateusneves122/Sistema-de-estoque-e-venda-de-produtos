//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Armazenamento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yanfo
 */
public class Arquivo {
    public static String lerArquivo(String caminho) throws FileNotFoundException {
        StringBuilder conteudo = new StringBuilder();
        File arquivo = new File(caminho);
        Scanner leitor = new Scanner(arquivo);
        // varrendo o conteúdo do arquivo linha por linha
        while (leitor.hasNextLine()) {
            conteudo.append(leitor.nextLine()).append("\n");
        }

        return conteudo.toString();
    }

    public static void escreverArquivo(String caminho, String conteudo) {
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;
        try {
            File arquivo = new File(caminho);fwArquivo = new FileWriter(arquivo, false);
            bwArquivo = new BufferedWriter(fwArquivo);bwArquivo.write(conteudo + '\n');
            bwArquivo.close();
            fwArquivo.close();

        } catch (IOException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
    }
}
