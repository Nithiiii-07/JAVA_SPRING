import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class QuestionService {
    Questions[] arr=new Questions[5];
    List<String> res=new ArrayList<>();
    public QuestionService(){
        arr[0]= new Questions("1","What is the capital of India?","Delhi","Mumbai","Chennai","Kolkata","Delhi");
        arr[1] = new Questions("2","What is the capital of Maharashtra?","Mumbai","Delhi","Chennai","Kolkata","Mumbai");
        arr[2] = new Questions("3","What is the capital of Tamil Nadu?","Chennai","Delhi","Mumbai","Kolkata","Chennai");
        arr[3] = new Questions("4","What is the capital of Karnataka?","Bengaluru","Delhi","Mumbai","Kolkata","Bengaluru");
        arr[4] = new Questions("5","What is the capital of Kerala?","Thiruvananthapuram","Delhi","Mumbai","Kolkata","Thiruvananthapuram");
    }
    void playQuiz(){
        Scanner sc=new Scanner(System.in);
        int i=0;
        while(i<5){
            Questions curr=arr[i];
            System.out.println(curr.getId()+" "+curr.getQuestion());
            System.out.print(curr.getOpt1() + " "+ curr.getOpt2()+" "+ curr.getOpt3()+" "+ curr.getOpt4());
            String resp=sc.nextLine();
            res.add(resp);
            i++;
        }
        sc.close();
    }
    int CalcScore(){
        
        return 0;
    }
}
