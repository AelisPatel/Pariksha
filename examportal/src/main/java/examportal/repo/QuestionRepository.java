package examportal.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import examportal.model.exam.Question;
import examportal.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question,Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
