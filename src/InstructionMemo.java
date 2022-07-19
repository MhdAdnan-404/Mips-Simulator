import java.util.ArrayList;

public class InstructionMemo {
	static ArrayList<String> instructionlst = new ArrayList<String>();
	static int adrs = 0;
	static String address = "";
	static String instruciton = "";
	static String destinationRegister = "";
	static String sourceRegister1 = "";
	static String sourceRegister2 = ""; 
	//use in case of LW/Sw
	static int offset = 0;
	//Use in case of I instructions
	static int immidiate = 0;
	
	public static void seperateInstruction() {
		System.out.println("hello");
		for (int i = 0; i < instructionlst.size(); i+=5) {
			if (Alu.didBeq) {
				i = adrs;
				System.out.println("adrs intsruction memo " + adrs);
			}
		
			instruciton = instructionlst.get(i+1);
			System.out.println(instruciton + " instruction ");
		
				
			
			if (instruciton.toLowerCase().equals("add")) {
				address = instructionlst.get(i);
				System.out.println(address + " address register");
				
				
				destinationRegister = instructionlst.get(i+2);
				System.out.println(destinationRegister + " destination register");
				
				
				sourceRegister1 = instructionlst.get(i+3);
				System.out.println(sourceRegister1 + " src1");
			sourceRegister2 = instructionlst.get(i+4);
			System.out.println(sourceRegister2 + " src2");
			
			}else if(instruciton.toLowerCase().equals("addi")) {
				address = instructionlst.get(i);
				System.out.println(address + " address register");
				
				
				destinationRegister = instructionlst.get(i+2);
				System.out.println(destinationRegister + " destination register");
				
				
				sourceRegister1 = instructionlst.get(i+3);
				System.out.println(sourceRegister1 + " src1");
				immidiate = Integer.valueOf(instructionlst.get(i+4));
				System.out.println("addi");
				
			}else if (instruciton.toLowerCase().equals("sll")) {
				address = instructionlst.get(i);
				System.out.println(address + " address register");
				
				destinationRegister = instructionlst.get(i+2);
				System.out.println(destinationRegister + " destination register");
				
				
				sourceRegister1 = instructionlst.get(i+3);
				System.out.println(sourceRegister1 + " src1");
				immidiate = Integer.valueOf(instructionlst.get(i+4));
				
			}else if (instruciton.toLowerCase().equals("slt")) {
				address = instructionlst.get(i);
				System.out.println(address + " address register");
				
				destinationRegister = instructionlst.get(i+2);
				System.out.println(destinationRegister + " destination register");
				
				
				sourceRegister1 = instructionlst.get(i+3);
				System.out.println(sourceRegister1 + " src1");
				sourceRegister2 = instructionlst.get(i+4);
				
			}else if (instruciton.toLowerCase().equals("beq")) {
				
				address = instructionlst.get(i+4);
				sourceRegister1 = instructionlst.get(i+2);
				sourceRegister2 = instructionlst.get(i+3);
				System.out.println(address + " address");
				System.out.println(sourceRegister1 + " source register1");
				System.out.println(sourceRegister2 + " source register 2");
				
			}else if (instruciton.toLowerCase().equals("lw")) {
				address = instructionlst.get(i);
				System.out.println(address + " address register");
				destinationRegister = instructionlst.get(i+2);
				System.out.println(destinationRegister + " destination register");
				sourceRegister1 = instructionlst.get(i+3);
				System.out.println(sourceRegister1 + " src1");
				offset = Integer.valueOf(instructionlst.get(i+4));
				
			}else if(instruciton.toLowerCase().equals("sw")){
				address = instructionlst.get(i);
				System.out.println(address + " address register");
				destinationRegister = instructionlst.get(i+2);
				System.out.println(destinationRegister + " destination register");
				sourceRegister1 = instructionlst.get(i+3);
				System.out.println(sourceRegister1 + " src1");
				offset = Integer.valueOf(instructionlst.get(i+4));
			}
			
			if (instruciton.toLowerCase().equals("add")) {
				Alu.add(destinationRegister, sourceRegister1, sourceRegister2);
			}else if (instruciton.toLowerCase().equals("addi")) {
				Alu.addi(destinationRegister, sourceRegister1, immidiate);
			}else if (instruciton.toLowerCase().equals("sll")) {
				Alu.sll(destinationRegister, sourceRegister1, immidiate);
			}else if(instruciton.toLowerCase().equals("slt")){
				Alu.slt(destinationRegister, sourceRegister1, sourceRegister2);
			}else if (instruciton.toLowerCase().equals("beq")) {
				Alu.beq(address, sourceRegister1, sourceRegister1);
			}else if(instruciton.toLowerCase().equals("lw")) {
				Alu.lw(destinationRegister, sourceRegister1, offset);
		    }else if(instruciton.toLowerCase().equals("sw")) {
		    	Alu.sw(destinationRegister, sourceRegister1, offset);
		    }
	}
  }
}