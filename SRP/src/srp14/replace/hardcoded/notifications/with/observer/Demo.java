package srp14.replace.hardcoded.notifications.with.observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class Clock {
	private int 	interval;
	private Counter counter;

	public Clock(int interval) {
		this.interval = interval;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	//region Cycler
	private Cycler cycler;
	public void setCycler(Cycler cycler) {
		this.cycler = cycler;
	}
	//endregion

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
		if (counter != null) {
			counter.advance();
			counter.showOn();
		}

		//region Cycler
		if (cycler != null) {
			cycler.advance();
			cycler.showOn();
		}
		//endregion
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

//region Cycler
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
//endregion

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

		//region Cycler
//		Cycler cycler = new Cycler(10);
//		cycler.setUI(new UI("Cycler"));
//		clock.setCycler(cycler);
		//endregion

		clock.run();
	}
	
}
