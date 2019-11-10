package service;

import dao.WordDaoImpl;
import models.Question;

public class AnswerCheckerService {
    public void checkAnswer(Question currentQuestion, String answer) {
        WordDaoImpl wordDao = new WordDaoImpl();
        wordDao.updateProgress(answer.equals(currentQuestion.getCorrectAnswer()), currentQuestion.);
    }
}
