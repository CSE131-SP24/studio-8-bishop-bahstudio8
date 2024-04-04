package studio8;

public class MultipleChoiceQuestion extends Question {
	private String prompt;
	private String answer;
	private int points;
	private String[] choices;
	
	public MultipleChoiceQuestion(String prompt, String answer, int points, String[] choices) {
		super(prompt, answer, points);
		this.choices = choices;
	}
	
	
	public void displayPrompt() {
		super.displayPrompt();
		for (int i = 0; i < choices.length; i++) {
			System.out.println((i + 1) + ". " + choices[i]);
	
		}
	}
	
	public static void main(String[] args) {
		String[] studiochoices = {"seven", "nine", "eight", "six"};
		Question studioChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, studiochoices);
		studioChoice.displayPrompt();
		System.out.println(studioChoice.checkAnswer("hi"));//wrong
		System.out.println(studioChoice.checkAnswer("1"));//wrong
		System.out.println(studioChoice.checkAnswer("3"));//right
		
		String[] weekchoice = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		Question weekChoice = new MultipleChoiceQuestion("What day of the week is it?", "Thursday", 2, weekchoice);
		weekChoice.displayPrompt();
		System.out.println(weekChoice.checkAnswer("Monday")); //wrong
		System.out.println(weekChoice.checkAnswer("Thursday")); //right
		}
	}

