package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		long t0 = System.nanoTime();
		
		ArrayList<TextProcessor> objList = new ArrayList<>();
		TextProcessor p = new SingleWordCounter("nils");
		objList.add(p);
		TextProcessor p2 = new SingleWordCounter("norge");
		objList.add(p2);
		TextProcessor p3 = new MultiWordCounter(REGIONS);
		objList.add(p3);
		
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
		
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");

	}
}