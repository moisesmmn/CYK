package gerenciadorArquivos;

import cyk.CYKGramatica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GerenciadorArquivos {
    public static CYKGramatica readFromFile(String filePath) throws IOException{

        String path = "inputs/" + filePath;

        HashMap<String, ArrayList<String>> gramatica = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        while (line != null) {
            String[] P = line.split(" -> "); //[0] contains the variable and [1] the production: "S -> AB"
            if (gramatica.containsKey(P[0]))
            gramatica.get(P[0]).add(String.join("", (CharSequence[]) P[1].split(" ")));
            else
            gramatica.put(P[0], new ArrayList<>(Collections.singletonList(String.join("", (CharSequence[]) P[1].split(" ")))));

            line = br.readLine();
        }
        
        br.close();
        return new CYKGramatica(gramatica);
    }
}
