package copy_paste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Copy_paste {
	
	public void addFolder(String urlSource, String urlDestination) throws IOException {
		
		File sourceFolder = new File(urlSource);
		File[] folderContent = sourceFolder.listFiles();
		
		/*List all folders in parent folder*/
		if (folderContent == null) {
			System.exit(0);
		}
		for (File fileMenuSource : folderContent) {
			
			/*Take path of the next file or folder, decompose it and recovers the name*/
            String[] decomposedUrlFolder = fileMenuSource.getAbsolutePath().split("\\\\");
            String nameNextFolder = decomposedUrlFolder[decomposedUrlFolder.length-1];
            File newFileSource = new File(urlSource + "\\" + nameNextFolder);
            File menuDestination = new File(urlDestination + "\\" + nameNextFolder);
            
            /*If that's a folder*/
            if(fileMenuSource.isDirectory()) {
            	
            	/*Recreate folder*/
            	if(!menuDestination.exists()) {
	                menuDestination.mkdir();
	                System.out.println("Creation of : " + menuDestination);
            	}
                /*Enter in the folder*/
                String newUrlDestination = urlDestination + "//" + nameNextFolder;
                String newUrlSource = urlSource + "//" + nameNextFolder;
    			this.addFolder(newUrlDestination, newUrlSource);
    			
    		/*if that's a file recreate it if not exist*/
            } else if(!menuDestination.exists()) {
        		Files.copy(newFileSource.toPath(), menuDestination.toPath());
        		System.out.println("	Creation of : " + menuDestination);
        	}
        }
	}
}
