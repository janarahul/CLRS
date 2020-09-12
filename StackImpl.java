import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	Input 
		size of stack
		+number to push -numberOfTimesToCallPop
	Example
		5
		+1 +5 +7 +8 -2 +9 
	Output->
		[1,5,9]
*/
class Stack{
	int[] S;
	int top;
	Stack(int size){
		this.S = new int[size];
		this.top = -1;
	}
	public String toString(){
		return Arrays.toString(Arrays.copyOfRange(S,0,top+1));
	}
	boolean stackEmpty(){
		if (top == -1){
			return true;
		}else{
			return false;
		}
	}
	boolean stackFull(){
		if((S.length-1) == top){
			return true;
		}
		return false;
	}
	void push(int element){
		if(stackFull()){
			System.out.println("StackOverflow");
		}else{
			top = top+1;
			S[top] = element;
		}
	}
	int pop(){
		if(stackEmpty()){
			System.out.println("Stack Underflow");
			return -1;
		}else{
			int e = S[top];
			top = top-1;
			return e;
		}
	}
}

class StackImpl{
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Stack s = new Stack(size);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stream.of(br.readLine().split("\\s+")).forEach(string -> {
			Matcher push_matcher = Pattern.compile("([+])([0-9]+)").matcher(string);
			Matcher pop_matcher = Pattern.compile("([-])([0-9]+)").matcher(string);
			if (push_matcher.matches()){
				s.push(Integer.parseInt(push_matcher.group(2)));
			}else if(pop_matcher.matches()){
				for(int i =0;i<Integer.parseInt(pop_matcher.group(2));i++){
					s.pop();
				}
			}
		});
		System.out.println(s);
	}
}
