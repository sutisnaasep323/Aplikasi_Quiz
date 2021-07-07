package com.example.aplikasiquiz;

public class QuestionBank {

    private String textQuestion[] = {
                "1. Apa warna bendera Indonesia?",
                "2. Siapa presiden pertama indonesia?",
                "3. Siapa presiden indonesia saat ini?",
                "4. tahun berapa indonesia merdeka"
    };

    private String multipleChoice[][] = {
            {"merah - putih", "putih - merah", "kuning", "hijau"},
            {"Soeharto", "Jokowi", "SBY", "Ir Soekarno"},
            {"Megawati", "Prabowo", "BJ Habibi", "Jokowi"},
            {"1949", "1935", "1945", "1942"}
    };

    private String mCorrectAnswer[] = {"merah - putih", "Ir Soekarno", "Jokowi", "1945"};

    public int getLength() {
        return textQuestion.length;
    }

    public String getQuestion(int a){
        String question = textQuestion[a];
        return question;
    }

    public String getChoice (int index, int num){
        String choice = multipleChoice[index][num-1];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }


}
