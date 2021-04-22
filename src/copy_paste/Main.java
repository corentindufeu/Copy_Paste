package copy_paste;

import java.io.IOException;
import java.nio.file.FileSystemException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Copy_paste file = new Copy_paste();
		String urlCopy = "C:\\Users\\coren\\Documents\\Campus_Academy\\Réseau\\configurer un pc sur rooter";
		String urlPaste = "C:\\Users\\coren\\Documents\\Campus_Academy\\Réseau";
		
		try {
			file.addFolder(urlCopy, urlPaste);
		} catch (FileSystemException f) {
			System.out.println("Une erreur c'est produite !\n" + f);
		}
	}
}