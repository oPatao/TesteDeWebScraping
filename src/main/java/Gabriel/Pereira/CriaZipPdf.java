package Gabriel.Pereira;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CriaZipPdf {
    static final int TAMANHO_BUFFER = 1024;

    public static void main(String[] args) {

        String arquivoPdf1 = "Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf";
        String arquivoPdf2 = "Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf";

        String nomeArquivoZip = "Anexos.zip";

        try (FileOutputStream fos = new FileOutputStream(nomeArquivoZip);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            addArquivoPZip(zos, arquivoPdf1);
            addArquivoPZip(zos, arquivoPdf2);

            System.out.println("Arquivos compactados com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao compactar arquivos: " + e.getMessage());
        }
    }

    private static void addArquivoPZip(ZipOutputStream zos, String caminhoArquivo) throws IOException {
        Path caminhoPath = Paths.get(caminhoArquivo);

        try (FileInputStream fis = new FileInputStream(caminhoArquivo)) {


            ZipEntry zipEntry = new ZipEntry(caminhoPath.getFileName().toString());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[TAMANHO_BUFFER];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();

        } catch (IOException e) {
            System.err.println("Erro ao adicionar arquivo ao ZIP: " + e.getMessage());
            throw e;
        }
    }
}