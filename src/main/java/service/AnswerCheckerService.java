package service;

import dao.WordDaoImpl;
import models.Question;

public class AnswerCheckerService {
    public boolean checkAnswer(Question currentQuestion, String answer) {
        WordDaoImpl wordDao = new WordDaoImpl();
        boolean isCorrect = answer.equals(currentQuestion.getCorrectAnswer());
        wordDao.updateProgress(isCorrect, currentQuestion.getWord());
        return isCorrect;
    }
}
