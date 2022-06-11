package examportal.service;

import java.util.Set;

import examportal.model.exam.Question;
import examportal.model.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionsofQuiz(Quiz quiz);
	
	public void deleteQuestion(Long quesId);
	
	public Question get(Long questionsId);
}
