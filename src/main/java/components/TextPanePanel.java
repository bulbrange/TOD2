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
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

}
