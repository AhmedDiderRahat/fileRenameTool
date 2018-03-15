package com.adrahat.fileRename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD-Rahat
 */
public class FileRename {

    public int ind;
    public String oldFolder, newfile, outputfolder;

    public FileRename(String folderName, String newFile, int indx, String outputFolder) {
        oldFolder = folderName;
        ind = indx;
        newfile = newFile;
        outputfolder = outputFolder;

        renameMethod();
    }

    public void renameMethod() {

        ArrayList<String> arr = new ArrayList<>();

        final File folder = new File(oldFolder);

        for (final File fileEntry : folder.listFiles()) {
            String oldName = fileEntry.getName();
            arr.add(oldName);
        }

        for (int i = 0; i < arr.size(); i++) {
            java.io.FileWriter out = null;
            try {
                //System.out.println(arr.get(i));
                File oldFileName = new File(arr.get(i));
                File newFileName = new File(".\\" + outputfolder +  "\\" + newfile + "" + ind + ".txt");
                ind++;
                oldFileName.renameTo(newFileName);
                out = new java.io.FileWriter(newFileName, true /*append=yes*/);
            } catch (IOException ex) {
                Logger.getLogger(FileRename.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileRename.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
