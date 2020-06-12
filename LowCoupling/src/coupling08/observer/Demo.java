package coupling08.observer;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Clock {
	private int interval;
	
	public Clock(int interval) {
		this.interval = interval;
	}
	
	private Counter counter;	
	public void setCounter(Counter counter) {
		this.counter = counter;
	}
	
	// region Cycler
//	private Cycler cycler;
//	public void setCycler(Cycler cycler) {
//		this.cycler = cycler;
//	}
	// endRegion
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
				tick();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void tick() {
		counter.advance();
		counter.showOn();
		// region Cycler
//		cycler.advance();
//		cycler.showOn();
		// endRegion
	}
}

class Counter {
	
	private int value;
	private UI ui = null;
	
	public Counter() {
		value = 0;
	}
	
	public void advance() {
		++value;
	}

	public void setUI(UI ui) {
		this.ui = ui;
		ui.setVisible(true);
	}
	
	public void showOn() {
		if (ui != null)
			ui.display(String.valueOf(value));
		else
			System.out.println("value = " + value);
			
	}
}

// region Cycler
class Cycler {
	
	private int value;
	private int base;
	private UI ui = null;
	
	public Cycler(int base) {
		value = 0;
		this.base = base;
	}
	
	public void advance() {
		value = ++value % base;
	}

	public void setUI(UI ui) {
		this.ui = ui;
		ui.setVisible(true);
	}
	
	public void showOn() {
		if (ui != null)
			ui.display(String.valueOf(value));
		else
			System.out.println("value = " + value);
			
	}
}
// endRegion

@SuppressWarnings("serial")
class UI extends JFrame {
	private String title;
	private JPanel contentPane;
	private JTextField text;
	
	UI(String title) {
		this.title = title;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 150, 80);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		text = new JTextField(10);
		contentPane.add("West", new JLabel(title + ": "));
		contentPane.add("Center", text);
		setVisible(true);
	}
	
	public void display(String value) {
		text.setText(value);
	}
}

public class Demo {

	public static void main(String[] args) {
		
		Clock clock = new Clock(1000);
		
		Counter counter = new Counter();
		counter.setUI(new UI("Counter"));
		clock.setCounter(counter);
		
		// region Cycler
//		Cycler cycler = new Cycler(10);
//		cycler.setUI(new UI("Cycler"));
//		clock.setCycler(cycler);
		// endRegion
		
		clock.run();
	}
	
}
