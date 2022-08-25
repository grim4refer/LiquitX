package org.liquidx.client;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {
    public Unzip() {
    }

    public static void unZipIt(String zipFile, String outputFolder, boolean deleteAfter) {
        byte[] buffer = new byte[1024];

        try {
            File folder = new File(outputFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }

            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));

            for(ZipEntry ze = zis.getNextEntry(); ze != null; ze = zis.getNextEntry()) {
                String fileName = ze.getName();
                File newFile = new File(outputFolder + File.separator + fileName);
                System.out.println("file unzip : " + newFile.getAbsoluteFile());
             //   Client.instance.drawSmoothLoading(100, "Unzipping Cache: " + newFile.getAbsoluteFile());
                (new File(newFile.getParent())).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();
            }

            zis.closeEntry();
            zis.close();
            if (deleteAfter) {
                (new File(zipFile)).delete();
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }

    }
}
