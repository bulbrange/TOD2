package components;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.text.StyleConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;

public class TextPanePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	public static JTextPane area;
	private JScrollPane scroll;
	public static final Font DEFAULT_FONT = new Font("Arial",Font.PLAIN, 16);

	private String lorem = "Lorem ipsum dolor sit amet, ex labitur definitiones has, vim et habeo virtute imperdiet."
			+ " At equidem civibus persequeris vix, eu vim dolore splendide, modo omnium qui in. Et nullam "
			+ "expetenda his, usu odio audire maluisset ne. Tota modus at ius."
			+ "Te vitae semper appareat cum. No vel duis eligendi persecuti, quando soleat rationibus "
			+ "in ius. Iusto consetetur delicatissimi ex mel, ad vel case eloquentiam. Pro cu dolorem"
			+ " recusabo aliquando. Id odio homero mea, sea cu scripserit deterruisset. At sit agam denique, "
			+ "in sea impetus appareat. Vis ex deseruisse assueverit interpretaris, falli munere similique "
			+ "at est. Vel omittam necessitatibus id, te duo delenit splendide disputando. Vix aliquando "
			+ "gloriatur ei, eum ut diceret propriae dignissim, an sea legendos mediocritatem. Per mutat "
			+ "nostro tractatos te, lorem inciderint vim cu. Te dico molestiae his, id duo velit ceteros. "
			+ "Quando putant persequeris per ea, viris propriae signiferumque ea eam. Ea vix dolorum scriptorem."
			+ "Nec primis corpora an. Quando patrioque persequeris eu usu, his te esse voluptaria. Nullam accumsan "
			+ "recteque usu ex. Vix cu vidisse accumsan maluisset, veniam appareat sit eu. Illum vivendum ei est, "
			+ "quas delicata adolescens qui ei, natum copiosae vim at. "
			+ "Ex quo dignissim suscipiantur, an nam aperiam placerat, nec cu laoreet copiosae scripserit. "
			+ "Cu nonumy patrioque sed, mea ut quis atqui, tantas deterruisset no mea. Senserit indoctum "
			+ "inciderint ea sit, mel eu purto ignota pertinacia. Sed an nibh summo.";
	
	public TextPanePanel(){
		setLayout(new BorderLayout());
		area = new JTextPane();
		area.setFont(DEFAULT_FONT);
		area.setMargin(new Insets(20,20,20,20));
		
		SimpleAttributeSet sa = new SimpleAttributeSet();
		StyleConstants.setAlignment(sa, StyleConstants.ALIGN_JUSTIFIED);

		area.getStyledDocument().setParagraphAttributes(0, 0, sa, false);
		scroll = new JScrollPane(area);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll,BorderLayout.CENTER);
		area.setText(lorem);
	}

}
