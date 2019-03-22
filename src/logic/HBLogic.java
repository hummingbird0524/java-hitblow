package logic;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Hit＆Blow 内部処理Class
 * 
 * @author	y_nishikawa
 */
public class HBLogic{
	/** 生成文字列桁数 */
	private static final int	GENERATE_LENGTH = 4;
	
	// ==============================================================================================================
	
	/**
	 * 正解文字列生成
	 * 
	 * @return		(String)正解文字列
	 */
	public static String generateAnswer(){
		int[]	iarNum = {0,1,2,3,4,5,6,7,8,9};
		int		a;
		int		b;
		int		temp;
		
		for(int i=0; i<GENERATE_LENGTH; i++){
			a = (int)(Math.random()*10);
			b = (int)(Math.random()*10);
			
			// 配列内で数値を並べ替える
			temp      = iarNum[a];
			iarNum[a] = iarNum[b];
			iarNum[b] = temp;
		}
		
		StringBuffer	sbGen = new StringBuffer();
		
		for(int i=0; i<GENERATE_LENGTH; i++){
			// 並べ替えた配列の先頭から取得する
			sbGen.append(String.valueOf(iarNum[i]));
		}
		
		System.out.println("[-- Debug --] Answer is " + sbGen.toString());
		
		return	sbGen.toString();
	}
	
//	/**
//	 * 入力文字列チェック
//	 * 
//	 * @param	inputStr	(String)入力文字列
//	 * @throws				(IllegalArgumentException)
//	 */
//	public static void checkStr(String inputStr) throws IllegalArgumentException{
//		if(inputStr == null || "".equals(inputStr)){
//			// 未入力の場合
//			throw	new IllegalArgumentException("未入力です！");
//			
//		}else if(inputStr.length() != GENERATE_LENGTH){
//			// 文字長が異なる場合
//			throw	new IllegalArgumentException("入力文字数がおかしいです！");
//			
//		}else{
//			try{
//				Integer.parseInt(inputStr);
//				
//			}catch(NumberFormatException nfe){
//				// 数字以外が入力されている場合
//				throw	new IllegalArgumentException("数字以外が入力されています！");
//			}
//			
//			HashSet<String>	hs = new HashSet<>();
//			
//			for(int i=0; i<inputStr.length(); i++){
//				hs.add(inputStr.substring(i, i+1));
//			}
//			
//			if(hs.size() != GENERATE_LENGTH){
//				// 数字が重複している場合
//				throw	new IllegalArgumentException("数字が重複しています！");
//			}
//		}
//	}
	
	/**
	 * 入力文字列チェック
	 * 
	 * @param	inputStr	(String)入力文字列
	 * @return	(String)	メッセージ
	 * @throws				(IllegalArgumentException)
	 */
	public static String checkStr(String inputStr) throws IllegalArgumentException{
		if(inputStr == null || "".equals(inputStr)){
			// 未入力の場合
			return	"未入力です！";
			
		}else if(inputStr.length() != GENERATE_LENGTH){
			// 文字長が異なる場合
			return	"入力文字数がおかしいです！";
			
		}else{
			try{
				Integer.parseInt(inputStr);
				
			}catch(NumberFormatException nfe){
				// 数字以外が入力されている場合
				return	"数字以外が入力されています！";
			}
			
			HashSet<String>	hs = new HashSet<>();
			
			for(int i=0; i<inputStr.length(); i++){
				hs.add(inputStr.substring(i, i+1));
			}
			
			if(hs.size() != GENERATE_LENGTH){
				// 数字が重複している場合
				return	"数字が重複しています！";
			}
		}
		
		return	null;
	}
	
	/**
	 * 正解チェック
	 * 
	 * @param	inputStr	(String)入力文字列
	 * @return				(HashMap<String, Object>)結果
	 */
	public static HashMap<String, Object> checkAnswer(String inputStr, String answerStr){
		HashMap<String, Object>	result = new HashMap<>();
		
		int			hit       = 0;
		int			blow      = 0;
		boolean	chkResult = false;
		
		for(int i=0; i<GENERATE_LENGTH; i++){
			if(inputStr.charAt(i) == answerStr.charAt(i)){
				// Hit(数字一致・桁一致)
				hit++;
				
			}else if(answerStr.indexOf(inputStr.charAt(i)) >= 0){
				// Blow(数字一致・桁不一致)
				blow++;
			}
		}
		
		// クリアチェック
		if(hit == GENERATE_LENGTH){
			chkResult = true;
		}
		
		result.put("result", chkResult);
		result.put("hit",    hit);
		result.put("blow",   blow);
		
		return	result;
	}
}
