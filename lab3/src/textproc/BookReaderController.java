package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.Position;

public class BookReaderController {

	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}

	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();

		// // pane är en behållarkomponent till vilken de övriga komponenterna
		// (listvy, knappar etc.) ska läggas till.
		JButton aButton = new JButton("Alphabetic");
		JButton fButton = new JButton("Frequency");
		JButton sButton = new JButton("Search");
		JTextField sBar = new JTextField(20);  // sökfält

		JPanel panel = new JPanel();
		panel.add(aButton);
		panel.add(fButton);
		panel.add(sBar);
		panel.add(sButton);
		
		

		pane.add(panel, BorderLayout.SOUTH);
		
		
		List<Map.Entry<String, Integer>> wordList = counter.getWordList();
		wordList.removeIf(entry -> Character.isDigit(entry.getKey().charAt(0))); // filtrerar bort siffror
		
		SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel<>((wordList));
		

		JList<Map.Entry<String, Integer>> list = new JList<>(model);

		JScrollPane scrollPane = new JScrollPane(list);
		pane.add(scrollPane, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

		Comparator<Map.Entry<String, Integer>> fComparator = (entry1, entry2) -> {
			return entry2.getValue().compareTo(entry1.getValue());
		};

		fButton.addActionListener(e -> {
			model.sort(fComparator);
		});

		Comparator<Map.Entry<String, Integer>> aComparator = (entry1, entry2) -> {
			return entry1.getKey().compareTo(entry2.getKey());
		};

		aButton.addActionListener(e -> {
			model.sort(aComparator);
		});
		
		
		sButton.addActionListener(e -> {
		    String query = sBar.getText();  // hämta sökning
		    int index = -1; 				// -1 = inte hittad
		    
		    index = list.getNextMatch(query, 0, Position.Bias.Forward);

		    
//		    for (int i = 0; i < list.getModel().getSize(); i++) {
//		    	if (query.equals(list.getModel().getElementAt(i).toString())) {
//		    		index = i;
//		    		break;
//		    	}
//		    }
		    
		    if (index != -1) {
		    	list.setSelectedIndex(index);
		    	list.ensureIndexIsVisible(index);
		    }
		    
		});


	}
}
