package cool.chinalanguagegame.android.bean;

import cn.bmob.v3.BmobObject;

//小学诗词
public class PrimaryPoetry extends BmobObject {

    private String question;
    private String answer;
    private String note;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public InputGameBean getInputGameBean() {
        InputGameBean inputGameBean = new InputGameBean();
        inputGameBean.setAnswer(answer);
        inputGameBean.setQuestion(question);
        inputGameBean.setNote(note);
        return inputGameBean;
    }

    @Override
    public String toString() {
        return "PrimaryPoetry{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
