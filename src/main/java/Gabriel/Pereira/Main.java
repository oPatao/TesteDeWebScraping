package Gabriel.Pereira;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class Main {

    public static void main(String[] args) throws IOException {

        String Link1 = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf",
                nomeArquivo1 = "Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf",
                Link2 = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf",
                nomeArquivo2 = "Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf";

        downloadArquivo(Link1,nomeArquivo1);
        downloadArquivo(Link2,nomeArquivo2);


    }



    public static void downloadArquivo(String link, String nomeArquivo) throws IOException {

        BufferedInputStream LINK = new BufferedInputStream(new URL(link).openStream());

        try (BufferedInputStream in = new BufferedInputStream(new URL(link).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(nomeArquivo)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
        }
        InputStream in_ = new URL(link).openStream();
        Files.copy(in_, Paths.get(nomeArquivo), StandardCopyOption.REPLACE_EXISTING);

    }






}

