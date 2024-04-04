package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	private String getUserAnswer() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	public int getTotalPoints() {
		int sum = 0;
		for(Question q : questions) {
			sum += q.getPoints();
		}
		return sum;
	}
	
	public void takeQuiz() {
		int pointsEarned = 0;
		for (int i = 0; i < questions.length; i++) {
			questions[i].displayPrompt();
			String givenAnswer = getUserAnswer();
			questions[i].checkAnswer(givenAnswer);
			System.out.println("Points earned for this question: " + questions[i].checkAnswer(givenAnswer));
			pointsEarned = pointsEarned + questions[i].checkAnswer(givenAnswer);
		}
		System.out.println("Total points earned: " + pointsEarned);
		System.out.println("Total number of points available: " + getTotalPoints());
	}
	
	public static void main(String[] args) {
		Question q = new Question("What number studio is this?", "8", 2);

		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);

		choices = new String[] {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);
		
		choices = new String[] {"Selena Gomez", "Ronaldo", "Messi", "Kim Kardashian"};
		Question instaChoice = new MultipleChoiceQuestion("Who is the most followed person on Instagram?", "2", 1, choices);
	
		Question[] questions = {q, multipleChoice, selectAll, instaChoice};
		
		Quiz studio8quiz = new Quiz(questions);
		studio8quiz.takeQuiz();
	}
}
