import java.time.OffsetDateTime;

import javax.print.attribute.standard.Destination;

public class Alu {
	public static boolean didBeq;
	
	//gets called by the excute b
	public static void excuteInstruction() {
		InstructionMemo.seperateInstruction();
		
	}
	public static void add(String dest,String src1, String src2) {
		int first_value = RegFile.registers.get(src1);
		int second_value = RegFile.registers.get(src2);
		int result = first_value + second_value;
		RegFile.registers.put(dest, result);
		Main.populateRegistersLbl();
		
	}
	public static void addi(String dest, String src1, int immidiate) {
		int first_value = RegFile.registers.get(src1);
		int second_value = immidiate;
		int result = first_value + second_value;
		RegFile.registers.put(dest, result);
		Main.populateRegistersLbl();
	}
	public static void sll(String dest, String src1, int immidiate) {
		int first_value = RegFile.registers.get(src1);
		int second_value = immidiate;
		int result = (int) (first_value * Math.pow(2, immidiate));
		RegFile.registers.put(dest, result);
		Main.populateRegistersLbl();
		System.out.println(result);
	}
	public static void slt(String dest, String src1, String src2) {
		int first_value = RegFile.registers.get(src1);
		int second_value = RegFile.registers.get(src2);
		int result = 0;
		if(first_value < second_value) {
			result = 1;
		}else {
			result = 0;
		}
		RegFile.registers.put(dest, result);
		System.out.println(result);
		Main.populateRegistersLbl();
		
	}
	public static void beq(String destination, String src1, String src2) {
		
		System.out.println("beq");
		didBeq =true;
		int first_value = RegFile.registers.get(src1);
		int second_value = RegFile.registers.get(src2);
		int destination_i_value = 0;
		if (first_value == second_value) {
			int x = InstructionMemo.instructionlst.lastIndexOf(destination);
				destination_i_value = x;
			int adrs_value = destination_i_value;
			InstructionMemo.adrs = adrs_value;
			System.out.println(adrs_value + "adrs value");
		}
		Main.populateRegistersLbl();
	}
	public static void lw(String destination, String src1, int offset) {
		int first_value = RegFile.registers.get(src1);
		int second_value = offset;
		int result = first_value + second_value;
		int memo_value = dataMemory.dataMemo.get(result);
		RegFile.registers.put(destination, memo_value);
		Main.populateRegistersLbl();
		
	}
	public static void sw(String saveRegister, String src1, int offset) {
		int first_value = RegFile.registers.get(src1);
		int second_value = offset;
		int saveReg = RegFile.registers.get(saveRegister);
		int result = first_value + second_value;
		dataMemory.dataMemo.put(result, saveReg);
		Main.populateDataMemoLbl();
		
	}
	
	
}
