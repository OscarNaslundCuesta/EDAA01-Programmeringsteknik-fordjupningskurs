package textproc;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;


public class BookReaderApplication {

	public static void main(String[] args) throws FileNotFoundException {
						
			ArrayList<TextProcessor> objList = new ArrayList<>();
//			TextProcessor p = new SingleWordCounter("nils");
//			objList.add(p);
//			TextProcessor p2 = new SingleWordCounter("norge");
//			objList.add(p2);
//			TextProcessor p3 = new MultiWordCounter(REGIONS);
//			objList.add(p3);
//			
			Set<String> stopwords = new HashSet<>();
			Scanner scan = new Scanner(new File("undantagsord.txt"));
			scan.findWithinHorizon("\uFEFF", 1);
			scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
	
			while (scan.hasNext()) {
				String undOrd = scan.next().toLowerCase();
				stopwords.add(undOrd);
			}
				
			TextProcessor r = new GeneralWordCounter(stopwords);
			objList.add(r);
	
			for (TextProcessor obj : objList) {
				
				Scanner s = new Scanner(new File("nilsholg.txt"));
				s.findWithinHorizon("\uFEFF", 1);
				s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
	
				while (s.hasNext()) {
					String word = s.next().toLowerCase();
	
					obj.process(word);
				}
				obj.report();
				s.close();
			}
			
			BookReaderController controller = new BookReaderController((GeneralWordCounter) r);

			

	}
}
