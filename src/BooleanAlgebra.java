
public class BooleanAlgebra {

	static final String CONST_and="And";
	static final String CONST_or="Or";
	static final String CONST_true="True";
	static final String CONST_false="False";
	
	
	public static void main(String[] args) {
		
		System.out.println(booleanAlgebra("False")==false);
		System.out.println(booleanAlgebra("True")==true);
		
		System.out.println(booleanAlgebra("False And False")==false);
		System.out.println(booleanAlgebra("True And False")==false);
		System.out.println(booleanAlgebra("True And True")==true);
		System.out.println(booleanAlgebra("False And True")==false);
		
		System.out.println(booleanAlgebra("(False And True)")==false);
		System.out.println(booleanAlgebra("True Or (False And True)")==true);
		System.out.println(booleanAlgebra("(True And False) And (False And True) Or True")==true);
		
		System.out.println(booleanAlgebra("( (True And False) Or True )")==true);
		
		System.out.println(booleanAlgebra("( False Or (True And (False Or True)) Or True )")==true);
		
		
		
		
	}
	

	
	
	static boolean booleanAlgebra(String str){
		return TrueFalse(str, false, "Or");
	}
	
	
	 static boolean TrueFalse(String s,boolean b, String op){
		boolean btemp=false;
		s=s.replaceAll(" ", "");
		
		while(!s.isEmpty()){
			
			if(s.startsWith(CONST_true)){
				btemp=true;
				s=s.substring(4);
			}else if(s.startsWith(CONST_false)){
				btemp=false;
				s=s.substring(5);
			}else if(s.startsWith(CONST_and)){
				op=CONST_and;
				s=s.substring(3);
			}else if(s.startsWith(CONST_or)){
				op=CONST_or;
				s=s.substring(2);
			}else if(s.startsWith("(")){
				int end=s.indexOf(")");
				if(end>0){
				b=TrueFalse(s.substring(1, end>-1?end:1),b,op);
				s=s.substring(end);
				}
			}else{
				s=s.substring(1);
			}
			if (op.equals(CONST_and)){
				b=b&&btemp;
				
			}else if(op.equals(CONST_or)){
				b=b||btemp;
			}	
		}
		return b;	
	}
}
